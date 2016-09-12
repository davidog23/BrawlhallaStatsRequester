package es.davidog.brawlhalla.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
}
