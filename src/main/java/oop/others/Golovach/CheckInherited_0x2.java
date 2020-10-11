package YouTube_Channels.Golovach_Courses.Java_Core_December_2013.Core_OOP_2_December_2013;

public class CheckInherited_0x2 {
    public static void main(String[] args) {
        A2 a = new C2();
//        a.methodoImprimir();

        B2 b = new C2();
        b.f();
    }
}


class A2 {
//    public void methodoImprimir(){
//        System.out.println("a.methodoImprimir()");
//    }
}

class B2 extends A2 {
    public void f() {
        System.out.println("b.methodoImprimir()");
    }
}

class C2 extends B2 {

}