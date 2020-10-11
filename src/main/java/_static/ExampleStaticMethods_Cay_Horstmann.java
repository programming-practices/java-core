package _static;

/**
 * This program demonstrates static methods.
 *
 * @author Cay Horstmann
 * @version 1.01 2004-02-19
 */
public class ExampleStaticMethods_Cay_Horstmann {
    public static void main(String[] args) {
        // fill the staff array with three EmployeeRAF objects
        Employee01[] staff = new Employee01[3];

        staff[0] = new Employee01("Tom", 40000);
        staff[1] = new Employee01("Dick", 60000);
        staff[2] = new Employee01("Harry", 65000);

        // print out information about all EmployeeRAF objects
        for (Employee01 e : staff) {
            e.setId();
            System.out.println("name=" + e.getName() + ",id=" + e.getId() + ",salary=" + e.getSalary());
        }

        int n = Employee01.getNextId(); // calls static method
        System.out.println("Next available id=" + n);
    }
}

class Employee01 {
    private static int nextId = 1;

    private String name;
    private double salary;
    private int id;

    public Employee01(String name, double salary) {
        this.name = name;
        this.salary = salary;
        id = 0;
    }

    public static int getNextId() {
        return nextId; // returns static field
    }

    public static void main(String[] args) // unit test
    {
        Employee01 e = new Employee01("Harry", 50000);
        System.out.println(e.getName() + " " + e.getSalary());
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

    public void setId() {
        id = nextId; // set id to next available id
        nextId++;
    }
}
