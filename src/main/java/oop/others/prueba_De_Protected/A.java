package oop.others.prueba_De_Protected;

import oop.others.prueba_De_Protected.pruebaDeProtected1.AA;
import oop.others.prueba_De_Protected.pruebaDeProtected1.BB;

public class A extends AA {
    static BB bb = new BB();

    public static void main(String[] args) {
        AA aa = new AA();
        A a = new A();
        a.printAProtected();
        a.printAAProtected();
        a.printAAPublic();

        aa.printAAPublic();
        bb.printBBPublic();


    }

    protected void printAProtected() {
        System.out.println("Metod A Protected");
        super.printAAProtected();
    }
}
