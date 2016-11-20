package util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by sayem on 11/20/2016.
 */
public class CommonUtils {
    public static java.util.Date parseDateFromString(String dateInString, String format) {
        if (format == null || format.isEmpty())
            format = Constants.DEFAULT_DATE_FORMAT;
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        try {
            return formatter.parse(dateInString);
        } catch (Exception e) {
        }
        return null;
    }

    public static String parseStringFromDate(Date date, String format) {

        if (format == null || format.isEmpty())
            format = Constants.DEFAULT_DATE_FORMAT;

        DateFormat dateFormat = new SimpleDateFormat(format);
        try {
            return dateFormat.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
