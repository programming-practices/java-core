package oop.others.interfase_use.otdilenie_intrfeisa_ot_realizacii_1;

public class HighPass extends Filter {

    double cutoff;

    public HighPass(double cutoff) {
        this.cutoff = cutoff;
    }

    public Waveform process(Waveform input) {
        return input;
    }
}
