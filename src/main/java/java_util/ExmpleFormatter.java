package Examples.java_util;

import java.io.PrintStream;
import java.util.Formatter;

public class ExmpleFormatter {
    private String name;
    private Formatter f;

    public ExmpleFormatter(String name, Formatter f) {
        this.name = name;
        this.f = f;
    }

    public static void main(String[] args) {
        PrintStream outAlias = System.err;
        ExmpleFormatter tommy = new ExmpleFormatter("Tommy", new Formatter(System.err));
        ExmpleFormatter terry = new ExmpleFormatter("Terry", new Formatter(outAlias));
        tommy.move(0, 0);
        terry.move(4, 8);
        tommy.move(3, 4);
        terry.move(2, 5);
        tommy.move(3, 3);
        terry.move(3, 3);
    }

    public void move(int x, int y) {
        f.format("%s The Turtle is at (%d,%d)\n", name, x, y);
    }
}
