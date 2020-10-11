package Examples.Reflection_API;

// Demonstrate Run-Time Type Information.
// Run Time Type Indentification
public class ExampleRTTI_Run_Time_Type_Information {
    public static void main(String args[]) {
        ClassA classA = new ClassA();
        ClassB classB = new ClassB();

        Class<?> classClassA = classA.getClass(); // get Class reference
        System.out.println("x is object of type: " + classClassA.getSimpleName());

        classClassA = classB.getClass(); // get Class reference
        System.out.println("y is object of type: " + classClassA.getSimpleName());

        classClassA = classClassA.getSuperclass();
        System.out.println("y's superclass is " + classClassA.getSimpleName());

        System.out.println(ExampleRTTI_Run_Time_Type_Information.class.getClassLoader());
        System.out.println(Integer.class.getClassLoader());
    }
}

class ClassA {
    int valueInt;
    float valueFloat;
}

class ClassB extends ClassA {
    double valueDouble;
}

