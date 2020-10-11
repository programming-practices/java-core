package generics.realizacia_parametrizirovanux_interfeisov;

interface Payable<T> {
}

public class Employee implements Payable<Employee> {
}

//class Hourly extends EmployeeRAF implements Payable<Hourly> {}
class Hourly extends Employee {
}
