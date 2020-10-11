package Examples.OOP.Others.nasledovanie_use.n2;

public class Steam extends Root {
    Steam(String name) {
        super("r");
        System.out.println("Constructor classa Steam tamanoMediano su nombre " + name);
    }

    void dispose() {
        System.out.println("Dispose Steam (se borra Steam)");
        super.dispose();
    }
}
