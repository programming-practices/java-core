package date_api;


import static date_api.CheckIfStringIsValidDate.convertToDate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// Source: http://viralpatel.net/blogs/check-string-is-valid-date-java/

public class CheckIfStringIsValidDate {

    // List of all date formats that we want to parse.
    // Add your own format here.
    private static List<SimpleDateFormat> dateFormats = new ArrayList<SimpleDateFormat>() {
        {
            add(new SimpleDateFormat("dd.M.yyyy"));
            add(new SimpleDateFormat("dd.MMM.yyyy"));
            add(new SimpleDateFormat("dd-MMM-yyyy"));
            add(new SimpleDateFormat("dd/MMM/yyyy"));
            add(new SimpleDateFormat("dd.M.yyyy hh:mm:ss a"));

            add(new SimpleDateFormat("M.dd.yyyy"));
            add(new SimpleDateFormat("MMM.dd.yyyy"));
            add(new SimpleDateFormat("MMM-dd-yyyy"));
            add(new SimpleDateFormat("MMM/dd/yyyy"));
            add(new SimpleDateFormat("M/dd/yyyy"));
            add(new SimpleDateFormat("M/dd/yyyy hh:mm:ss a"));

            add(new SimpleDateFormat("yyyy.M.dd"));
            add(new SimpleDateFormat("yyyy.MMM.dd"));
            add(new SimpleDateFormat("yyyy-MMM-dd"));
            add(new SimpleDateFormat("yyyy/MMM/dd"));
        }
    };

    /**
     * Convert String with various formats into java.util.Date
     *
     * @param input Date as a string
     * @return java.util.Date object if input string is parsed
     * successfully else returns null
     */
    public static Date convertToDate(String input) {
        Date date = null;
        if (null == input) {
            return null;
        }
        for (SimpleDateFormat format : dateFormats) {
            try {
                format.setLenient(false);
                date = format.parse(input);
            } catch (ParseException e) {
                //Shhh.. try other formats
            }
            if (date != null) {
                break;
            }
        }
        return date;
    }
}

class TestDateUtil {
    public static void main(String[] args) {
        System.out.println("10/14/2012" + " = " + convertToDate("10/14/2012"));
        System.out.println("10-Jan-2012" + " = " + convertToDate("10-Jan-2012"));
        System.out.println("01.03.2002" + " = " + convertToDate("01.03.2002"));
        System.out.println("12/03/2010" + " = " + convertToDate("12/03/2010"));
        System.out.println("19.Feb.2011" + " = " + convertToDate("19.Feb.2011"));
        System.out.println("4/20/2012" + " = " + convertToDate("4/20/2012"));
        System.out.println("19/Feb/2011" + " = " + convertToDate("19/Feb/2011"));
        System.out.println("some string" + " = " + convertToDate("some string"));
        System.out.println("123456" + " = " + convertToDate("123456"));
        System.out.println("null" + " = " + convertToDate(null));

    }
}

