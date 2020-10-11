package oop;

public class ExampleClassLoader {
    public static void main(String[] args) {
// ---------------------------------------------------------------------------------------------------------------------
//        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
//        String nameClass = ExampleAssert.class.getName();
//        classLoader.setClassAssertionStatus(nameClass, true);
//        ExampleAssert.main(null);
// ---------------------------------------------------------------------------------------------------------------------
        TestClassLoader tCL = new TestClassLoader("Name", 34);
        Class<? extends TestClassLoader> aClass = tCL.getClass();
        ClassLoader classLoader1 = aClass.getClassLoader();
        System.out.println(classLoader1);
// ---------------------------------------------------------------------------------------------------------------------
    }
}

class TestClassLoader {
    private String name;
    private int age;

    public TestClassLoader(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

/*
----------------------------------------------------------------------------------------------------------------------
multi-tenancy что это
----------------------------------------------------------------------------------------------------------------------
•void setDefaultAssertionStatus (boolean b) 1.4
    Разрешает или запрещает утверждения во всех классах, загруженных указанным загрузчиком
    классов, в которых состояние утверждений не задано явным образом.

•void setClassAssertionStatus (String className, boolean b) 1.4
    Разрешает или запрещает утверждения в заданном классе и его подклассах.

•void setPackageAssertionStatus (String packageName, boolean b) 1.4
    Разрешает или запрещает утверждения во всех классах заданного пакета и его подчиненных пакетов.

•void clearAssertionStatus() 1.4
    Удаляет все утверждения, состояние которых задано явным образом, а также запрещает все утверждения в классах,
    загруженны х данным загрузчиком.
----------------------------------------------------------------------------------------------------------------------
*/
