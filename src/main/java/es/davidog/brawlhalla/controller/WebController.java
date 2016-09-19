package es.davidog.brawlhalla.controller;

import es.davidog.brawlhalla.model.clans.Clan;
import es.davidog.brawlhalla.model.general.Player;
import es.davidog.brawlhalla.model.searchs.PlayerQuery;
import es.davidog.brawlhalla.model.ranked.PlayerRanked;
import es.davidog.brawlhalla.model.searchs.RankingEntry;
import es.davidog.brawlhalla.util.Queries;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by David on 13/09/2016.
 */
@Controller
public class WebController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView getIndex() {
        return new ModelAndView("index", "player", new PlayerQuery());
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ModelAndView getRankingSearch(@RequestParam("name") String name, @RequestParam("region") String region, @ModelAttribute("p") PlayerQuery p) {
        RankingEntry[] entries;
        entries = p == null ? Queries.getRankingEntries(name, region) : Queries.getRankingEntries(p.getName(), p.getRegion());
        return new ModelAndView("ranking", "players", entries);
    }

    @RequestMapping(value = "/player/{id}", method = RequestMethod.GET)
    public ModelAndView getPlayerInfo(@PathVariable String id) {
        try {
            long bid = Long.parseLong(id);
            Player player = Queries.getPlayer(bid);
            ModelAndView modelAndView = new ModelAndView("player", "player", player);
            PlayerRanked playerRanked = Queries.getPlayerRanked(bid);
            modelAndView.addObject("playerRanked", playerRanked);
            return modelAndView;
        } catch (NumberFormatException e) {
            return null;
        }
    }

    @RequestMapping(value = "/clan/{id}", method = RequestMethod.GET)
    public ModelAndView getClanInfo(@PathVariable String id) {
        try {
            long cid = Long.parseLong(id);
            Clan clan = Queries.getClan(cid);
            return new ModelAndView("clan", "clan", clan);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
