package generics.sozdanie_ekzempliarov_tipov;

public class InstantiateGenericType {

    public static void main(String[] args) {

        ClassAsFactory<Employee> fe = new ClassAsFactory<Employee>(Employee.class);

        System.out.println("ClassAsFactory<EmployeeRAF> succeeded");

        try {

            ClassAsFactory<Integer> fi = new ClassAsFactory<Integer>(Integer.class);

        } catch (Exception e) {
            System.out.println("ClassAsFactory<Integer> failed");
        }
    }
}
