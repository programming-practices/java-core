package oop.others.interfase_use;

public class Adaptirovanie_11 {
    static String string = "abcde";

    public static void main(String[] args) {
        oop.others.interfase_use.otdilenie_interfeisa_ot_realizacii.Apply.process(new oop.others.interfase_use.otdilenie_interfeisa_ot_realizacii.ReverseString(), string);
    }

    public String fg(String s) {
        this.string = s;
        return s;
    }
}