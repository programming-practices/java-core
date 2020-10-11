package Examples.OOP.Others.nasledovanie_use.nasledovanie_Zaverwenie_Deistvia;

public class Characteristic {
    private String s;

    Characteristic(String s) {
        this.s = s;
        System.out.println("Sozdanie Characteristic " + s);
    }

    protected void dispose() {
        System.out.println("Zavershenie Characteristic" + s);
    }
}
