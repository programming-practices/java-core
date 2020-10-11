package oop.others.interfase_use.otdilenie_intrfeisa_ot_realizacii_1;

public class BandPass extends Filter {

    double lowCutoff, higCutoff;

    public BandPass(double lowCutoff, double higCutoff) {
        this.lowCutoff = lowCutoff;
        this.higCutoff = higCutoff;
    }

    public Waveform process(Waveform input) {
        return input;
    }
}
