package oop.others.interfase_use.otdilenie_interfeisa_ot_realizacii;

import java.util.Arrays;

public class Splitter extends StringProcessor {
    public String process(Object input) {
        return Arrays.toString(((String) input).split(" "));
    }
}
