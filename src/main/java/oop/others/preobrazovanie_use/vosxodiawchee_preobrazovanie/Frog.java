package oop.others.preobrazovanie_use.vosxodiawchee_preobrazovanie;

public class Frog extends Anphibia {
    @Override
    protected void hretsaNaSonce(boolean b) {
        super.hretsaNaSonce(b);
        System.out.println("Metod hretcaNaSonce cllassa Frog");
    }

    @Override
    protected void lazat(int velosidad) {
        super.lazat(velosidad);
        System.out.println("Metod lazat classa Frog");
    }

    @Override
    protected void plavat(int vlosidad) {
        super.plavat(vlosidad);
        System.out.println("Metod plavat classa Frog");
    }

    void jj() {
        System.out.println("Metod jj classa Frog");
//        super.jj();
    }
}
