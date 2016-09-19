package es.davidog.brawlhalla.model.searchs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by David on 13/09/2016.
 */
public class RankingEntry {
    private static final Logger logger = LoggerFactory.getLogger(RankingEntry.class);

    private long rank;
    private String name;
    private long brawlhalla_id;
    private int best_legend;
    private int best_legend_games, best_legend_wins;
    private int rating;
    private String tier;
    private int games, wins;
    private String region;
    private int peak_rating;

    public double getWinRate() {
        return ((int)(((double)wins/games)*10000))/100.0;
    }

    public long getRank() {
        return rank;
    }

    public void setRank(long rank) {
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getBrawlhalla_id() {
        return brawlhalla_id;
    }

    public void setBrawlhalla_id(long brawlhalla_id) {
        this.brawlhalla_id = brawlhalla_id;
    }

    public int getBest_legend() {
        return best_legend;
    }

    public void setBest_legend(int best_legend) {
        this.best_legend = best_legend;
    }

    public int getBest_legend_games() {
        return best_legend_games;
    }

    public void setBest_legend_games(int best_legend_games) {
        this.best_legend_games = best_legend_games;
    }

    public int getBest_legend_wins() {
        return best_legend_wins;
    }

    public void setBest_legend_wins(int best_legend_wins) {
        this.best_legend_wins = best_legend_wins;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getTier() {
        return tier;
    }

    public void setTier(String tier) {
        this.tier = tier;
    }

    public int getGames() {
        return games;
    }

    public void setGames(int games) {
        this.games = games;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public int getPeak_rating() {
        return peak_rating;
    }

    public void setPeak_rating(int peak_rating) {
        this.peak_rating = peak_rating;
    }
}
