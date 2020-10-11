package YouTube_Channels.Golovach_Courses.Java_Core_December_2013.Core_OOP_3_December_2013;

public class App_0x1 {
    public App_0x1() {
        System.out.println("Konstryktor classa App_0x1");
    }

    static class Nested {
        public Nested() {
            System.out.println("Konstryktor classa App_0x1.Nested");
        }
    }
}


class Test_0_1 {
    public static void main(String[] args) {
        App_0x1 app = new App_0x1();
        App_0x1.Nested nested = new App_0x1.Nested();
    }
}
