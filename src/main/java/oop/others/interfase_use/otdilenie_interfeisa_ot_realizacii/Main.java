package oop.others.interfase_use.otdilenie_interfeisa_ot_realizacii;

public class Main {
    public static String s = "If she weihgs the same as a duck, she's made of wood";

    public static void main(String[] args) {
        Apply.process(new Upcase(), s);
        Apply.process(new Downcase(), s);
        Apply.process(new Splitter(), s);
        Apply.process(new ReverseString(), s);
    }
}
