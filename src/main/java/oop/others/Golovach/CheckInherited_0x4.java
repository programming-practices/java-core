package YouTube_Channels.Golovach_Courses.Java_Core_December_2013.Core_OOP_2_December_2013;

public class CheckInherited_0x4 {
    public static void main(String[] args) {
        A4 a4 = new C4();
        System.out.println(a4.name);
    }
}

class A4 {
    public String name = "A4";
}

class B4 extends A4 {
    public String name = "B4";
}

class C4 extends B4 {
    public String name = "C4";
}

//  OUT >>> A4