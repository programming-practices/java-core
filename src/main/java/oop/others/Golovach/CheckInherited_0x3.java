package YouTube_Channels.Golovach_Courses.Java_Core_December_2013.Core_OOP_2_December_2013;

public class CheckInherited_0x3 {
    public static void main(String[] args) {
        A3 a3 = new C3();
//        a3.g();  // ERROR

        if (a3 instanceof C3) {
            C3 c3 = (C3) a3;
            c3.g();
        }
    }
}


class A3 {
    public void f() {
        System.out.println("a.methodoImprimir()");
    }
}


class B3 extends A3 {
    public void f() {
        System.out.println("b.methodoImprimir()");
    }
}


class C3 extends B3 {
    public void g() {
        System.out.println("c.methodoImprimir()");
    }
}