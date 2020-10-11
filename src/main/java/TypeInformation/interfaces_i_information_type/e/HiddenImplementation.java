package TypeInformation.interfaces_i_information_type.e;

import TypeInformation.interfaces_i_information_type.A;
import TypeInformation.interfaces_i_information_type.HiddenC;

import java.lang.reflect.Method;

public class HiddenImplementation {
    public static void main(String[] args) throws Exception {
        A a = HiddenC.makeA();
        a.f();
        System.out.println(a.getClass().getName());
        // Compile error: cannot find symbol 'C':
//        if (a instanceof C) {
//            C c = (C) a;
//            c.threeTuple();
//        }
        // Oops! Reflection still allows us to call threeTuple():
        callHiddenMethod(a, "threeTuple");
        // And even methods that are less accessible!
        callHiddenMethod(a, "u");
        callHiddenMethod(a, "v");
        callHiddenMethod(a, "w");
    }

    static void callHiddenMethod(Object a, String methodName) throws Exception {
        Method g = a.getClass().getDeclaredMethod(methodName);
        g.setAccessible(true);
        g.invoke(a);
    }
}
