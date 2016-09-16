package es.davidog.brawlhalla.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by David on 16/09/2016.
 */
public class FormatterUtil {
    private static final Logger logger = LoggerFactory.getLogger(FormatterUtil.class);

    public static String formatSeconds(int seconds) {
        int minutes = seconds / 60;
        seconds %= 60;
        int hours = minutes / 60;
        minutes %= 60;
        int days = hours / 24;
        hours %= 24;
        String res = "";
        if (days > 0) { res += days + " days "; }
        if (hours > 0) { res += hours + "h "; }
        if (minutes > 0) { res += minutes + "min "; }
        if (seconds > 0) { res += seconds + "sec "; }
        return res.equals("") ? "0sec" : res;
    }

    public static double formatUnitaryToPercentage(double unitary) {
        return (((int)((unitary)*10000))/100.0);
    }

    public static String capitalizeFirstLetters(String name) {
        String[] words = name.split(" ");
        String res = "";
        for(String w : words) {
            res += w.substring(0, 1).toUpperCase() + w.substring(1) + (name.endsWith(w) ? "" : " ");
        }
        return res;
    }
}
