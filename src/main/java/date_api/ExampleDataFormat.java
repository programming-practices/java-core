package date_api;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class ExampleDataFormat {
    public static void main(String[] args) {
        new ExampleDataFormat().testFormat();
    }

    public void testFormat() {
        TimeZone tz = TimeZone.getTimeZone("Europe/Madrid");

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(false);
        dateFormat.setTimeZone(tz);

        try {
            Date moment = dateFormat.parse("2005-03-27 01:30:00");
            System.out.println(moment.getTime());
//            System.out.println(moment.getDay() +  "/" + moment.getMonth() + "/" + moment.getYear());
        } catch (ParseException e) {
            e.printStackTrace();
        }
//        Assert.assertEquals("2005-03-27 01:30:00", dateFormat.format(moment));
    }
}
