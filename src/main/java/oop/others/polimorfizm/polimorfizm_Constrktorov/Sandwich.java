package Examples.OOP.Others.polimorfizm.polimorfizm_Constrktorov;

public class Sandwich extends PortableLunch implements FastFood {
    static String name;
    Bread bread = new Bread();
    Cheese cheese = new Cheese();
    Lettuce lettuce = new Lettuce();
    Pickle pickle = new Pickle();

    Sandwich() {
        System.out.println("Sandwich");
    }

    @Override
    public void vender() {
        System.out.println("Se vende comida de FastFood.");
    }
}
