package oop.others.Golovach;

public class App_0x0 {
    private int i = 9;

    public static void main(String[] args) {
        System.out.println(new Nested().r);
    }

    static class Nested {
        private int r = 5;

        public static void m() {
            System.out.println(new App_0x0().i);
        }
    }
}


class A {
    public static void main(String[] args) {
//        System.out.println(new Pruebas.Nested().i);
    }
}
