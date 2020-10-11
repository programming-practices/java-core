package YouTube_Channels.Golovach_Courses.Java_Core_December_2013.Core_OOP_3_December_2013;

public class App_0x3 {
    int k;

    public App_0x3(int k) {
        this.k = k;
    }

    public class Inner {
        public void f() {
            System.out.println(k++);
        }
    }
}


class Test_0x3 {
    public static void main(String[] args) {
        App_0x3 app = new App_0x3(100);
        App_0x3.Inner inner0 = app.new Inner();
        App_0x3.Inner inner1 = app.new Inner();
        inner0.f();
        inner1.f();
        inner0.f();
        inner1.f();
    }
}

