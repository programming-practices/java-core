package YouTube_Channels.Golovach_Courses.Java_Core_December_2013.Core_OOP_3_December_2013;

public class App_0x2 {
    public class Inner {

    }
}


class Test_0x2 {
    public static void main(String[] args) {
        App_0x2 ref0 = new App_0x2();
//        App_0x2.Inner inner = new App_0x2.Inner();    //  ERROR
        App_0x2.Inner reg1 = ref0.new Inner();
        App_0x2.Inner reg2 = new App_0x2().new Inner();
    }
}

