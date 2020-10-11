package advanced;

public class ExamplePrivateFinalMethod {
    public static void main(String[] args) {
//--------------------------------------------------------------------------------------------------------------------

        One one = new Two();
        one.executeMathod();

        Two two = new Two();
        two.executeMathod();
//--------------------------------------------------------------------------------------------------------------------

        One_2 one_2 = new Two_2();
        one_2.executeMathod(one_2);

        Two_2 two_2 = new Two_2();
        two_2.executeMathod(two_2);
//--------------------------------------------------------------------------------------------------------------------

        One_3 one_3 = new Two_3();
        One_3.executeMathod(one_3);

        Two_3 two_3 = new Two_3();
        Two_3.executeMathod(two_3);
//--------------------------------------------------------------------------------------------------------------------
    }
}

class One {
    private final void method() {
        System.out.println("one");
    }

    void executeMathod() {
        One one = new Two();
        one.method();
    }
}

class Two extends One {
    void method() {
        System.out.println("two");
    }
}

class One_2 {
    private final void method() {
        System.out.println("one");
    }

    void executeMathod(One_2 one2Value) {
        One_2 one_2 = one2Value;
        one_2.method();
    }
}

class Two_2 extends One_2 {
    void method() {
        System.out.println("two");
    }
}

class One_3 {
    static void executeMathod(One_3 one3Value) {
        One_3 one_3 = one3Value;
        one_3.method();
    }

    private final void method() {
        System.out.println("one");
    }
}

class Two_3 extends One_3 {
    void method() {
        System.out.println("two");
    }
}