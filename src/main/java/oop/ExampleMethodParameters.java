package oop;

import java.util.List;

/**
 * This program demonstrates parameter passing in Java.
 *
 * @author Cay Horstmann
 * @version 1.00 2000-01-27
 */
public class ExampleMethodParameters {
    static final MyR myR1OFinal = new MyR("fArgInt", 34);
    static final MyR myR1OFinalQQ = new MyR("fArgInt", 34);
    static MyR myR1ONotFinal = new MyR("nf", 94);
    static MyR myR2N = new MyR("N", 45);
    static MyR myR1ONotFinalQQ = new MyR("nf", 94);
    static MyR myR2NQQ = new MyR("N", 45);

    public static void main(String[] args) {
//----------------------------------------------------------------------------------------------------------------------
        /*
         * tem.Test 1: Methods can't modify numeric parameters
         */
//        System.out.println("Testing tripleValue:");
//        double percent = 10;
//        System.out.println("Before: percent=" + percent);
//        tripleValue(percent);
//        System.out.println("After: percent=" + percent);

        /*
         * tem.Test 2: Methods can change the state of object parameters
         */
//        System.out.println("\nTesting tripleSalary:");
//        Employee_ForUseHashCode harry = new Employee_ForUseHashCode("Harry", 50000);
//        System.out.println("Before: salary=" + harry.getSalary());
//        tripleSalary(harry);
//        System.out.println("After: salary=" + harry.getSalary());

        /*
         * tem.Test 3: Methods can't attach new objects to object parameters
         */
//        System.out.println("\nTesting swap:");
//        Employee_ForUseHashCode a = new Employee_ForUseHashCode("Alice", 70000);
//        Employee_ForUseHashCode b = new Employee_ForUseHashCode("Bob", 60000);
//        System.out.println("Before: a=" + a.getName());
//        System.out.println("Before: b=" + b.getName());
//        swap(a, b);
//        System.out.println("After: a=" + a.getName());
//        System.out.println("After: b=" + b.getName());
//---------------------------------------------------------------------------------------------------------------------
        // 1.  https://www.youtube.com/watch?v=lrOAFzRZJ60
        // 2.  https://www.youtube.com/watch?v=qOYbUS2GUdo
        int value = 0;
        int[] arg = {20};

//        changeValueInArg(value, arg);
//        System.out.println(value + " " + arg[0]);

        changeEnlaceArg(value, arg);
        System.out.println(value + " " + arg[0]);
        System.out.println("-----------------------");

        // ---------------- Return
        int valueR = 0;
        int[] arrR = {20};
        valueR = fReturn(valueR, gReturn(valueR, arrR));
        System.out.println(valueR + " " + arrR[0]);

//---------------------------------------------------------------------------------------------------------------------
//        System.out.println("------- cambiarList() --------");
//        List<Integer> listS = new ArrayList<>();
//        listS.add(1);
//        listS.add(2);
//        listS.add(3);
//        listS.add(4);
//        System.out.println(listS);
//        cambiarList(listS, 56);
//        System.out.println(listS);
//        System.out.println();
//
//        System.out.println("------ cambiaValuesInt() ----------");
//        int a = 3;
//        int b = 0;
//        System.out.println("a = " + a + " end b = " + b);
//        cambiarValueInt(a, b);
//        System.out.println("a = " + a + " end b = " + b);
//        System.out.println();
//
//        System.out.println("------- cambiarValueIntegerSsulky() --------");
//        Integer aa = 3;
//        Integer bb = 0;
//        System.out.println("aa = " + aa + " end bb = " + bb);
//        cambiarValueIntegerSsulky(aa, bb);
//        System.out.println("aa = " + aa + " end bb = " + bb);
//        System.out.println();
//
//        System.out.println("------- cambiarValueString() ---------");
//        String c1 = "eee";
//        String c2 = "aaaa";
//        System.out.println("c1 = " + c1 + " end c2 = " + c2);
//        cambiarValueString(c1, c2);
//        System.out.println("c1 = " + c1 + " end c2 = " + c2);
//        System.out.println();
//
//        System.out.println("--------- cambiarMyRSsulkaNaClass final ---------");
//        System.out.println("Znacheia ravnu");
//        System.out.println(myR1OFinal);
//        System.out.println(myR2N);
//        System.out.println("Posle izmenenii znachenia ravnu");
//        cambiarMyRSsulkaNaClass(myR1OFinal, myR2N);
//        System.out.println(myR1OFinal);
//        System.out.println(myR2N);
//        System.out.println();
//
//        System.out.println("------- cambiarMyRSsulkaNaClass not final --------");
//        System.out.println("Znacheia ravnu");
//        System.out.println(myR1ONotFinal);
//        System.out.println(myR2N);
//        System.out.println();
//        System.out.println("Posle izmenenii znachenia ravnu");
//        cambiarMyRSsulkaNaClass(myR1ONotFinal, myR2N);
//        System.out.println(myR1ONotFinal);
//        System.out.println(myR2N);
//        System.out.println();
//
//        System.out.println("--------- cambiarMyRPeremennueClassa ----------------");
//        System.out.println("Znachenia ravnu");
//        System.out.println(myR1ONotFinalQQ);
//        System.out.println(myR1OFinalQQ);
//        System.out.println();
//        System.out.println("Posle izmenenia znachenia ravnu");
//        cambiarMyRPeremennueClassa(myR1OFinalQQ, myR1ONotFinalQQ, "QQQQQQQQ", 99);
//        System.out.println(myR1ONotFinalQQ);
///        System.out.println(myR1OFinalQQ);
//        System.out.println();
//
//        System.out.println("------ cambiarArray() --------");
//        int[] array = new int[]{1, 2, 3, 4, 5};
//        cambiaArray(array);
//        System.out.println(Arrays.toString(array));
//        System.out.println();
//
//        System.out.println("------ cambiarArray() Arrays.copyOf() --------");
//        int[] array2 = new int[]{1, 2, 3, 4, 5};
//        cambiaArray(Arrays.copyOf(array2, array2.length));
//        System.out.println(Arrays.toString(array2));
//---------------------------------------------------------------------------------------------------------------------
    }

    //----------------------------------------------------------------------------------------------------------------------
    /* doesn't work*/
    public static void tripleValue(double x) {
        x = 3 * x;
        System.out.println("End of method: x=" + x);
    }

    // works
    public static void tripleSalary(Employee employee) {
        employee.raiseSalary(200);
        System.out.println("End of method: salary=" + employee.getSalary());
    }

    public static void swap(Employee employeeA, Employee employeeB) {
        Employee temp = employeeA;
        employeeA = employeeB;
        employeeB = temp;
        System.out.println("End of method: x=" + employeeA.getName());
        System.out.println("End of method: y=" + employeeB.getName());
    }

    //----------------------------------------------------------------------------------------------------------------------
    private static void changeValueInArg(int value, int[] arr) {
        value += 30;
        arr[0] = 40;
    }

    private static void changeEnlaceArg(int value, int[] arr) {
        value += 50;
        arr[0] = 1;
        arr = new int[]{60};
        arr[0] = 2;
    }

    private static int fReturn(int value, int[] arr) {
        value += 30;
        arr[0] = 40;
        return 42;
    }

    private static int[] gReturn(int value, int[] arr) {
        value += 50;
        arr = new int[]{60};
        return arr;
    }

    //----------------------------------------------------------------------------------------------------------------------
    public static void cambiarList(List<Integer> list, int numeroADD) {
        list.add(numeroADD);
    }

    public static void cambiarValueInt(int numeroOld, int numeroNew) {
        numeroOld = numeroNew;
    }

    public static void cambiarValueIntegerSsulky(Integer numeroOld, Integer numeroNew) {
        numeroOld = numeroNew;
    }

    public static void cambiarValueIntegerZnacheie(Integer value1, Integer value2, Integer newValue) {
        value1 = newValue;
        value2 = newValue;
    }

    public static void cambiarValueString(String stringOld, String stringNew) {
        stringOld += stringNew;
    }

    public static void cambiarMyRSsulkaNaClass(MyR valueOld, MyR valueNew) {
        valueOld = valueNew;
        // System.out.println("From method: " + valueOld);
    }

    public static void cambiarMyRPeremennueClassa(MyR value1, MyR value2, String name, int age) {
        value1.setName(name);
        value1.setAge(age);

        value2.setName(name);
        value2.setAge(age);
    }

    public static void cambiarMyRSsulkaNaClass_PeremennueClassa(MyR valueOld, MyR valueNew, String name1, int age1, String name2, int age2) {
        valueOld = valueNew;

        valueNew.setName(name1);
        valueNew.setAge(age1);

        valueOld.setName(name2);
        valueOld.setAge(age2);
    }

    public static void cambiaArray(final int[] args) {
        for (int i = 0; i < args.length; i++) {
            args[i] = 0;
        }
//		args = new int[4];
    }
//----------------------------------------------------------------------------------------------------------------------
}

class Employee /* simplified EmployeeRAF class*/ {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }
}

class MyR {
    private String name;
    private int age;

    public MyR(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "tem.MyR{" + "name='" + name + '\'' + ", age=" + age + '}';
    }
}


/*
-----------------------------------------------------------------------------------------------------------------------
Рассмотрим термины, которые употребляются для описания способа передачи
параметров методам (или функциям) в языках программирования. Термин вызов
по значению означает, что метод получает значение, переданное ему из вызывающей
части программы. Вызов по ссылке означает, что метод получает из вызывающей части
программы местоположение переменной. Таким образом, метод может модифициро­
вать (т.е. видоизменить) значение переменной, передаваемой по ссылке, но не пе­
ременной, передаваемой по значению. Фраза "вызов по..." относится к стандартной
компьютерной терминологии, описывающей способ передачи параметров в различ­
ных языках программирования, а не только в Java. (На самом деле существует еще
и третий способ передачи параметров — вызов по имени, представляющий в основном
исторический интерес, поскольку он был применен в языке Algol, который относится
к числу самых старых языков программирования высокого уровня.)
В языке Java всегда используется только вызов по значению. Это означает, что
метод получает копии значений всех своих параметров. По этой причине метод не
может видоизменить содержимое ни одной из переменных, передаваемых ему в ка­
честве параметров.
-----------------------------------------------------------------------------------------------------------------------
В языке Java всегда используется только вызов по значению.
-----------------------------------------------------------------------------------------------------------------------
Таким образом, в Java для передачи объектов не применяется вызов по ссылке.
Вместо этого ссылки на объекты передаются по значению. Н иже поясняется, что мо­
жет и чего он не может метод делать со своими параметрами.
• Метод не может изменять параметры примитивных типов (т.е. числовые и ло­
  гические значения).
• Метод может изменять состояние объекта, передаваемого в качестве параметра.
• Метод не может делать в своих параметрах ссылки на новые объекты.
-----------------------------------------------------------------------------------------------------------------------
*/