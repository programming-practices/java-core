package OOP.Others.interfase_use.interfases_I_fabricas;

public class Factories {
    public static void serviceConsumer(ServiceFactory factory) {

        Service s = factory.getService();
        s.metod1();
        s.metod2();

    }

}
