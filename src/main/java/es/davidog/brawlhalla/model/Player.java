package es.davidog.brawlhalla.model;

import es.davidog.brawlhalla.util.FormatterUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * Created by David on 12/09/2016.
 */
public class Player {
    private static final Logger logger = LoggerFactory.getLogger(Player.class);

    private long brawlhalla_id;
    private String name;
    private long xp;
    private int level;
    private double xp_percentage;
    private int games;
    private int wins;
    private String damagebomb, damagemine, damagespikeball, damagesidekick;
    private int hitsnowball, kobomb, komine, kospikeball, kosidekick, kosnowball;
    private PlayerLegend[] legends;
    private PlayerClan clan;

    public double getWinRate() {
        return FormatterUtil.formatUnitaryToPercentage((double)wins/games);
    }

    public PlayerLegend mostPlayedLegend() {
        return legends.length > 0 ? legends[0] : null;
    }

    public String getFormattedMatchtime() {
        int seconds = 0;
        for(PlayerLegend l : legends) {
            seconds += l.getMatchtime();
        }
        return FormatterUtil.formatSeconds(seconds);
    }

    public long getBrawlhalla_id() {
        return brawlhalla_id;
    }

    public void setBrawlhalla_id(long brawlhalla_id) {
        this.brawlhalla_id = brawlhalla_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getXp() {
        return xp;
    }

    public void setXp(long xp) {
        this.xp = xp;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public double getXp_percentage() {
        return xp_percentage;
    }

    public void setXp_percentage(double xp_percentage) {
        this.xp_percentage = xp_percentage;
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

    public String getDamagebomb() {
        return damagebomb;
    }

    public void setDamagebomb(String damagebomb) {
        this.damagebomb = damagebomb;
    }

    public String getDamagemine() {
        return damagemine;
    }

    public void setDamagemine(String damagemine) {
        this.damagemine = damagemine;
    }

    public String getDamagespikeball() {
        return damagespikeball;
    }

    public void setDamagespikeball(String damagespikeball) {
        this.damagespikeball = damagespikeball;
    }

    public String getDamagesidekick() {
        return damagesidekick;
    }

    public void setDamagesidekick(String damagesidekick) {
        this.damagesidekick = damagesidekick;
    }

    public int getHitsnowball() {
        return hitsnowball;
    }

    public void setHitsnowball(int hitsnowball) {
        this.hitsnowball = hitsnowball;
    }

    public int getKobomb() {
        return kobomb;
    }

    public void setKobomb(int kobomb) {
        this.kobomb = kobomb;
    }

    public int getKomine() {
        return komine;
    }

    public void setKomine(int komine) {
        this.komine = komine;
    }

    public int getKospikeball() {
        return kospikeball;
    }

    public void setKospikeball(int kospikeball) {
        this.kospikeball = kospikeball;
    }

    public int getKosidekick() {
        return kosidekick;
    }

    public void setKosidekick(int kosidekick) {
        this.kosidekick = kosidekick;
    }

    public int getKosnowball() {
        return kosnowball;
    }

    public void setKosnowball(int kosnowball) {
        this.kosnowball = kosnowball;
    }

    public PlayerLegend[] getLegends() {
        return legends;
    }

    public void setLegends(PlayerLegend[] legends) {
        this.legends = legends;
        Arrays.parallelSort(this.legends, (legend1, legend2) -> legend2.getGames() - legend1.getGames());
    }

    public PlayerClan getClan() {
        return clan;
    }

    public void setClan(PlayerClan clan) {
        this.clan = clan;
    }
}
