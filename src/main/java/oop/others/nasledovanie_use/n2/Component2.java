package Examples.OOP.Others.nasledovanie_use.n2;

public class Component2 {
    Component2(String name) {
        System.out.println("Constructodr clasa Component2 tamanoMediano su nombre " + name);
    }

    void dispose() {
        System.out.println("Dispose Component2 (se borra Component2)");
    }
}
