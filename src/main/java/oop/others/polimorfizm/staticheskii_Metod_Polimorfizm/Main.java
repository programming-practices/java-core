package Examples.OOP.Others.polimorfizm.staticheskii_Metod_Polimorfizm;

public class Main {
    public static void main(String[] args) {
        StaticSuper su = new StaticSub();
        System.out.println(StaticSuper.getStatic());
        System.out.println(StaticSub.getStatic());
        System.out.println(su.dynamicGet());

    }
}
