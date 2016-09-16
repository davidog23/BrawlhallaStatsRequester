package es.davidog.brawlhalla.controller;

import es.davidog.brawlhalla.model.Player;
import es.davidog.brawlhalla.model.PlayerQuery;
import es.davidog.brawlhalla.model.PlayerRanked;
import es.davidog.brawlhalla.model.RankingEntry;
import es.davidog.brawlhalla.util.Queries;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.Collections;

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
    public ModelAndView getRankingSearch(@RequestParam("name") String name, @RequestParam("region") String region) {
        RankingEntry[] entries = Queries.getRankingEntries(name, region);
        return new ModelAndView("ranking", "players", entries);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView getPlayerInfo(@PathVariable String id) {
        long bid = Long.parseLong(id);
        Player player = Queries.getPlayer(bid);
        ModelAndView modelAndView = new ModelAndView("player", "player", player);
        PlayerRanked playerRanked = Queries.getPlayerRanked(bid);
        modelAndView.addObject("playerRanked", playerRanked);
        return modelAndView;
    }
}
