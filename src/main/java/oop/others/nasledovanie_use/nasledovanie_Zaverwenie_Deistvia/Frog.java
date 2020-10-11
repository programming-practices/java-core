package Examples.OOP.Others.nasledovanie_use.nasledovanie_Zaverwenie_Deistvia;

public class Frog extends Amphibian {
    Characteristic c = new Characteristic("Imeet serce");
    Description d = new Description("Zivotnoe ne rastenie");

    Frog() {
        System.out.println("Sozdanie Frog ");
    }

    protected void dispose() {
        System.out.println("dispose() v Frog ");
        c.dispose();
        d.dispose();
        super.dispose();
    }
}
