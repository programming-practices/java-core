package Examples.OOP;

public class ExampleLocalInnerClasses {

    static int i = 5;
    int j = 6;

    public static void main(String[] args) {
    }

    void does(int e) {
        int r = 5;
        class Local {
            private final static int q = 4;
            public int w = j;
            int t = e;
            int y = r;

            void method() {

            }
        }
        Local local = new Local();
    }

    void does2() {
        class Local {

        }
    }
}
