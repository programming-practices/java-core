package Examples.OOP.Others.polimorfizm.polimorfizm_2;

import java.util.Random;

public class RandomNote {
    private Random random = new Random(47);

    public void randomNotePlay(Playable p) {
        switch (random.nextInt(2)) {
            default:
            case 0:
                p.play(Note.MIDDLE_C);
                break;
            case 1:
                p.play(Note.B_FLAT);
                break;
            case 2:
                p.play(Note.C_SHARP);
                break;
        }
    }
}
