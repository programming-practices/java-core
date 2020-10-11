package Examples.OOP.Others.polimorfizm.polimorfizm_2;

public class Stringer implements Instrument, Playable {
    @Override
    public void adjust() {
        System.out.println("Asjusting Stringer");
    }

    @Override
    public void play(Note note) {
        System.out.println("Stringer play " + note);
    }

    @Override
    public String toString() {
        return "Stringer";
    }
}
