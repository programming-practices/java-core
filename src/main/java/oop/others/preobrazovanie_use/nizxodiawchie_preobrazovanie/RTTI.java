package oop.others.preobrazovanie_use.nizxodiawchie_preobrazovanie;

public class RTTI {
    public static void main(String[] args) {
        Useful[] x = {new Useful(),
                new MoreUseful()};

        x[0].f();
        x[1].g();
//        tamanoPequenio[1].u();
        ((MoreUseful) x[1]).u();
//        ((MoreUseful)tamanoPequenio[0]).u();
    }
}
