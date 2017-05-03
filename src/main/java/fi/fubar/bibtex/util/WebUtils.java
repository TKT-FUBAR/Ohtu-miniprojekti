package fi.fubar.bibtex.util;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class WebUtils {

    public static String getACMData(String url) {
        String id = parseId(url);
        if (id == null) return null;        
        try {
            Document doc = Jsoup.connect("http://dl.acm.org/exportformats.cfm?id=" + id + "&expformat=bibtex").get();
            String data = doc.select("PRE").first().ownText();
            return StringUtils.scandicsBack(data);
        } catch (IOException ex) {
            System.out.println(ex);
            return null;
        }
    }

    private static String parseId(String url) {
        Pattern p = Pattern.compile("(?<=\\?id=)(\\d*)");
        Matcher m = p.matcher(url);
        if (m.find()) {
            return m.group(1);
        } else {
            return null;
        }
    }

}
