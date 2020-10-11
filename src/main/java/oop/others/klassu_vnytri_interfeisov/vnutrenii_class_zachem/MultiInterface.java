package Examples.OOP.Others.klassu_vnytri_interfeisov.vnutrenii_class_zachem;

public class MultiInterface {
    static void takesA(A a) {
    }

    static void takesB(B b) {
    }

    public static void main(String[] args) {
        X x = new X();
        Y y = new Y();
        takesA(x);
        takesA(y);
        takesB(x);
        takesB(y.makeB());
    }
}
