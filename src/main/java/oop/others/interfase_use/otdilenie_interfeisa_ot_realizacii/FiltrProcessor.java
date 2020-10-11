package oop.others.interfase_use.otdilenie_interfeisa_ot_realizacii;

import oop.others.interfase_use.otdilenie_intrfeisa_ot_realizacii_1.BandPass;
import oop.others.interfase_use.otdilenie_intrfeisa_ot_realizacii_1.HighPass;
import oop.others.interfase_use.otdilenie_intrfeisa_ot_realizacii_1.LowPass;
import oop.others.interfase_use.otdilenie_intrfeisa_ot_realizacii_1.Waveform;

public class FiltrProcessor {
    public static void main(String[] args) {
        Waveform w = new Waveform();
        Apply.process(new FilterAdapter(new LowPass(1.0)), w);
        Apply.process(new FilterAdapter(new HighPass(2.0)), w);
        Apply.process(new FilterAdapter(new BandPass(3.0, 4.0)), w);
    }
}
