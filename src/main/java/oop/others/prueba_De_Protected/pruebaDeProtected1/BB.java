package oop.others.prueba_De_Protected.pruebaDeProtected1;

import oop.others.prueba_De_Protected.A;

public class BB extends A {
    public static void main(String[] args) {
        A a = new A();
    }

    protected void printBBProtected() {
        System.out.println("Metod Protected BB");
    }

    public void printBBPublic() {
        System.out.println("Metod Public BB");
    }
}
