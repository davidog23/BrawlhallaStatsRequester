package es.davidog.brawlhalla.controller;

import es.davidog.brawlhalla.api.searchs.PlayerQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * Created by David on 17/09/2016.
 */
@ControllerAdvice
public class WebControllerAdvice {
    private static final Logger logger = LoggerFactory.getLogger(WebControllerAdvice.class);

    @ModelAttribute("p")
    public PlayerQuery bindQuery() {
        return new PlayerQuery();
    }
}
