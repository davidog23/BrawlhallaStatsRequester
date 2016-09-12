package es.davidog.brawlhalla.model;

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
}
