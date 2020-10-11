package Examples.OOP;

interface Car {
    default void drive() {
        System.out.println("Car drive");
    }
}

interface Motocicle {
    void drive();
}

public class MultipleInheritenceLesson {
    public static void main(String[] args) {
        MyNewCar myNewCar = new MyNewCar();
        myNewCar.drive();
    }
}

class Toyota implements Car {
    public void drive() {
        System.out.println("toyota drive");
    }
}

class Yamaha implements Motocicle {
    public void drive() {
        System.out.println("Yamaha drive");
    }
}

class MyNewCar implements Car, Motocicle {
    public void drive() {
        System.out.println("MyNewCar drive");
    }
}