package es.davidog.brawlhalla.util;

import es.davidog.brawlhalla.MainClass;
import es.davidog.brawlhalla.api.clans.Clan;
import es.davidog.brawlhalla.api.general.Player;
import es.davidog.brawlhalla.api.ranked.PlayerRanked;
import es.davidog.brawlhalla.api.searchs.RankingEntry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

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
    private static final RestTemplate rest = new RestTemplate();
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

    private static <T> T checkResponse(ResponseEntity<T> apiResponse) {
        if (apiResponse.getStatusCode().is2xxSuccessful()) {
            int calls = REQUESTS.incrementAndGet();
            logger.debug("En estos 15 minutos han habido " + calls + "/" + REQUEST_PER_15MIN + " peticiones");
            return apiResponse.getBody();
        } else {
            logger.warn(apiResponse.getStatusCode().getReasonPhrase());
            throw new HttpStatusCodeException(apiResponse.getStatusCode()) {};
        }
    }

    public static Player getPlayer(long id) {
        StringBuilder builder = new StringBuilder("https://api.brawlhalla.com/player/");
        builder.append(Long.toString(id));
        builder.append("/stats?api_key=");
        builder.append(MainClass.TOKEN);
        ResponseEntity<Player> apiResponse = rest.exchange(builder.toString(), HttpMethod.GET, new HttpEntity<String>(getCorrectHeaders()), Player.class);
        return checkResponse(apiResponse);
    }

    public static PlayerRanked getPlayerRanked(long id) {
        StringBuilder builder = new StringBuilder("https://api.brawlhalla.com/player/");
        builder.append(Long.toString(id));
        builder.append("/ranked?api_key=");
        builder.append(MainClass.TOKEN);
        ResponseEntity<PlayerRanked> apiResponse = rest.exchange(builder.toString(), HttpMethod.GET, new HttpEntity<String>(getCorrectHeaders()), PlayerRanked.class);
        return checkResponse(apiResponse);
    }

    public static RankingEntry[] getRankingEntries(String name, String table) {
        StringBuilder builder = new StringBuilder("https://api.brawlhalla.com/rankings/1v1/");
        builder.append(table);
        builder.append("/1?name=");
        builder.append(name);
        builder.append("&api_key=");
        builder.append(MainClass.TOKEN);
        ResponseEntity<RankingEntry[]> apiResponse = rest.exchange(builder.toString(), HttpMethod.GET, new HttpEntity<String>(getCorrectHeaders()), RankingEntry[].class);
        return checkResponse(apiResponse);
    }

    public static Clan getClan(long id) {
        StringBuilder builder = new StringBuilder("https://api.brawlhalla.com/clan/");
        builder.append(Long.toString(id));
        builder.append("/?api_key=");
        builder.append(MainClass.TOKEN);
        ResponseEntity<Clan> apiResponse = rest.exchange(builder.toString(), HttpMethod.GET, new HttpEntity<String>(getCorrectHeaders()), Clan.class);
        return checkResponse(apiResponse);
    }
}
