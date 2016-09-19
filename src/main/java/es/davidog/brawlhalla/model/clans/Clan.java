package es.davidog.brawlhalla.model.clans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by David on 19/09/2016.
 */
public class Clan {
    private static final Logger logger = LoggerFactory.getLogger(Clan.class);

    private long clan_id;
    private String clan_name;
    private long clan_create_date;
    private String clan_xp;
    private ClanPlayer[] clan;
    private Date createDate;

    public String getFormattedDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy 'at' HH:mm:ss");
        return formatter.format(createDate);
    }

    public long getClan_id() {
        return clan_id;
    }

    public void setClan_id(long clan_id) {
        this.clan_id = clan_id;
    }

    public String getClan_name() {
        return clan_name;
    }

    public void setClan_name(String clan_name) {
        this.clan_name = clan_name;
    }

    public long getClan_create_date() {
        return clan_create_date;
    }

    public void setClan_create_date(long clan_create_date) {
        this.clan_create_date = clan_create_date;
        this.createDate = new Date(clan_create_date * 1000);
    }

    public String getClan_xp() {
        return clan_xp;
    }

    public void setClan_xp(String clan_xp) {
        this.clan_xp = clan_xp;
    }

    public ClanPlayer[] getClan() {
        return clan;
    }

    public void setClan(ClanPlayer[] clan) {
        this.clan = clan;
    }
}
