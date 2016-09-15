package es.davidog.brawlhalla.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

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
    private long global_rank, region_rank;
    private PlayerRankedLegend[] legends;

    public double getWinRate() {
        return ((int)(((double)wins/games)*10000))/100.0;
    }

    public PlayerRankedLegend mostPlayedLegend() {
        return Arrays.stream(legends)
                .max((legend1, legend2) -> legend1.getGames() - legend2.getGames()).get();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBrawlhalla_id(long brawlhalla_id) {
        this.brawlhalla_id = brawlhalla_id;
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

    public void setRegion(String region) {
        this.region = region;
    }

    public void setGlobal_rank(long global_rank) {
        this.global_rank = global_rank;
    }

    public void setRegion_rank(long region_rank) {
        this.region_rank = region_rank;
    }

    public void setLegends(PlayerRankedLegend[] legends) {
        this.legends = legends;
    }
}
