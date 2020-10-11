package Examples.OOP.Others.polimorfizm.polimorfizm_Rabota_S_Poliami;

public class Sub extends Super {
    int fild = 1;

    @Override
    public int getFild() {
        return fild;
    }

    public int getFildSuper() {
        return super.getFild();
    }
}
