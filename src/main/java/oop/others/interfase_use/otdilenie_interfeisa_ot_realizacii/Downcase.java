package oop.others.interfase_use.otdilenie_interfeisa_ot_realizacii;

public class Downcase extends StringProcessor {
    public String process(Object input) {
        return ((String) input).toLowerCase();
    }
}
