package oop.others.interfase_use.otdilenie_interfeisa_ot_realizacii;

public class ReverseString extends StringProcessor {
    @Override
    public String process(Object input) {
        StringBuffer sq = new StringBuffer((String) input);
        String az = new String(sq.reverse());
        return az;
//        return ((String)input).toUpperCase();

    }
}
