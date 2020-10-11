package oop;

public class ExampleOverloadMethod {

    public static void main(String args[]) {
//--------------------------------------------------------------------------------------------------------------------
        ExampleOverloadMethod test = new ExampleOverloadMethod();
        test.method(null);
//--------------------------------------------------------------------------------------------------------------------
        int a = 2;
        int b = 3;
        ClassU.method(a, b);
//--------------------------------------------------------------------------------------------------------------------
        Overload test3 = new Overload();
//        test3.method(null);
//--------------------------------------------------------------------------------------------------------------------
    }

    public void method(Object o) {
        System.out.println("object");
    }

    public void method(java.io.FileNotFoundException f) {
        System.out.println("FileNotFoundException");
    }

    public void method(java.io.IOException i) {
        System.out.println("IOException");
    }


}

class Parent {
    public void publicFinalMethod() {
    }

    public void publicFinalMethod(int i) {
    }

    public void publicFinalMethod(String s) {
    }
}

class Childer extends Parent {
    //Attention   Overlload metod form Parent
    public final void publicFinalMethod(Object obj) {
    }
}

class ClassU {
    static void method(int... a) {
        System.out.println("inside int...");
    }

    static void method(long a, long b) {
        System.out.println("inside long");
    }

    static void method(Integer a, Integer b) {
        System.out.println("inside INTEGER");
    }
}

class Overload {
    public void method(Object o) {
        System.out.println("object");
    }

    public void method(String s) {
        System.out.println("String");
    }

    public void method(StringBuffer sb) {
        System.out.println("StringBuffer");
    }
}
