package es.davidog.brawlhalla.controller;

import es.davidog.brawlhalla.api.clans.Clan;
import es.davidog.brawlhalla.api.general.Player;
import es.davidog.brawlhalla.api.ranked.PlayerRanked;
import es.davidog.brawlhalla.api.searchs.PlayerQuery;
import es.davidog.brawlhalla.api.searchs.RankingEntry;
import es.davidog.brawlhalla.util.Queries;
import es.davidog.brawlhalla.util.ServletUtil;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

/**
 * Created by David on 13/09/2016.
 */
@Controller
public class WebController {
    private static final Logger logger = LoggerFactory.getLogger(WebController.class);

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView getIndex(@RequestParam(required = false) Optional<String> error, HttpServletRequest request) {
        String ipAddress = ServletUtil.getClientIpAddr(request);
        logger.info("Connection from " + (ipAddress == null ? request.getRemoteAddr() : ipAddress));
        ModelAndView modelAndView = new ModelAndView("index", "player", new PlayerQuery());
        modelAndView.addObject("error", error);
        return modelAndView;
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ModelAndView getRankingSearch(@RequestParam("name") String name, @RequestParam("region") String region, @ModelAttribute("p") PlayerQuery p) {
        if (Queries.REQUESTS.get() >= Queries.REQUEST_PER_15MIN) {
            ModelAndView modelAndView = new ModelAndView("redirect:/?error");
            return modelAndView;
        }
        RankingEntry[] entries;
        entries = p == null ? Queries.getResponse(Queries.getRankingEntries(name, region), RankingEntry[].class) :
                            Queries.getResponse(Queries.getRankingEntries(p.getName(), p.getRegion()), RankingEntry[].class);
        if (entries.length == 1 && entries[0].getName().equals(name)) return new ModelAndView("redirect:/player/" + entries[0].getBrawlhalla_id());
        return new ModelAndView("ranking", "players", entries);
    }

    @RequestMapping(value = "/player/{id}", method = RequestMethod.GET)
    public ModelAndView getPlayerInfo(@PathVariable String id) {
        if (Queries.REQUESTS.get() >= Queries.REQUEST_PER_15MIN) {
            ModelAndView modelAndView = new ModelAndView("redirect:/?error");
            return modelAndView;
        }
        try {
            long bid = Long.parseLong(id);
            Player player = Queries.getResponse(Queries.getPlayer(bid), Player.class);
            ModelAndView modelAndView = new ModelAndView("player", "player", player);
            PlayerRanked playerRanked = Queries.getResponse(Queries.getPlayerRanked(bid), PlayerRanked.class);
            modelAndView.addObject("playerRanked", playerRanked);
            return modelAndView;
        } catch (NumberFormatException e) {
            return null;
        }
    }

    @RequestMapping(value = "/clan/{id}", method = RequestMethod.GET)
    public ModelAndView getClanInfo(@PathVariable String id) {
        if (Queries.REQUESTS.get() >= Queries.REQUEST_PER_15MIN) {
            ModelAndView modelAndView = new ModelAndView("redirect:/?error");
            return modelAndView;
        }
        try {
            long cid = Long.parseLong(id);
            Clan clan = Queries.getResponse(Queries.getClan(cid), Clan.class);
            return new ModelAndView("clan", "clan", clan);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
