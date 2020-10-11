package oop.others.interfase_use.otdilenie_interfeisa_ot_realizacii;

public abstract class StringProcessor implements Processor {

    public String name() {
        return getClass().getSimpleName();
    }

    public abstract String process(Object input);


}
