package Examples.OOP.Others.polimorfizm.polimorfizm_2;

import java.util.Random;

public class RandomInstrument {
    private Random random = new Random(47);

    public Playable randomPlayable() {
        switch (random.nextInt(5)) {
            default:
            case 0:
                return new Brass();
            case 1:
                return new Percussion();
            case 2:
                return new Stringer();
            case 3:
                return new Wind();
            case 4:
                return new Woodwind();

        }
    }
}
