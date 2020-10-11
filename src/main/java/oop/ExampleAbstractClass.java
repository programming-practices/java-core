package oop;

import java.time.LocalDate;

/**
 * This program demonstrates abstract classes.
 *
 * @author Cay Horstmann
 * @version 1.01 2004-02-21
 */
public class ExampleAbstractClass {
    public static void main(String[] args) {
//---------------------------------------------------------------------------------------------------------------------
        Person[] people = new Person[2];

        // fill the people array with Student and EmployeeRAF objects
        people[0] = new Employee02("Harry Hacker", 50000, 1989, 10, 1);
        people[1] = new Student("Maria Morris", "computer science");

        // print out names and descriptions of all Person objects
        for (Person p : people) System.out.println(p.getName() + ", " + p.getDescription());
//--------------------------------------------------------------------------------------------------------------------
        System.out.println();
        PersonNoAbstract[] peopleNo = new PersonNoAbstract[3];

        // fill the people array with Student and EmployeeRAF objects
        peopleNo[0] = new EmployeeNo02("Harry Hacker", 50000, 1989, 10, 1);
        peopleNo[1] = new StudentNo("Maria Morris", "computer science");
        peopleNo[2] = new PersonNoAbstract("Maikel");

        // print out names and descriptions of all Person objects
        for (PersonNoAbstract p : peopleNo) System.out.println(p.getName() + ", " + p.getDescription());
//--------------------------------------------------------------------------------------------------------------------
    }

}

abstract class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public abstract String getDescription();

    public String getName() {
        return name;
    }
}


class Student extends Person {
    private String major;

    /**
     * @param name  the student's name
     * @param major the student's major
     */
    public Student(String name, String major) {
        // pass n to superclass constructor
        super(name);
        this.major = major;
    }

    public String getDescription() {
        return "a student majoring in " + major;
    }
}

class Employee02 extends Person {
    private double salary;
    private LocalDate hireDay;

    public Employee02(String name, double salary, int year, int month, int day) {
        super(name);
        this.salary = salary;
        hireDay = LocalDate.of(year, month, day);
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getHireDay() {
        return hireDay;
    }

    public String getDescription() {
        return String.format("an employee with a salary of $%.2f", salary);
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }
}

//---------------------------------------------------------------------------------------------------------------------
class PersonNoAbstract {

    private String name;

    public PersonNoAbstract(String name) {
        this.name = name;
    }

    public String getName() {

        return name;
    }

    public String getDescription() {
        return "from method getDescription() classa PersonNoAbstract";
    }

}


class StudentNo extends PersonNoAbstract {
    private String major;

    /**
     * @param name  the student's name
     * @param major the student's major
     */
    public StudentNo(String name, String major) {
        // pass n to superclass constructor
        super(name);
        this.major = major;
    }

    public String getDescription() {
        return "a student majoring in " + major;
    }
}

class EmployeeNo02 extends PersonNoAbstract {
    private double salary;
    private LocalDate hireDay;

    public EmployeeNo02(String name, double salary, int year, int month, int day) {
        super(name);
        this.salary = salary;
        hireDay = LocalDate.of(year, month, day);
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getHireDay() {
        return hireDay;
    }

    public String getDescription() {
        return String.format("an employee with a salary of $%.2f", salary);
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }
}
//---------------------------------------------------------------------------------------------------------------------

/*
----------------------------------------------------------------------------------------------------------------------
Впрочем, класс может быть объявлен абстрактным, даже если он и не со­держит ни одного абстрактного метода.
----------------------------------------------------------------------------------------------------------------------
Создать экземпляры абстрактного класса нельзя.
----------------------------------------------------------------------------------------------------------------------

----------------------------------------------------------------------------------------------------------------------
*/