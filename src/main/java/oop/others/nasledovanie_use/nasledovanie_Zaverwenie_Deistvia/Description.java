package Examples.OOP.Others.nasledovanie_use.nasledovanie_Zaverwenie_Deistvia;

public class Description {
    private String s;

    Description(String s) {
        this.s = s;
        System.out.println("Sozdanie Descripcion " + s);
    }

    protected void dispose() {
        System.out.println("Zavershenie Descripcion " + s);
    }
}
