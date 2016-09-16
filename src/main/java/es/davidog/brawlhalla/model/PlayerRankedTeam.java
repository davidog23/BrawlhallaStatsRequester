package es.davidog.brawlhalla.model;

import es.davidog.brawlhalla.util.FormatterUtil;
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
        return FormatterUtil.formatUnitaryToPercentage((double)wins/games);
    }

    public long getBrawlhalla_id_one() {
        return brawlhalla_id_one;
    }

    public void setBrawlhalla_id_one(long brawlhalla_id_one) {
        this.brawlhalla_id_one = brawlhalla_id_one;
    }

    public long getBrawlhalla_id_two() {
        return brawlhalla_id_two;
    }

    public void setBrawlhalla_id_two(long brawlhalla_id_two) {
        this.brawlhalla_id_two = brawlhalla_id_two;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getPeak_rating() {
        return peak_rating;
    }

    public void setPeak_rating(int peak_rating) {
        this.peak_rating = peak_rating;
    }

    public String getTier() {
        return tier;
    }

    public void setTier(String tier) {
        this.tier = tier;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getGames() {
        return games;
    }

    public void setGames(int games) {
        this.games = games;
    }

    public String getTeamname() {
        return teamname;
    }

    public void setTeamname(String teamname) {
        this.teamname = teamname;
    }

    public long getGlobal_rank() {
        return global_rank;
    }

    public void setGlobal_rank(long global_rank) {
        this.global_rank = global_rank;
    }
}
