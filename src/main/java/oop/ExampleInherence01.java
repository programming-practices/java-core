package Examples.OOP;

interface InterfaceA41 {
    public static void methodStatic() {
        System.out.println("Method Static interfeisa InterfaceA");
    }

    public int methodInterfeisA();

    default public void methodDefaultA() {
        System.out.println("Method InterfaceA!");
        throw new UnsupportedOperationException("Not defined method  body!!!");
    }

}


interface InterfaceB41 {
    public int methodInterfeisa();

    default public void methodDefaultB() {
        System.out.println("Method InterfaceB!");
        throw new UnsupportedOperationException("Not defined method  body!!!");
    }
}

interface InterfaceC41 extends InterfaceA41 {
    @Override
    default void methodDefaultA() {
        InterfaceA41.super.methodDefaultA();
    }

}

public class ExampleInherence01 {
    public static void main(String[] args) {
        ClassA41 classA41;
        ClassB41 classB = new ClassB41();
        ClassC41 classC = new ClassC41();
        classC.methodInterfeisA();
//        classC.methodDefaultA();
//        classC.methodDefaultB();
        ClassD41 classD = new ClassD41();
        classD.methodDefaultA();
//        classA = classB;
//        classA.method();
//        classB.methodIzClassaB();
////        classA.methodIzClassaB();   // ERROR
//
//        classB.methodFinal("hola");
//        classA.methodFinal();
//
//        classA.methodOverloaded();
////        classA.methodOverloaded("hola");    //   ERROR
//        classB.methodOverloaded("hola");
//        classB.methodOverloaded();
//
//        System.out.println();
//
//
//
//        classA = classC;
//        classA.method();
//        classC.methodIzClassaC();
////        classA.methodIzClassaC();   // ERROR
    }
}

class ClassA41 {

    public void method() {
        System.out.println("Method classa ClassA");
    }

    public final void methodFinal() {
        System.out.println("MethodFinal classa ClassA");
    }

    public void methodOverloaded() {
        System.out.println("MethodOverloaded classa ClassA");
    }

}

class ClassB41 extends ClassA41 {

    @Override
    public void method() {
        System.out.println("Method classa ClassB");
    }

    public void methodIzClassaB() {
        System.out.println("BBB");
    }

    public void methodFinal(String s) {
        System.out.println("MethodFinal classa ClassB  " + s);
    }


    public void methodOverloaded(String s) {
        System.out.println("MethodOverloaded classa ClassB   " + s);
    }
}

class ClassC41 extends ClassB41 implements InterfaceA41, InterfaceB41 {

    @Override
    public void method() {
        System.out.println("Method classa ClassC");
    }

    public void methodIzClassaC() {
        System.out.println("CCC");
    }


    @Override
    public int methodInterfeisA() {
        return 0;
    }

    @Override
    public int methodInterfeisa() {
        return 0;
    }
}

class ClassD41 extends ClassC41 {


}

class ClassE41 implements InterfaceC41 {

    @Override
    public int methodInterfeisA() {
        return 0;
    }

    @Override
    public void methodDefaultA() {

    }
}

class ClassF41 implements InterfaceA41 {
    @Override
    public int methodInterfeisA() {
        return 0;
    }

}
