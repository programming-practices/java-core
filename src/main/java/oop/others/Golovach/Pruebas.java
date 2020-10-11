package YouTube_Channels.Golovach_Courses.Java_Core_December_2013.Core_OOP_1_December_2013;

public class Pruebas {
    public static void main(String[] args) {
        Integer int0 = new Integer(0);
        Integer int1 = new Integer(01);

        Class class0 = int0.getClass();
        Class class1 = int1.getClass();

        Object o = new Object();
        Class classObj = o.getClass();

        System.out.println(int0 == int1);               // false
        System.out.println(int0.equals(int1));          // false

        System.out.println();
        System.out.println(class0 == class1);           // true
        System.out.println(class0.equals(class1));      // true

        System.out.println();
        System.out.println(class0 == classObj);         // false
        System.out.println(class0.equals(classObj));    // false


//        Integer integer = (Integer) (Object) new String[]{"Hola", "Bye"};
    }
}


class A {
    void f() {

    }

    protected void g() {

    }
}

class B extends A {

    @Override
    protected void f() {

    }

    ////  ERROR
//    @Override
//    void g() {
//
//    }
}
