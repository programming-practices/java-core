package Examples.OOP.Others.nasledovanie_use.nasledovanie_Zaverwenie_Deistvia;

public class Animal extends LivingCreature {
    Characteristic c = new Characteristic("Imeet serce");
    Description d = new Description("Zivotnoe ne rastenie");

    Animal() {
        System.out.println("Sozdanie LivingCreature ");
    }

    protected void dispose() {
        System.out.println("dispose() v Animal ");
        c.dispose();
        d.dispose();
        super.dispose();
    }
}
