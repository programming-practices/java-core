package collections;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.UnaryOperator;

public class ExampleReplaceAll {
    public static void main(String[] args) {
//---------------------------------------------------------------------------------------------------------------------

//        List<Integer> list = new ArrayList<>(Arrays.asList(100, 1, 2, 8, 2, 3, 15, 54, 3, 9));
//        list.replaceAll(UnaryOperator.identity());
//        System.out.println(list);

//---------------------------------------------------------------------------------------------------------------------

//        List<String> color_list = new ArrayList<>(Arrays.asList("White", "Black", "Red", "White", "Yellow", "White"));
//        MyOperator<String> operator = new MyOperator<>();
//
//        operator.varc1 = "White";
//
//        System.out.println("List of Colors");
//        System.out.println(color_list);
//
//        // Replace all colors with White value
//        color_list.replaceAll(operator);
//        System.out.println("Color list, after replacing all colors with White value :");
//        System.out.println(color_list);

//---------------------------------------------------------------------------------------------------------------------

        ListReplaceAllExample.employeeList.replaceAll(employee -> {
            employee.setSalary(employee.getSalary() * 1.1);
            return employee;
        });
        System.out.println("EmployeeRAF list with all salaries incremented by 10%");
        ListReplaceAllExample.employeeList.forEach(System.out::println);

//---------------------------------------------------------------------------------------------------------------------
//        ArrayList<String> list = new ArrayList<>();
//        ArrayList<String> list1 = new ArrayList<>();
//        ArrayList<String> list2 = new ArrayList<>();
//        list.add("l");
//        list.add("l2");
//        list.add("l3");
//        list.add("l4");
//        list1.add("l5");
//        list1.add("l6");
//        list1.add("l7");
//        list1.add("l8");
//        list2.add("l9");
//        list2.add("l7");
//        list2.add("l10");
//        list2.add("l7");
//        list.addAll(list1);
//        list.addAll(5,list2);
//        Collections.replaceAll(list,"l7","lnew");
//
//        System.out.println(list.indexOf("l7"));
//        System.out.println(list.lastIndexOf("l7"));
//        System.out.println(" ");
//
//
//        for (String s: list) {
//            System.out.println(s);
//        }
//---------------------------------------------------------------------------------------------------------------------
    }
}


class MyOperator<T> implements UnaryOperator<T> {
    T varc1;

    public T apply(T varc) {
        return varc1;
    }
}

class Employee {
    private String name;
    private Integer age;
    private Double salary;

    public Employee(String name, Integer age, Double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String toString() {
        DecimalFormat dformat = new DecimalFormat(".##");
        return "EmployeeRAF Name:" + this.name
                + "  Age:" + this.age
                + "  Salary:" + dformat.format(this.salary);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return this.age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getSalary() {
        return this.salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(this.name, employee.name) &&
                Objects.equals(this.age, employee.age) &&
                Objects.equals(this.salary, employee.salary);
    }

    @Override
    public int hashCode() {

        return Objects.hash(this.name, this.age, this.salary);
    }
}

class ListReplaceAllExample {
    static List<Employee> employeeList = Arrays.asList(
            new Employee("Tom Jones", 45, 7000.00),
            new Employee("Harry Major", 25, 10000.00),
            new Employee("Ethan Hardy", 65, 8000.00),
            new Employee("Nancy Smith", 22, 12000.00),
            new Employee("Deborah Sprightly", 29, 9000.00));
}