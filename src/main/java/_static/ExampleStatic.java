package _static;

public class ExampleStatic {
    static String str = "Value 1";

    public static void main(String[] args) {
//----------------------------------------------------------------------------------------------------------------------
//        System.out.println(Child.ID);
//----------------------------------------------------------------------------------------------------------------------
        changeIt(str);
        System.out.println(str);
//----------------------------------------------------------------------------------------------------------------------
    }

    public static void changeIt(String s) {
        s = "Value 2";
    }
}

class Parent {
    static String ID = "Fild super";
}


class Child extends Parent {
    static {
        System.out.print("In Sub");
    }
}
