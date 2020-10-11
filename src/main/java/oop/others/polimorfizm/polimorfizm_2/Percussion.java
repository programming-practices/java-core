package Examples.OOP.Others.polimorfizm.polimorfizm_2;

public class Percussion implements Instrument, Playable {
    @Override
    public void adjust() {
        System.out.println("Asjusting Percussion");
    }

    @Override
    public void play(Note note) {
        System.out.println("Percussion play " + note);
    }

    @Override
    public String toString() {
        return "Percussion";
    }
}
