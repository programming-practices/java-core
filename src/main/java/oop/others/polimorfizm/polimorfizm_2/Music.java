package Examples.OOP.Others.polimorfizm.polimorfizm_2;

public class Music {
    static RandomNote randomNote = new RandomNote();
    static RandomInstrument randomIn = new RandomInstrument();

    public static void tune(Playable p) {
        randomNote.randomNotePlay(p);
    }

    public static void tuneAll(Playable[] playables) {
        for (Playable playable : playables) {
            tune(playable);
        }
    }

    public static void main(String[] args) {
        Playable[] orcestr = new Playable[12];
        for (int i = 0; i < orcestr.length; i++) {
            orcestr[i] = randomIn.randomPlayable();
        }
        tuneAll(orcestr);
    }
}
