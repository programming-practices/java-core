package varargs;

// Varargs, overloading, and ambiguity.
// This program contains an error and will not compile!
public class Varargs {
    public static void main(String args[]) {
//--------------------------------------------------------------------------------------------------------------------
        TestVarargs00.vaTest(1, 2, 3);  // OK
        TestVarargs00.vaTest(true, false, false); // OK

//        TestVarargs00.vaTest(); // Error: Ambiguous!
//--------------------------------------------------------------------------------------------------------------------
//        TestVarargs01.vaTest(1);  // Error: Ambiguous!
//--------------------------------------------------------------------------------------------------------------------
        TestVarargs02.methodA(new int[]{1, 2, 3});

//        TestVarargs02.methodB(1,2,3);      //ERROR
        TestVarargs02.methodB(new int[2], new int[3], new int[4]);      //ERROR
//--------------------------------------------------------------------------------------------------------------------
        TestVarargs03.vaTest("One vararg: ", 10);
        TestVarargs03.vaTest("Three varargs: ", 1, 2, 3);
        TestVarargs03.vaTest("No varargs: ");
//--------------------------------------------------------------------------------------------------------------------
        // Notice how vaTest() can be called with age
        // variable number of arguments.
        TestVarargs04.vaTest(10);      // 1 arg
        TestVarargs04.vaTest(1, 2, 3); // 3 args
        TestVarargs04.vaTest();        // no args
//--------------------------------------------------------------------------------------------------------------------
        // Если вызвать метод max () следующим образом:
        double m = max(3.1, 40.4, -5);
        // компилятор передаст этому методу параметры в виде такого выражения: new double[] { 3.1, 40.4, -5 };
//--------------------------------------------------------------------------------------------------------------------
        TestVarargs05.vaTest(1, 2, 3);
        TestVarargs05.vaTest("Testing: ", 10, 20);
        TestVarargs05.vaTest(true, false, false);
        TestVarargs05.vaTest("Testing2: ", 5);
        TestVarargs05.vaTest(5);
        TestVarargs05.vaTest(5, 3);
//--------------------------------------------------------------------------------------------------------------------
    }

    public static double max(double... values) {
        double largest = Double.MIN_VALUE;
        for (double v : values) if (v > largest) largest = v;
        return largest;
    }
}

class TestVarargs {

    public void mthod00(int i, int j, int... n) {
    }

//    public void mthod01(int ... n, int i, int j){ }  // ERROR  vararg maie bytu v kinci spuska arhymentov

//    public void mthod01(int i, int j, int ... n1, int ... n2){ }  // ERROR  vararg moze bytu ilku odun v spiske arhymentov
}

class TestVarargs00 {
    static void vaTest(int... intVarags) {
        System.out.print("vaTest(Integer ...): " + "Number of args: " + intVarags.length + " Contents: ");
        for (int x : intVarags) System.out.print(x + " ");
        System.out.println();
    }

    static void vaTest(boolean... booleanVarags) {
        System.out.print("vaTest(boolean ...) " + "Number of args: " + booleanVarags.length + " Contents: ");
        for (boolean x : booleanVarags) System.out.print(x + " ");
        System.out.println();
    }
}

class TestVarargs01 {

    static void vaTest(int... v) {
        System.out.print("vaTest(Integer ... v): " + "Number of args: " + v.length + " Contents: ");
        for (int x : v) System.out.print(x + " ");
        System.out.println();
    }

    static void vaTest(int value, int... v) {
        System.out.print("vaTest(int value, Integer ... v): " + " value = " + value + " Contents: ");
        for (int x : v) System.out.print(x + " ");
        System.out.println();
    }
}

class TestVarargs02 {

    static void methodA(int... a) {
        for (int i = 0; i < a.length; ++i) {
            System.out.println(a[i]);
        }
    }

    static void methodB(int[]... a) {
        for (int i = 0; i < a.length; ++i) {
            System.out.println(a[i]);
        }
    }
}

// Use varargs with standard arguments.
class TestVarargs03 {
    // Here, msg is age normal parameter and v is age
    // varargs parameter.
    static void vaTest(String msg, int... v) {
        System.out.print(msg + v.length + " Contents: ");
        for (int x : v) System.out.print(x + " ");
        System.out.println();
    }
}

// Demonstrate variable-length arguments.
class TestVarargs04 {
    // vaTest() now uses age vararg.
    static void vaTest(int... v) {
        System.out.print("Number of args: " + v.length + " Contents: ");
        for (int x : v) System.out.print(x + " ");
        System.out.println();
    }
}

// Varargs and overloading.
class TestVarargs05 {

    static void vaTest(int... v) {
        System.out.print("vaTest(int ... n): " + "Number of args: " + v.length + " Contents: ");

        for (int x : v) System.out.print(x + " ");

        System.out.println();
    }

    static void vaTest(boolean... v) {
        System.out.print("vaTest(boolean ... n) " + "Number of args: " + v.length + " Contents: ");

        for (boolean x : v) System.out.print(x + " ");

        System.out.println();
    }

    static void vaTest(String msg, int... v) {
        System.out.print("vaTest(String msg, int ... n): " + msg + v.length + " Contents: ");

        for (int x : v) System.out.print(x + " ");

        System.out.println();
    }

    static void vaTest(String msg, int v) {
        System.out.print("vaTest(String msg, int v)  Contents: " + msg + ", " + v);

        System.out.println();
    }

    static void vaTest(int v) {
        System.out.print("vaTest(int v)  Contents: " + v);

        System.out.println();
    }
}

/*
----------------------------------------------------------------------------------------------------------------------
НА ЗАМЕТКУ! В качестве последнего параметра метода, число параметров которого может быть
переменным, допускается задавать массив следующим образом:
System.out.printf ("%d %s", new Object[] { new Integer(1), "widgets" } );
Таким образом, существующий метод, последний параметр которого является массивом, можно
переопределить как метод с переменным числом параметров, не изменяя уже имеющийся код.
Подобным образом в версии Java SE 5.0 был расширен метод MtessageFormat.format ( ) . При
ж елании метод main() можно даже объявить следующим образом:
public static void main(String... args)
----------------------------------------------------------------------------------------------------------------------
*/