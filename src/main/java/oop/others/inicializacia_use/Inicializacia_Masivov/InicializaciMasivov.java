package Examples.OOP.Others.inicializacia_use.Inicializacia_Masivov;

public class InicializaciMasivov {
    static void f(int a, String... array) {
        System.out.println(a);
        for (String n : array) {
            System.out.print(n + "  ");
        }
    }

    static void printArray(Object... array) {
        for (Object o : array) {
            System.out.print(o + "  ");
        }
    }

    static void printArray2(Object[] array) {
        for (Object o : array) {
            System.out.print(o + "  ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        f(10, "rrrr", "1", "vgg");
        System.out.println();
        System.out.println();
        printArray(new Integer[]{1, 1, 1, 1, 1});
        System.out.println();
        System.out.println();
        printArray2(new Object[]{new Integer(3), new Float(3.3), new Double(4.4)});
        printArray2(new Object[]{new A(), new A(),});
        printArray2(new Object[]{new A(), new Integer(1), new String("lll")});
    }

    static class A {
        String i;

        private A() {
            this.i = "Cllas \"A\"";

        }
    }
}
