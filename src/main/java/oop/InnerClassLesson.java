package oop;

public class InnerClassLesson {

    private static int j = 6;
    Inner inner = new Inner();
    private int i = 5;

    public static void main(String[] args) {
        Inner inner = new InnerClassLesson().new Inner();
    }

    void method() {
        Inner inner = new Inner();
    }

    class Inner {
        final static int e = 4;
        int q = j;
        int w = i;

        void method() {
            q = j + i;
        }
    }
}

class OtherClass2 {
    InnerClassLesson.Inner inner = new InnerClassLesson().new Inner();
}
