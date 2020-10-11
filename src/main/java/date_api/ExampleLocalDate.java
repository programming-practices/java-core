package date_api;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class ExampleLocalDate {
    public static void main(String[] args) {
//---------------------------------------------------------------------------------------------------------------------
        LocalDate date = LocalDate.now();
        int month = date.getMonthValue();
        int today = date.getDayOfMonth();

        date = date.minusDays(today - 1); // Set to start of month
        DayOfWeek weekday = date.getDayOfWeek();
        int value = weekday.getValue(); // 1 = Monday, ... 7 = Sunday

        System.out.println("Mon Tue Wed Thu Fri Sat Sun");
        for (int i = 1; i < value; i++)
            System.out.print("    ");
        while (date.getMonthValue() == month) {
            System.out.printf("%3d", date.getDayOfMonth());
            if (date.getDayOfMonth() == today)
                System.out.print("*");
            else
                System.out.print(" ");
            date = date.plusDays(1);
            if (date.getDayOfWeek().getValue() == 1) System.out.println();
        }
        if (date.getDayOfWeek().getValue() != 1) System.out.println();
        System.out.println("---------------------------------------------");
//---------------------------------------------------------------------------------------------------------------------
        LocalDate date2 = LocalDate.now();
        System.out.println("date = " + date2);
        System.out.println("date.getEra() = " + date2.getEra());
        System.out.println("date.getMonth() = " + date2.getMonth());
        System.out.println("date.getDayOfMonth() = " + date2.getDayOfMonth());
        System.out.println("----------------------------------------------");
//---------------------------------------------------------------------------------------------------------------------
        LocalDate oreginalDate = LocalDate.now();
        LocalDate changetDate = oreginalDate.plusDays(1000);
        System.out.println(oreginalDate);
        System.out.println(changetDate);
//---------------------------------------------------------------------------------------------------------------------
    }
}

/*
---------------------------------------------------------------------------------------------------------------------
static LocalTime now()
Строит объект, представляющий текущую дату.

static LocalTime of(intyear, int month, int day)
Строит объект, представляющий заданную дату.

int getYear()
int getMonthValue ()
int getDayOfMonth ()
Получают год, месяц и день из текущей даты.

DayOfWeek getDayOfWeek ()
Получает день недели из текущей даты в виде экземпляра класса DayOfWeek. Для получения дня
недели в пределах от 1 (понедельник! до 7 (воскресенье) следует вызвать метод getValue ( ) .

LocalDate plusDays(int n)
LocalDate minusDays(int n)
Выдают дату на n дней после или до текущей даты.
---------------------------------------------------------------------------------------------------------------------
*/