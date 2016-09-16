package es.davidog.brawlhalla.model;

import es.davidog.brawlhalla.util.FormatterUtil;
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
        return FormatterUtil.formatUnitaryToPercentage((double)wins/games);
    }

    public String getFormattedName() {
        return FormatterUtil.capitalizeFirstLetters(legend_name_key);
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

    public int getLegend_id() {
        return legend_id;
    }

    public String getLegend_name_key() {
        return legend_name_key;
    }

    public int getRating() {
        return rating;
    }

    public int getPeak_rating() {
        return peak_rating;
    }

    public String getTier() {
        return tier;
    }

    public int getWins() {
        return wins;
    }

    public int getGames() {
        return games;
    }
}
