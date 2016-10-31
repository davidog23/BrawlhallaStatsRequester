package es.davidog.brawlhalla.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import es.davidog.brawlhalla.MainClass;
import es.davidog.brawlhalla.api.FormatterUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Collections;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by David on 13/09/2016.
 */
public class Queries {
    private static final Logger logger = LoggerFactory.getLogger(Queries.class);
    public static final int REQUEST_PER_15MIN = 180;
    public static final AtomicInteger REQUESTS = new AtomicInteger();
    private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    static {
        scheduler.scheduleAtFixedRate(() -> {
            if (REQUESTS.get() >= REQUEST_PER_15MIN) {
                logger.warn("PETICIONES MÁXIMAS PERMITIDAS A LA API REALIZADAS");
            }
            REQUESTS.set(0);
        }, 0, 15, TimeUnit.MINUTES);
    }

    private static HttpHeaders getCorrectHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("User-Agent", "BrawlhallaStatsRequester");
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        return headers;
    }

    private static <T> T checkResponse(ResponseEntity<String> apiResponse, Class<T> clazz) {
        if (apiResponse.getStatusCode() == HttpStatus.OK) {
            int calls = REQUESTS.incrementAndGet();
            logger.debug("En estos 15 minutos han habido " + calls + "/" + REQUEST_PER_15MIN + " peticiones");
            ObjectMapper mapper = new ObjectMapper();
            T object = null;
            try {
                object = mapper.readValue(FormatterUtil.escapeHexUtf8ToString(apiResponse.getBody()), clazz);
            } catch (IOException e) {
                logger.warn("No se ha podido parsear la respuesta del servidor", e);
            }
            return object;
        } else {
            logger.warn(apiResponse.getStatusCode().getReasonPhrase());
            throw new HttpStatusCodeException(apiResponse.getStatusCode()) {};
        }
    }

    public static String getPlayer(long id) {
        StringBuilder builder = new StringBuilder("https://api.brawlhalla.com/player/");
        builder.append(Long.toString(id));
        builder.append("/stats?api_key=");
        builder.append(MainClass.TOKEN);
        return builder.toString();
    }

    public static String getPlayerRanked(long id) {
        StringBuilder builder = new StringBuilder("https://api.brawlhalla.com/player/");
        builder.append(Long.toString(id));
        builder.append("/ranked?api_key=");
        builder.append(MainClass.TOKEN);
        return builder.toString();
    }

    public static String getRankingEntries(String name, String table) {
        StringBuilder builder = new StringBuilder("https://api.brawlhalla.com/rankings/1v1/");
        builder.append(table);
        builder.append("/1?name=");
        builder.append(name);
        builder.append("&api_key=");
        builder.append(MainClass.TOKEN);
        return builder.toString();
    }

    public static String getClan(long id) {
        StringBuilder builder = new StringBuilder("https://api.brawlhalla.com/clan/");
        builder.append(Long.toString(id));
        builder.append("/?api_key=");
        builder.append(MainClass.TOKEN);
        return builder.toString();
    }

    public static <T> T getResponse(String path, Class<T> clazz) {
        RestTemplate rest = new RestTemplate();
        rest.getMessageConverters().add(0, new StringHttpMessageConverter());
        ResponseEntity<String> jsonResponse = rest.exchange(path, HttpMethod.GET, new HttpEntity<String>(getCorrectHeaders()), String.class);

        return checkResponse(jsonResponse, clazz);
    }
}
