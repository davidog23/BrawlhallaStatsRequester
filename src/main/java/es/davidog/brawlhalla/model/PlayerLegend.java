package es.davidog.brawlhalla.model;

import es.davidog.brawlhalla.util.FormatterUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by David on 12/09/2016.
 */
public class PlayerLegend {
    private static final Logger logger = LoggerFactory.getLogger(PlayerLegend.class);

    private int legend_id;
    private String legend_name_key;
    private String damagedealt, damagetaken;
    private int kos, falls, suicides, teamkos;
    private int matchtime;
    private int games, wins;
    private String damageunarmed, damagethrownitem, damageweaponone, damageweapontwo, damagegadgets;
    private int kounarmed, kothrownitem, koweaponone, koweapontwo, kogadgets;
    private int timeheldweaponone, timeheldweapontwo;
    private int xp;
    private int level;
    private double xp_percentage;

    public String getFormattedMatchtime() {
        return FormatterUtil.formatSeconds(matchtime);
    }

    public String getFormattedTimeHeldWeaponOne() {
        return FormatterUtil.formatSeconds(timeheldweaponone);
    }

    public String getFormattedTimeHeldWeaponTwo() {
        return FormatterUtil.formatSeconds(timeheldweapontwo);
    }

    public String getFormattedName() {
        return FormatterUtil.capitalizeFirstLetters(legend_name_key);
    }

    public double getWinRate() {
        return FormatterUtil.formatUnitaryToPercentage((double)wins/games);
    }

    public int getLegend_id() {
        return legend_id;
    }

    public void setLegend_id(int legend_id) {
        this.legend_id = legend_id;
    }

    public String getLegend_name_key() {
        return legend_name_key;
    }

    public void setLegend_name_key(String legend_name_key) {
        this.legend_name_key = legend_name_key;
    }

    public String getDamagedealt() {
        return damagedealt;
    }

    public void setDamagedealt(String damagedealt) {
        this.damagedealt = damagedealt;
    }

    public String getDamagetaken() {
        return damagetaken;
    }

    public void setDamagetaken(String damagetaken) {
        this.damagetaken = damagetaken;
    }

    public int getKos() {
        return kos;
    }

    public void setKos(int kos) {
        this.kos = kos;
    }

    public int getFalls() {
        return falls;
    }

    public void setFalls(int falls) {
        this.falls = falls;
    }

    public int getSuicides() {
        return suicides;
    }

    public void setSuicides(int suicides) {
        this.suicides = suicides;
    }

    public int getTeamkos() {
        return teamkos;
    }

    public void setTeamkos(int teamkos) {
        this.teamkos = teamkos;
    }

    public int getMatchtime() {
        return matchtime;
    }

    public void setMatchtime(int matchtime) {
        this.matchtime = matchtime;
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

    public String getDamageunarmed() {
        return damageunarmed;
    }

    public void setDamageunarmed(String damageunarmed) {
        this.damageunarmed = damageunarmed;
    }

    public String getDamagethrownitem() {
        return damagethrownitem;
    }

    public void setDamagethrownitem(String damagethrownitem) {
        this.damagethrownitem = damagethrownitem;
    }

    public String getDamageweaponone() {
        return damageweaponone;
    }

    public void setDamageweaponone(String damageweaponone) {
        this.damageweaponone = damageweaponone;
    }

    public String getDamageweapontwo() {
        return damageweapontwo;
    }

    public void setDamageweapontwo(String damageweapontwo) {
        this.damageweapontwo = damageweapontwo;
    }

    public String getDamagegadgets() {
        return damagegadgets;
    }

    public void setDamagegadgets(String damagegadgets) {
        this.damagegadgets = damagegadgets;
    }

    public int getKounarmed() {
        return kounarmed;
    }

    public void setKounarmed(int kounarmed) {
        this.kounarmed = kounarmed;
    }

    public int getKothrownitem() {
        return kothrownitem;
    }

    public void setKothrownitem(int kothrownitem) {
        this.kothrownitem = kothrownitem;
    }

    public int getKoweaponone() {
        return koweaponone;
    }

    public void setKoweaponone(int koweaponone) {
        this.koweaponone = koweaponone;
    }

    public int getKoweapontwo() {
        return koweapontwo;
    }

    public void setKoweapontwo(int koweapontwo) {
        this.koweapontwo = koweapontwo;
    }

    public int getKogadgets() {
        return kogadgets;
    }

    public void setKogadgets(int kogadgets) {
        this.kogadgets = kogadgets;
    }

    public int getTimeheldweaponone() {
        return timeheldweaponone;
    }

    public void setTimeheldweaponone(int timeheldweaponone) {
        this.timeheldweaponone = timeheldweaponone;
    }

    public int getTimeheldweapontwo() {
        return timeheldweapontwo;
    }

    public void setTimeheldweapontwo(int timeheldweapontwo) {
        this.timeheldweapontwo = timeheldweapontwo;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
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
}
