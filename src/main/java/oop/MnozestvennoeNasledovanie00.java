package additional;

interface A00 {
    default void run() {
        System.out.println("A");
    }
}

interface B00 {
    default void run() {
        System.out.println("B");
    }
}

public class MnozestvennoeNasledovanie00 implements A00, B00 {
    public static void main(String[] args) {
        new MnozestvennoeNasledovanie00().run();
    }

    @Override
    public void run() {
        System.out.println("eee");
    }
}


