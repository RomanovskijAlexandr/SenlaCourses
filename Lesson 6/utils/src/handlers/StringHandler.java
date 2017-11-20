package handlers;

import org.apache.log4j.Logger;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StringHandler {

    private static final Logger log = Logger.getLogger(StringHandler.class.getName());

    public Date parseDate(String date, String format) {
        SimpleDateFormat formatter = null;
        try {
            formatter = new SimpleDateFormat(format);
            return formatter.parse(date);
        } catch (Exception e) {
            log.info("Parse exception in ", e);
        }
        return null;
    }
}
