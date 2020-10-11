package _static;

public class ExampleStaticFilds {
    public static void main(String[] args) {
        Employee employee0 = new Employee("Worker00");
        Employee employee1 = new Employee("Worker01");
        Employee employee2 = new Employee("Worker02");

        // takoi sposob ystanovki id ne bezopasen
//        employee0.establishId();
//        employee1.establishId();
//        employee2.establishId();
//        employee1.establishId();

        // lydwe ustanavlivat id v konsruktore pri sozdanii EmployeeRAF

        System.out.println(employee0.getId());
        System.out.println(employee1.getId());
        System.out.println(employee2.getId());

        System.out.println(employee0);
        System.out.println(employee1);
        System.out.println(employee2);

    }

}

class Employee {
    private static int nextId;
    private String name;
    private int id;

    public Employee(String name) {
        this.name = name;
        id = nextId;
        nextId++;
    }

    public String getName() {
        return this.name;
    }

    public int getId() {
        return this.id;
    }

    // takoi sposob ystanovki id ne bezopasen
//    public void establishId() {
//        this.id = nextId;
//        nextId++;
//    }

    @Override
    public String toString() {
        return "EmployeeRAF{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}