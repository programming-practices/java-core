package generics;


public class ExampleGenericsConstructor {
    public static void main(String args[]) {
        GenCons test = new GenCons(100);
        GenCons test2 = new GenCons(123.5F);
//        GenCons test3 = new GenCons("s");    //ERROR
        test.showval();
        test2.showval();
    }
}

// Use age generic constructor.
class GenCons {
    private double val;

    <T extends Number> GenCons(T arg) {
        val = arg.doubleValue();
    }

    void showval() {
        System.out.println("val: " + val);
    }
}
