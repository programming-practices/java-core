package Examples.OOP.Others.nasledovanie_use.nasledovanie_Zaverwenie_Deistvia;

public class Amphibian extends Animal {
    Characteristic c = new Characteristic("Mozet zit v vode");
    Description d = new Description("I v vode i na more");

    Amphibian() {
        System.out.println("Sozdanie Anphibia ");
    }

    protected void dispose() {
        System.out.println("dispose() v Amphibia ");
        c.dispose();
        d.dispose();
        super.dispose();
    }
}
