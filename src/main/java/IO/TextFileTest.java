package IO;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Scanner;

/**
 * @author Cay Horstmann
 * @version 1.14 2016-07-11
 */
public class TextFileTest {
    public static void main(String[] args) throws IOException {
        Employee[] staff = new Employee[3];

        staff[0] = new Employee("Carl Cracker", 75000, 1987, 12, 15);
        staff[1] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
        staff[2] = new Employee("Tony Tester", 40000, 1990, 3, 15);

        // save all employee records to the file employee.dat
        try (PrintWriter out = new PrintWriter("src/main/resources/IO/employee.dat", "UTF-8")) {
            writeData(staff, out);
        }

        // retrieve all records into a new array
        try (Scanner in = new Scanner(
                new FileInputStream("src/main/resources/IO/employee.dat"), "UTF-8")) {
            Employee[] newStaff = readData(in);

            // print the newly read employee records
            for (Employee e : newStaff)
                System.out.println(e);
        }
    }

    /**
     * Writes all employeeRAFS in an array to a print writer
     *
     * @param employee an array of employeeRAFS
     * @param out      a print writer
     */
    private static void writeData(Employee[] employee, PrintWriter out) throws IOException {
        // write number of employeeRAFS
        out.println(employee.length);

        for (Employee e : employee)
            writeEmployee(out, e);
    }

    /**
     * Reads an array of employees from a scanner
     *
     * @param in the scanner
     * @return the array of employees
     */
    private static Employee[] readData(Scanner in) {
        // retrieve the array size
        int n = in.nextInt();
        in.nextLine(); // consume newline

        Employee[] employee = new Employee[n];
        for (int i = 0; i < n; i++) {
            employee[i] = readEmployee(in);
        }
        return employee;
    }

    /**
     * Writes employee data to a print writer
     *
     * @param out the print writer
     */
    public static void writeEmployee(PrintWriter out, Employee e) {
        out.println(e.getName() + "|" + e.getSalary() + "|" + e.getHireDay());
    }

    /**
     * Reads employee data from a buffered reader
     *
     * @param in the scanner
     */
    public static Employee readEmployee(Scanner in) {
        String line = in.nextLine();
        String[] tokens = line.split("\\|");
        String name = tokens[0];
        double salary = Double.parseDouble(tokens[1]);
        LocalDate hireDate = LocalDate.parse(tokens[2]);
        int year = hireDate.getYear();
        int month = hireDate.getMonthValue();
        int day = hireDate.getDayOfMonth();
        return new Employee(name, salary, year, month, day);
    }
}

class Employee {
    private String name;
    private double salary;
    private LocalDate hireDay;

    public Employee(String n, double s, int year, int month, int day) {
        name = n;
        salary = s;
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

    public String toString() {
        return getClass().getName() + "[name=" + name + ",salary=" + salary + ",hireDay=" + hireDay + "]";
    }
}
