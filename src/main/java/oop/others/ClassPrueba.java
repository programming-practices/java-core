package Examples.OOP.Others;


public class ClassPrueba {
    public static void main(String[] args) {
        Integer integer = 3;
        Integer integerNEW = new Integer(3);
        int intVlue = 3;

        ClassAgh.methodComp(integer);
        ClassAgh.methodComp(integerNEW);
        ClassAgh.methodComp(intVlue);

        System.out.println(integer);
        System.out.println(integerNEW);
        System.out.println(intVlue);


        int intValue = 23;
        double doubleValue = 1.23;
        ClassAgh classAgh = new ClassAgh();
        classAgh.method1();
        classAgh.method1(intValue);
        classAgh.method1(doubleValue);
    }
}

class ClassPr {
    private int age;
    private int weight;

    public ClassPr(int age, int weight) {
        this.age = age;
        this.weight = weight;
    }

    public static void methodComp(ClassPr classPrueba) {

    }
}

class ClassAgh {
    private int age;
    private double weight;
    private String name;

    public static void methodComp(int value) {
        value = value + 1;

    }

    public void method1() {
        System.out.println("Methodo empty.");
    }

    public void method1(double weight) {
        System.out.println("Methodo with one parameter double.");
    }

    public void method1(int age, int age2) {
        System.out.println("Methodo whit tow parameters int.");
    }
}
