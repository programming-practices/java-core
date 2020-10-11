package oop;

import java.util.Random;

/**
 * This program demonstrates object construction.
 *
 * @author Cay Horstmann
 * @version 1.01 2004-02-19
 */
public class ExampleConstructor_Cay_Horstmann {
    public static void main(String[] args) {
        // fill the staff array with three EmployeeRAF objects
        EmployeeA[] staff = new EmployeeA[3];

        System.out.println("-------------new EmployeeA(\"Harry\", 40000);---------------------");
        staff[0] = new EmployeeA("Harry", 40000);
        System.out.println();
        System.out.println("------------------new EmployeeA(60000);----------------------");
        staff[1] = new EmployeeA(60000);
        System.out.println();
        System.out.println("------------------new EmployeeA();----------------------");
        staff[2] = new EmployeeA();

        // print out information about all EmployeeRAF objects
        System.out.println();
        for (EmployeeA e : staff)
            System.out.println("name=" + e.getName() + ",id=" + e.getId() + ",salary="
                    + e.getSalary());
    }
}

class EmployeeA {
    private static int nextId;

    // static initialization block
    static {
        Random generator = new Random();
        // set nextId to a random number between 0 and 9999
        nextId = generator.nextInt(10000);
        System.out.println("Static initialization block!!!");
    }

    private int id;
    private String name = ""; // instance field initialization


    /*Статическая инициализация выполняется в том случае, если класс загружается впервые. Аналогично полям экземпляра,
     статические поля принимают значения 0, false или null, если не задать другие значения явным образом. Все операторы,
     зада­ющие начальные значения статических полей, а также статические блоки инициали­зации выполняются в порядке их
     перечисления в объявлении класса.*/
    private double salary;

    // object initialization block
    {
        id = nextId;
        nextId++;
        System.out.println("Initialization block!!!");
    }

    // three overloaded constructors
    public EmployeeA(String name, double salary) {
        this.name = name;
        this.salary = salary;
        System.out.println("Constructor whit two parameters!!!");
    }

    public EmployeeA(double salary) {
        // calls the EmployeeRAF(String, double) constructor
        this("EmployeeRAF #" + nextId, salary);
        System.out.println("Constructor whit one parameter!!!");
    }

    // the default constructor
    public EmployeeA() {
        // name initialized to ""--see above
        // salary not explicitly set--initialized to 0
        // id initialized in initialization block
        System.out.println("Default constructor!!!");
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }
}
