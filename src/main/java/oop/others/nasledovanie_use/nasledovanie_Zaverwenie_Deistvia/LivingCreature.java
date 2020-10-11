package Examples.OOP.Others.nasledovanie_use.nasledovanie_Zaverwenie_Deistvia;

public class LivingCreature {
    Characteristic c = new Characteristic("Zivoe syschestvo");
    Description d = new Description("Obichnoe zivoe syschestvo");

    LivingCreature() {
        System.out.println("Sozdanie LivingCreature ");
    }

    protected void dispose() {
        System.out.println("dispose() v LivingCreature ");
        c.dispose();
        d.dispose();
    }
}
