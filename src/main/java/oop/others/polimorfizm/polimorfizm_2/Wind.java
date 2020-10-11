package Examples.OOP.Others.polimorfizm.polimorfizm_2;

public class Wind implements Instrument, Playable {
    @Override
    public void adjust() {
        System.out.println("Asjusting Wind");
    }

    @Override
    public void play(Note note) {
        System.out.println("Wind play " + note);
    }

    @Override
    public String toString() {
        return "Wind";
    }
}
