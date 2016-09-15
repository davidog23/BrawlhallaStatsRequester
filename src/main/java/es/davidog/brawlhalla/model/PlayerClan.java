package es.davidog.brawlhalla.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by David on 12/09/2016.
 */
public class PlayerClan {
    private static final Logger logger = LoggerFactory.getLogger(PlayerClan.class);

    private String clan_name;
    private long clan_id;
    private String clan_xp;
    private int personal_xp;

    public String getClan_name() {
        return clan_name;
    }

    public void setClan_name(String clan_name) {
        this.clan_name = clan_name;
    }

    public long getClan_id() {
        return clan_id;
    }

    public void setClan_id(long clan_id) {
        this.clan_id = clan_id;
    }

    public String getClan_xp() {
        return clan_xp;
    }

    public void setClan_xp(String clan_xp) {
        this.clan_xp = clan_xp;
    }

    public int getPersonal_xp() {
        return personal_xp;
    }

    public void setPersonal_xp(int personal_xp) {
        this.personal_xp = personal_xp;
    }
}
