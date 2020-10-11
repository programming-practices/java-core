package advanced;

public class ExampleOverriding {
    public static void main(String[] args) {
        ExampleOverriding object = new ExampleOverriding();
        object.method(null);
        object.equals(null);
    }

    void method(Parent p) {
        System.out.println("parent");
    }

    void method(Child c) {
        System.out.println("child");
    }
}

class Parent {

}

class Child extends Parent {

}


