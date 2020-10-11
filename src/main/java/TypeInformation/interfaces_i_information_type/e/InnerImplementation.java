package TypeInformation.interfaces_i_information_type.e;

import TypeInformation.interfaces_i_information_type.A;

class InnerA {

    public static A makeA() {
        return new C();
    }

    private static class C implements A {

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
        }

        private void w() {
            System.out.println("private C.w()");
        }
    }
}

public class InnerImplementation {
    public static void main(String[] args) throws Exception {
        A a = InnerA.makeA();
        a.f();
        System.out.println(a.getClass().getName());
        // Reflection still gets into the private class:
        HiddenImplementation.callHiddenMethod(a, "threeTuple");
        HiddenImplementation.callHiddenMethod(a, "u");
        HiddenImplementation.callHiddenMethod(a, "v");
        HiddenImplementation.callHiddenMethod(a, "w");
    }
}
