package OOP.Others.interfase_use.interfases_I_fabricas;

public class Main {
    public static void main(String[] args) {

        Factories.serviceConsumer(new Implementation1Factory());

        // Realizacia polnostiy vzaimozaminaima:

        Factories.serviceConsumer(new Implementation2Factory());

    }
}
