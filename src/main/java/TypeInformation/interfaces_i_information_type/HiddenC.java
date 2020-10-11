package TypeInformation.interfaces_i_information_type;

class C implements A {
    public void f() {
        System.out.println("public C.fArgInt()");
    }

    public void g() {
        System.out.println("public C.threeTuple()");
    }

    void u() {
        System.out.println("package C.u()");
    }

    protected void v() {
        System.out.println("protected C.v()");
        System.out.println(2 * 2);
    }

    private void w() {
        System.out.println("private C.w()");
        System.out.println(4 * 4);
    }
}

public class HiddenC {
    public static A makeA() {
        return new C();
    }
}
