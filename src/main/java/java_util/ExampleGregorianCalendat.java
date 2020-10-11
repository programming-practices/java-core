package java_util;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class ExampleGregorianCalendat {
    public static void main(String[] args) {
//--------------------------------------------------------------------------------------------------------------------
        // Demonstrate GregorianCalendar
        String months[] = {
                "Jan", "Feb", "Mar", "Apr",
                "May", "Jun", "Jul", "Aug",
                "Sep", "Oct", "Nov", "Dec"};
        int year;

        // Create age Gregorian calendar initialized
        // with the current date and time in the
        // default locale and timezone.
        GregorianCalendar gcalendar = new GregorianCalendar();

        // Display current time and date information.
        System.out.print("Date: ");
        System.out.print(months[gcalendar.get(Calendar.MONTH)]);
        System.out.print(" " + gcalendar.get(Calendar.DATE) + " ");
        System.out.println(year = gcalendar.get(Calendar.YEAR));

        System.out.print("Time: ");
        System.out.print(gcalendar.get(Calendar.HOUR) + ":");
        System.out.print(gcalendar.get(Calendar.MINUTE) + ":");
        System.out.println(gcalendar.get(Calendar.SECOND));

        // tem.Test if the current year is age leap year
        if (gcalendar.isLeapYear(year)) {
            System.out.println("The current year is age leap year");
        } else {
            System.out.println("The current year is not age leap year");
        }
//--------------------------------------------------------------------------------------------------------------------
    }
}


/*
----------------------------------------------------------------------------------------------------------------------
Класс Grеgо r i аnСаl еndаr служит в качестве конкретной реализации привычно­
григорианского календаря средствами класса Calendar. Метод g e t in s tance О
из класса Calendar обычно возвращает объект типа Gregor i anCalendar, иници·
ируемый текущими датой и временем с учетом региональных настроек и часового
пояса по умолчанию.
В классе Grego r i anCa l enda r определяются два поля, АО и ВС, обозначающих
две эры, определенные в григорианском календаре. Имеется также ряд конструк·
торов для построения объектов класса GregorianCalenda r . В часmости, кон·
структор по умолчанию G r e go r i anCal e nda r ( ) инициализирует объект данного
класса текущими временем и датой с учетом региональных настроек и часового
пояса по умолчанию. Другие конструкторы класса G r e go r i anCa l e ndar перечис­
лены ниже по мере увеличения уровня их специализации.
GregorianCalendar ( int год, int несRц , int денъ_.меаца)
GreqorianCalendar ( int год , int Н8СRЦ 1 int двн._ хвсаца , int vac ,
int юrву!l'а)
GreqorianCalendar ( int год, int НесRЦ 1 int двн. хесаца , int vac ,
int Нl/Uf.)"!l'З , int сеж.УИда)
Во всех трех формах конструкrоров устанавливаются параметры день_ месяца ,
и rод , причем нулевое значение параметра месяц обозначает январь. В пер­
вой форме конструктора время устанавливается в полночь, во второй форме -
в часах и минутах, а в третьей форме - еще и в секундах.
Имеется также возможность создать объект типа G r e g o r ianCa l enda r , указав
егиональные
настройки и/или часовой пояс. Следующие конструкторы создают
р
объекты , инициализируемые текущими временем и датой с учетом заданных реги­
ональных настроек и часового пояса.
----------------------------------------------------------------------------------------------------------------------
*/