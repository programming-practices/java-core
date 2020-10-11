package oop.others.overload;

public class Main {

    public static void main(String[] args) {

        Chelovek chelovek = new Chelovek();
        chelovek.p(1);
        chelovek.p(1, "w");
        chelovek.p(1, "w", true);
        chelovek.p(1, "w", true, 'a');

    }

}
