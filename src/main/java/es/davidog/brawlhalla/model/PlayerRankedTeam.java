package es.davidog.brawlhalla.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by David on 12/09/2016.
 */
public class PlayerRankedTeam {
    private static final Logger logger = LoggerFactory.getLogger(PlayerRankedTeam.class);

    private long brawlhalla_id_one, brawlhalla_id_two;
    private int rating, peak_rating;
    private String tier;
    private int wins, games;
    private String teamname;
    private long global_rank;

    public double getWinRate() {
        return (double)wins/games;
    }
}
