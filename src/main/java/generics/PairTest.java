package generics;

import java.time.LocalDate;
/*Переменная типа или подстановка может иметь несколько ограничений, как показано в приведенном ниже примере кода. О
граничивающие типы разделяются знаком &, потому что запятые служат для разделения переменных типа.
                        Т extends Comparable & Serializable
Как и в механизме наследования в Java, у интерфейсов может быть сколько угодно супертипов, но только один из ограничивающих
типов может быть классом. Если для ограничения служит класс, он должен быть первым в списке накладываемых ограничений.*/

/**
 * @author Cay Horstmann
 * @version 1.02 2015-06-21
 */
public class PairTest {
    public static void main(String[] args) {
//--------------------------------------------------1-------------------------------------------------------------------
//        String[] words = {"Mary", "had", "a", "little", "lamb"};
//        Pair_1<String> pair = ArrayAlg_1.minmax(words);
//        System.out.println("min = " + pair.getFirst());
//        System.out.println("max = " + pair.getSecond());
//---------------------------------------------------2------------------------------------------------------------------
//        LocalDate[] birthdays =
//                {
//                        LocalDate.of(1906, 12, 9), // G. Hopper
//                        LocalDate.of(1815, 12, 10), // A. Lovelace
//                        LocalDate.of(1903, 12, 3), // J. von Neumann
//                        LocalDate.of(1910, 6, 22), // K. Zuse
//                };
//        Pair_2<LocalDate> mm = ArrayAlg_2.minmax(birthdays);
//        System.out.println("min = " + mm.getFirst());
//        System.out.println("max = " + mm.getSecond());
//----------------------------------------------------3-----------------------------------------------------------------
        Manager_3 gusGreedy = new Manager_3("Gus Greedy", 800000, 2003, 12, 15);
        Manager_3 sidSneaky = new Manager_3("Sid Sneaky", 600000, 2003, 12, 15);
        Pair_3<Manager_3> buddies = new Pair_3<>(gusGreedy, sidSneaky);
        printBuddies(buddies);

        gusGreedy.setBonus(1000000);
        sidSneaky.setBonus(500000);
        Manager_3[] managers = {gusGreedy, sidSneaky};

        Pair_3<Employee_3> result = new Pair_3<>();
        minmaxBonus(managers, result);
        System.out.println("first: " + result.getFirst().getName() + ", second: " + result.getSecond().getName());
        maxminBonus(managers, result);
        System.out.println("first: " + result.getFirst().getName() + ", second: " + result.getSecond().getName());
//---------------------------------------------------------------------------------------------------------------------
    }

    //----------------------------------------------------3-----------------------------------------------------------------
    public static void printBuddies(Pair_3<? extends Employee_3> p) {
        Employee_3 first = p.getFirst();
        Employee_3 second = p.getSecond();
        System.out.println(first.getName() + " and " + second.getName() + " are buddies.");
    }

    public static void minmaxBonus(Manager_3[] a, Pair_3<? super Manager_3> result) {
        if (a.length == 0) return;
        Manager_3 min = a[0];
        Manager_3 max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (min.getBonus() > a[i].getBonus()) min = a[i];
            if (max.getBonus() < a[i].getBonus()) max = a[i];
        }
        result.setFirst(min);
        result.setSecond(max);
    }

    public static void maxminBonus(Manager_3[] a, Pair_3<? super Manager_3> result) {
        minmaxBonus(a, result);
        PairAlg_3.swapHelper(result); // OK--swapHelper captures wildcard type
    }
    // Can't write public static <T super manager> ...
//---------------------------------------------------------------------------------------------------------------------
}

//----------------------------------------------------1-----------------------------------------------------------------
class Pair_1<T> {
    private T first;
    private T second;

    public Pair_1() {
        first = null;
        second = null;
    }

    public Pair_1(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T newValue) {
        first = newValue;
    }

    public T getSecond() {
        return second;
    }

    public void setSecond(T newValue) {
        second = newValue;
    }

}

class ClassAlg_1 {
    /**
     * Gets the minimum and maximum of an array of strings.
     *
     * @param a an array of strings
     * @return a pair with the min and max value, or null if a is null or empty
     */
    public static Pair_1<String> minmax(String[] a) {
        if (a == null || a.length == 0) return null;
        String min = a[0];
        String max = a[0];
        for (int i = 1; i < a.length; i++) {
            //sintaksicheskii compareTo()
//            if (min.compareTo(a[i]) > 0) {
//                min = a[i];
//            }
            // compareTo() po dline stroki
            if (Integer.compare(min.length(), a[i].length()) > 0) {
                min = a[i];
            }
            //sintaksicheskii compareTo()
//            if (max.compareTo(a[i]) < 0){
//                max = a[i];
//            }
            // compareTo() po dline stroki
            if (Integer.compare(max.length(), a[i].length()) < 0) {
                max = a[i];
            }
        }
        Pair_1 pair = new Pair_1<String>(min, max);
        return pair;
    }
}

//---------------------------------------------------2------------------------------------------------------------------
class Pair_2<T> {
    private T first;
    private T second;

    public Pair_2() {
        first = null;
        second = null;
    }

    public Pair_2(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T newValue) {
        first = newValue;
    }

    public T getSecond() {
        return second;
    }

    public void setSecond(T newValue) {
        second = newValue;
    }
}

class ClassAlg_2 {
    /**
     * Gets the minimum and maximum of an array of objects of type T.
     *
     * @param a an array of objects of type T
     * @return a pair with the min and max value, or null if a is
     * null or empty
     */
    public static <T extends Comparable> Pair_2<T> minmax(T[] a) {
        if (a == null || a.length == 0) return null;
        T min = a[0];
        T max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (min.compareTo(a[i]) > 0) min = a[i];
            if (max.compareTo(a[i]) < 0) max = a[i];
        }
        return new Pair_2<>(min, max);
    }
}

//--------------------------------------------------------3-------------------------------------------------------------
class Employee_3 {
    private String name;
    private double salary;
    private LocalDate hireDay;

    public Employee_3(String name, double salary, int year, int month, int day) {
        this.name = name;
        this.salary = salary;
        hireDay = LocalDate.of(year, month, day);
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getHireDay() {
        return hireDay;
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }
}

class Manager_3 extends Employee_3 {
    private double bonus;

    /**
     * @param name   the employee's name
     * @param salary the salary
     * @param year   the hire year
     * @param month  the hire month
     * @param day    the hire day
     */
    public Manager_3(String name, double salary, int year, int month, int day) {
        super(name, salary, year, month, day);
        bonus = 0;
    }

    public double getSalary() {
        double baseSalary = super.getSalary();
        return baseSalary + bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double b) {
        bonus = b;
    }
}

class Pair_3<T> {
    private T first;
    private T second;

    public Pair_3() {
        first = null;
        second = null;
    }

    public Pair_3(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T newValue) {
        first = newValue;
    }

    public T getSecond() {
        return second;
    }

    public void setSecond(T newValue) {
        second = newValue;
    }
}

class PairAlg_3 {
    public static boolean hasNulls(Pair_3<?> p) {
        return p.getFirst() == null || p.getSecond() == null;
    }

    public static void swap(Pair_3<?> p) {
        swapHelper(p);
    }

    public static <T> void swapHelper(Pair_3<T> p) {
        T t = p.getFirst();
        p.setFirst(p.getSecond());
        p.setSecond(t);
    }
}

//---------------------------------------------------------------------------------------------------------------------