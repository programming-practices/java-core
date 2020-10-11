package date_api;

import java.util.Calendar;
import java.util.TimeZone;

public class ExampleCalendar {
    public static void main(String[] args) {
//        new ExampleCalendar().testCalendarMs();
        new ExampleCalendar().testSunday();
    }

    public void testSunday() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("UTC"));
        calendar.set(2016, Calendar.JANUARY, 5, 12, 30, 0);
        System.out.println(calendar.getTime());
        ;
        calendar.add(Calendar.DAY_OF_YEAR, -2);
//        calendar.add(Calendar.DAY_OF_YEAR, 2);
        System.out.println(calendar.getTime());
        ;

//        Assert.assertEquals(Calendar.SUNDAY, calendar.get(Calendar.DAY_OF_WEEK));
    }

    public void testCalendarMs() {
        TimeZone tz = TimeZone.getTimeZone("Europe/Madrid");

        Calendar calendar = Calendar.getInstance(tz);
        calendar.setLenient(false);

        calendar.set(2016, Calendar.APRIL, 20, 12, 0, 0);
        System.out.println(calendar.getTimeInMillis());
        System.out.println(calendar.getTime());

        calendar.set(Calendar.MILLISECOND, 0);
        System.out.println(calendar.getTimeInMillis());
        System.out.println(calendar.getTime());
    }
}
