package OOP.Others.klassu_vnytri_interfeisov.podobie_nasledovania_dvox_classov;

public class MultiImplementation {
    static void takesD(D d) {
    }

    static void takesE(E e) {
    }

    public static void main(String[] args) {
        Z z = new Z();
        takesD(z);
        takesE(z.madeE());
    }
}
