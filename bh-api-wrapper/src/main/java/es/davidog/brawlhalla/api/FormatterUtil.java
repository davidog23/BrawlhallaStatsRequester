package es.davidog.brawlhalla.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public static String escapeHexUtf8ToString(String source) {
        Pattern p = Pattern.compile("(\\\\u([a-fA-f0-9]{4}))+");
        Matcher m = p.matcher(source);

        StringBuffer sb = new StringBuffer();
        while (m.find()) {
            String[] caracteres = m.group().split("\\\\u");

            byte[] bytes = new byte[caracteres.length - 1];
            for(int i = 0; i < bytes.length; i++) {
                bytes[i] = (byte) Integer.parseInt(caracteres[i + 1], 16);
            }

            m.appendReplacement(sb, new String(bytes, Charset.forName("UTF-8")));
        }
        m.appendTail(sb);
        return sb.toString();
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
