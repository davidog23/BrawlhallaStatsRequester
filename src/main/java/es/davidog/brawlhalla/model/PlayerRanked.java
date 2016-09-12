package es.davidog.brawlhalla.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by David on 12/09/2016.
 */
public class PlayerRanked {
    private static final Logger logger = LoggerFactory.getLogger(PlayerRanked.class);

    private String name;
    private long brawlhalla_id;
    private int rating, peak_rating;
    private String tier;
    private int wins, games;
    private String region;
    private long global_rank, region_reank;
    private PlayerRankedLegend[] legends;
}
