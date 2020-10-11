package Examples.OOP.Others.nasledovanie_use.n2;

public class Component1 {
    Component1(String name) {
        System.out.println("Constructo classa Component1 tamanoMediano su nombre " + name);
    }

    void dispose() {
        System.out.println("Dispose Component1 (se borra Component1)");
    }
}
