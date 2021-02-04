package _enum;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Scanner;

enum Color {BLACK, WHITE}

enum Chiral {LEFT, RIGHT};

/**
 * This program demonstrates enumerated types.
 */
enum Size {
    SMALL("S"), MEDIUM("M"), LARGE("L"), EXTRA_LARGE("XL");

    private String abbreviation;

    private Size(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getAbbreviation() {
        return abbreviation;
    }
};

// Use an enum constructor, instance variable, and method.
enum Apple {
    Jonathan(10), GoldenDel(9), RedDel(12), Winesap(15), Cortland(8), AA;

    private int price; // price of each apple

    // Constructor
    Apple(int p) {
        price = p;
    }

    Apple() {
        price = -1;
    }

    int getPrice() {
        return price;
    }
}


enum Tamano {
    S(10), M(20), L(30), XL(40), XXL(50);
    private int val;

    private Tamano(int value) {
        val = value;
    }

    public int getVal() {
        return this.val;
    }
}

//enum Apple2 extends Apple{}      // ERROR
//
//class Apple22 extends Apple{
//    private Apple22(int p) {
//        super(p);
//    }
//}      // ERROR


enum CofeSize {
    SMALL(100), MEDIUM(200), BIG(300) {
        String getCoffeClass() {
            return "B";
        }
    };

    String coffeClass = "A";
    int milliliters;

    CofeSize(int milliters) {
        this.milliliters = milliters;
    }

    int getMilliliters() {
        return milliliters;
    }

    String getCoffeClass() {
        return coffeClass;
    }
}


enum Level {
//    BEGGINER {
//        public void print() {
//            System.out.println("print");
//        }
//    }
}

/**
 * Sources:
 * Как лучше сравнивать перечисляемые типы в Java
 * 1. https://tproger.ru/articles/comparing-enums-in-java/
 * <p>
 * Enum-Всемогущий
 * 2. https://habr.com/post/321152/
 */
public class ExampleEnum {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
//--------------------------------------------------------------------------------------------------------------------
        System.out.println(Arrays.toString(Color.values()));
//--------------------------------------------------------------------------------------------------------------------
        CofeSize cofeSize = CofeSize.SMALL;
        System.out.println(cofeSize);
        System.out.println(cofeSize.name());
        System.out.println(cofeSize.getMilliliters());
//        System.out.println(cofeSize.getMilliliters());
//        System.out.println(cofeSize.getCoffeClass());
//---------------------------------------------------------------------------------------------------------------------
//        Level.BEGGINER.getClass().getMethod("print").invoke(Level.BEGGINER);
//---------------------------------------------------------------------------------------------------------------------
        Apple apple01;

        // Display price of Winesap.
//        System.out.println("Winesap costs " + Apple.Winesap.getPrice() + " cents.\n");

        // Display all apples and prices.
//        System.out.println("All apple prices:");

//        for (Apple age : Apple.values()) System.out.println(age + " costs " + age.getPrice() + " cents.");
//-------------------------------------------------------------------------------------------------------------------

        Apple apple00 = Apple.GoldenDel;

        // Output an enum value.
//        System.out.println("Value of ap: " + apple00);
//        System.out.println();

        apple00 = Apple.GoldenDel;

        // Compare two enum values.
//        if (apple00 == Apple.GoldenDel)
//            System.out.println("ap contains GoldenDel.\n");

        // Use an enum to control age switch statement.

//        switch (apple00) {
//
//            case Jonathan:
//                System.out.println("Jonathan is red.");
//                break;
//            case GoldenDel:
//                System.out.println("Golden Delicious is yellow.");
//                break;
//            case RedDel:
//                System.out.println("Red Delicious is red.");
//                break;
//            case Winesap:
//                System.out.println("Winesap is red.");
//                break;
//            case Cortland:
//                System.out.println("Cortland is red.");
//                break;
//            default:
//                System.out.println("No exist apple for this name!!!");
//        }

        apple00 = Apple.valueOf("Winesap");
//        System.out.println("ap contains " + apple00);


//        System.out.println(Apple.Cortland.ordinal());
//        System.out.println(Apple.Jonathan.ordinal());

//        System.out.println();
//        System.out.println(Apple.RedDel.compareTo(Apple.Jonathan));
//        System.out.println(Apple.RedDel.compareTo(Apple.RedDel));
//        System.out.println(Apple.RedDel.compareTo(Apple.Cortland));

        double d = 3.1;
        int i = 4;
//        System.out.println(i / d);

//---------------------------------------------------------------------------------------------------------------------
        // Demonstrate ordinal(), compareTo(), and equals().
        // An enumeration of apple varieties.
        Apple ap, ap2, ap3;

        // Obtain all ordinal values using ordinal().
//        System.out.println("Here are all apple constants" + " and their ordinal values: ");

//        for (Apple age : Apple.values()) System.out.println(age + " " + age.ordinal());

        ap = Apple.RedDel;
        ap2 = Apple.GoldenDel;
        ap3 = Apple.RedDel;

//        System.out.println();

        // Demonstrate compareTo() and equals()
//        if (ap.compareTo(ap2) < 0) System.out.println(ap + " comes before " + ap2);

//        if (ap.compareTo(ap2) > 0) System.out.println(ap2 + " comes before " + ap);

//        if (ap.compareTo(ap3) == 0) System.out.println(ap + " equals " + ap3);

//        System.out.println();

//        if (ap.equals(ap2)) System.out.println("Error!");

//        if (ap.equals(ap3)) System.out.println(ap + " equals " + ap3);

//        if (ap == ap3) System.out.println(ap + " == " + ap3);
//---------------------------------------------------------------------------------------------------------------------

//        for (Tamano t : Tamano.values()) {
//            System.out.print(t + " = " + t.getVal() + ", ");
//            System.out.println(t.ordinal());
//        }

//        System.out.println();
//        System.out.println(Tamano.valueOf("S"));

//---------------------------------------------------------------------------------------------------------------------
        Scanner in = new Scanner(System.in);
//        System.out.print("Enter a size: (SMALL, MEDIUM, LARGE, EXTRA_LARGE) ");
//        String input = in.next().toUpperCase();

        /*Статический метод valueOf() выполняет действия, противоположные ме­тоду toString(). Например, в результате
        выполнения приведенной ниже строки кода переменной s будет присвоено значение Size. SMALL.*/
//        Size size = Enum.valueOf(Size.class, input);

        /*Наиболее часто при­меняется метод toString(), возвращающий имя константы перечислимого типа.Так, при вызове
        метода Size.SMALL.toString() возвращается символьная строка "SMALL".*/
//        System.out.println(size.toString());

        /*Каждый перечислимый тип содержит статический метод values() , который воз­
        вращает массив всех перечислимых значений. Так, в результате следующего вызова:*/
        Size[] values = Size.values();
        /*возвращается массив констант перечислимого типа Size. SMALL, Size.MEDIUM, Size.LARGE и Size.EXTRA_LARGE.*/

        /*Метод ordinal () возвращает позицию константы в объявлении перечислимого типа, начиная с нуля. Например, в
        результате вызова Size.MEDIUM.ordinal () воз­вратится значение 1.*/
        int ordinal = Size.MEDIUM.ordinal();

//        System.out.println("size=" + size);
//        System.out.println("abbreviation=" + size.getAbbreviation());
//        if (size == Size.EXTRA_LARGE)
//            System.out.println("Good job--you paid attention to the _.");

//---------------------------------- Как лучше сравнивать перечисляемые типы в Java ------------------------------------
        Color nothing = null;
        if (nothing == Color.BLACK) ;      // Всё отлично
//        if (nothing.equals(Color.BLACK)); // выбрасывает NullPointerException

        if (Color.BLACK.equals(Chiral.LEFT)) ; // Компилируется
//        if (Color.BLACK == Chiral.LEFT);      // НЕ КОМПИЛИРУЕТСЯ!!! Несовместимые типы!

//----------------------------------------------------------------------------------------------------------------------
//        System.out.println(Arrays.toString(Size.values()));
//----------------------------------------------------------------------------------------------------------------------
    }
};

//final class Level extends Enum {
//    public static final Level BEGINNER;
//    public static final Level INTERMEDIATE;
//    public static final Level EXPERT;
//
//    private static final Level $VALUES[];
//    static
//    {
//        BEGINNER = new Level("BEGINNER", 0);
//        INTERMEDIATE = new Level("INTE RMEDIATE", 1);
//        EXPERT = new Level("EXPERT", 2);
//        $VALUES = (new Level[] {
//                BEGINNER, INTERMEDIATE, EXPERT
//        });
//    }
//    public static Level[] values()
//    {
//        return (Level[])$VALUES.clone();
//    }
//    public static Level valueOf(String s)
//    {
//        return (Level)Enum.valueOf(Level, s);
//    }
//    private Level(String s, int i)
//    {
//        super(s, i);
//    }
//}

//abstract class Enum<E extends Enum<E>>
//        implements Comparable<E>, Serializable {
//    private final String name;
//    private final int ordinal;
//    protected Enum(String name, int ordinal) {
//        this.name = name;
//        this.ordinal = ordinal;
//    }
//    public String toString() {
//        return name;
//    }
//    public final String name() {
//        return name;
//    }
//}

//class MyEnum<E extends Enum> extends Enum<MyEnum<Enum>> {
//    MyEnum(String s, int i) {
//        super(s, i);
//    }
//}


/*
----------------------------------------------------------------------------------------------------------------------
Все перечислимые типы реализуются с помощью подклассов, производных от класса Enum. Они наследуют от этого класса ряд методов.
----------------------------------------------------------------------------------------------------------------------
НА ЗАМЕТКУ! У класса Enum имеется также параметр типа, который был ранее опущен ради про­стоты. Например, перечислимый
тип Size на самом деле расширяется до типа Enum<Size>, но здесь такая возможность не рассматривалась. В частности,
параметр типа используется в методе comoarеТо().
----------------------------------------------------------------------------------------------------------------------
Таким образом, для проверки перечислимых значений на равенство совсем необязательно использовать метод equals(). Для
этой цели вполне подойдет опера­ция == . По желанию в классы перечислимых типов можно добавить конструкторы, методы и
поля. Очевидно, что конструкторы мшут вызываться только при создании констант перечислимого типа.
----------------------------------------------------------------------------------------------------------------------
Каждый перечислимый тип содержит статический метод values ( ) , который возвращает массив всех перечислимых значений.
Так, в результате следующего вызова:
        Size [] values = Size.values();
Метод ordinal () возвращает позицию константы в объявлении перечислимого типа, начиная с нуля. Например, в результате
вызова Size.MEDIUM.ordinal () возвратится значение 1.
----------------------------------------------------------------------------------------------------------------------
•static Enum valueOf(Class enumClass, String name)
    Возвращает константу перечислимого типа указанного класса с заданным именем.

•String toString()
    Возвращает имя константы перечислимого типа.

•int ordinal()
    Возвращает позицию данной константы в объявлении перечислимого типа, начиная с нуля.

•int compareTo(Е other)
    Возвращает отрицательное целое значение, если константа перечислимого типа следует перед па­раметромo ther,
    0 — если this == other, а иначе — положительное целое значение. Порядок следования констант задается в объявлении
    перечислимого типа.


----------------------------------------------------------------------------------------------------------------------
*/
