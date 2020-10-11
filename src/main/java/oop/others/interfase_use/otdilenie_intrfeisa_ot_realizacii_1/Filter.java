package oop.others.interfase_use.otdilenie_intrfeisa_ot_realizacii_1;

public class Filter {

    public String name() {
        return getClass().getSimpleName();
    }

    public Waveform process(Waveform input) {
        return input;
    }
}
