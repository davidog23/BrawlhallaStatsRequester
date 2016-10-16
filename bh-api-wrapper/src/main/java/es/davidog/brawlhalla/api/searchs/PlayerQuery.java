package es.davidog.brawlhalla.api.searchs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by David on 13/09/2016.
 */
public class PlayerQuery {
    private static final Logger logger = LoggerFactory.getLogger(PlayerQuery.class);

    private String name;
    private String region;

    public PlayerQuery(String name, String region) {
        this.name = name;
        this.region = region;
    }

    public PlayerQuery() {
        this("", "all");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}
