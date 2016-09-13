package es.davidog.brawlhalla.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by David on 12/09/2016.
 */
public class PlayerRankedLegend {
    private static final Logger logger = LoggerFactory.getLogger(PlayerRankedLegend.class);

    private int legend_id;
    private String legend_name_key;
    private int rating, peak_rating;
    private String tier;
    private int wins, games;

    public double getWinRate() {
        return (double)wins/games;
    }

    public void setLegend_id(int legend_id) {
        this.legend_id = legend_id;
    }

    public void setLegend_name_key(String legend_name_key) {
        this.legend_name_key = legend_name_key;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setPeak_rating(int peak_rating) {
        this.peak_rating = peak_rating;
    }

    public void setTier(String tier) {
        this.tier = tier;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public void setGames(int games) {
        this.games = games;
    }
}
