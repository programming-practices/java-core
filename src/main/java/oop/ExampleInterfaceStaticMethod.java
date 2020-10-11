package Examples.OOP;

interface InterfaceA1 {

    static void getName() {
        System.out.println("InterfaceA.getName()");
    }

    ;

//    final static void getNumberStaticFinal(){};      // ERROR

//    final void getNumberFinal(){};              // ERROR

//    final default void getNumberFinal(){};      // ERROR

    int getAge();

    default String getString() {
        return "Default getString() InterfaceA";
    }
}

interface InterfaceB1 extends InterfaceA1 {
    //    @Override  // Etot metod ne overrider
    void getName();

    @Override
    int getAge();

    @Override
    default String getString() {
        return "Default getString() InterfaceB";
    }
}

public class ExampleInterfaceStaticMethod {
    public static void main(String[] args) {

        InterfaceA1.getName();
//                PryebasMethodsStatic.getNumberNoStatic();  // ERROR
        InterfaceB1 interfaceB = new InterfaceB1() {
            @Override
            public void getName() {
                System.out.println("12");
            }

            @Override
            public int getAge() {
                return 90;
            }
        };

        interfaceB.getName();
    }
}


