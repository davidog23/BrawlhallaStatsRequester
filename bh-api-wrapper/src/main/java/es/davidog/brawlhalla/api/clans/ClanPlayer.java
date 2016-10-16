package es.davidog.brawlhalla.api.clans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by David on 19/09/2016.
 */
public class ClanPlayer {
    private static final Logger logger = LoggerFactory.getLogger(ClanPlayer.class);

    private long brawlhalla_id;
    private String name;
    private String rank;
    private long join_date;
    private int xp;
    private Date joinDate;

    public String getFormattedDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        return formatter.format(joinDate);
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

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public long getJoin_date() {
        return join_date;
    }

    public void setJoin_date(long join_date) {
        this.join_date = join_date;
        this.joinDate = new Date(join_date * 1000);
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }
}
