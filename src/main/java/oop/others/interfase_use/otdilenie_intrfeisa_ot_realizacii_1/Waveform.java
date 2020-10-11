package oop.others.interfase_use.otdilenie_intrfeisa_ot_realizacii_1;

public class Waveform {

    private static long counter;
    private final long id = counter++;

    public String toString() {
        return "Waveform" + id;
    }
}
