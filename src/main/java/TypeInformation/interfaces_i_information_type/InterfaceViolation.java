package TypeInformation.interfaces_i_information_type;


public class InterfaceViolation {
    public static void main(String[] args) {
        A a = new B();
        a.f();
//         a.threeTuple(); // Compile error
        System.out.println(a.getClass().getName());
        if (a instanceof B) {
            B b = (B) a;
            b.g();
        }
    }
}
