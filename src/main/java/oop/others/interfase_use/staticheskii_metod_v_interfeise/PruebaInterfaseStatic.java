package OOP.Others.interfase_use.staticheskii_metod_v_interfeise;

public interface PruebaInterfaseStatic {
    static String metodStatic() {
        return "Staticheskii metod interfeisa!";
    }

    void f();

    default void metodDefault() {
        System.out.println("Default metod interfeisa PruebaInterfaseStatic!");
    }
}
