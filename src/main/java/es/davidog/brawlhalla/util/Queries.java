package es.davidog.brawlhalla.util;

import es.davidog.brawlhalla.MainClass;
import es.davidog.brawlhalla.model.Player;
import es.davidog.brawlhalla.model.PlayerRanked;
import es.davidog.brawlhalla.model.RankingEntry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

/**
 * Created by David on 13/09/2016.
 */
public class Queries {
    private static final Logger logger = LoggerFactory.getLogger(Queries.class);
    private static final RestTemplate rest = new RestTemplate();

    private static HttpHeaders getCorrectHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("User-Agent", "BrawlhallaStatsRequester");
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        return headers;
    }

    private static <T> T checkResponse(ResponseEntity<T> apiResponse) {
        if (apiResponse.getStatusCode().is2xxSuccessful()) {
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
}
