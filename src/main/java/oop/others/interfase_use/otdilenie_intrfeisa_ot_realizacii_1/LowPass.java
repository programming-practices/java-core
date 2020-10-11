package oop.others.interfase_use.otdilenie_intrfeisa_ot_realizacii_1;

public class LowPass extends Filter {

    double cutoff;

    public LowPass(double cutoff) {
        this.cutoff = cutoff;
    }

    public Waveform process(Waveform input) {
        return input;
    }
}
