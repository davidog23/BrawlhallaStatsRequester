package es.davidog.brawlhalla.api.ranked;

import com.fasterxml.jackson.annotation.JsonProperty;
import es.davidog.brawlhalla.api.FormatterUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.stream.Collectors;

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
    @JsonProperty("2v2")
    private PlayerRankedTeam[] teams;

    public PlayerRanked() {
        name = "";
        tier = "Undefined";
        region = "Undefined";
    }

    public boolean hasAnyTeam() {
        return teams != null && teams.length > 0;
    }

    public double getWinRate() {
        return FormatterUtil.formatUnitaryToPercentage((double)wins/games);
    }

    public PlayerRankedLegend mostPlayedLegend() {
        return (legends != null) && (legends.length > 0) ? legends[0] : null;
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
        Arrays.parallelSort(this.legends, (legend1, legend2) -> legend2.getGames() - legend1.getGames());
    }

    public void setTeams(PlayerRankedTeam[] teams) {
        int nITeams = teams.length;
        this.teams = Arrays.stream(teams).filter(team -> team.getNames().length == 2).collect(Collectors.toList()).toArray(new PlayerRankedTeam[0]);
        if (nITeams != this.teams.length) logger.info("The player " + name + "(" + brawlhalla_id + ") has a team not reflected in the web");
        Arrays.parallelSort(this.teams, (team1, team2) -> team2.getRating() - team1.getRating());
    }

    public String getName() {
        return name;
    }

    public long getBrawlhalla_id() {
        return brawlhalla_id;
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

    public String getRegion() {
        return region;
    }

    public long getGlobal_rank() {
        return global_rank;
    }

    public long getRegion_rank() {
        return region_rank;
    }

    public PlayerRankedLegend[] getLegends() {
        return legends;
    }

    public PlayerRankedTeam[] getTeams() {
        return teams;
    }
}
