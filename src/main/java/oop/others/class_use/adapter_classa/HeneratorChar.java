package Examples.OOP.Others.class_use.adapter_classa;


public class HeneratorChar {
    private static int cout = 0;
    private int cantidad;
    private char[] chars = {'q', 'w', 'e', 'r', 't', 'y', 'u'};

    public HeneratorChar() {
    }

    public HeneratorChar(int cantidad) {
        this.cantidad = cantidad;
    }

    public char nextChar() {
        char c = 0;
        while (true) {
            for (int i = cout; i < chars.length; i++) {
                c = chars[i];
                cout++;
                return c;
            }
        }
    }

}
