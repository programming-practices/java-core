package Examples.OOP.Others.polimorfizm.polimorfizm_2;

public class Brass extends Wind {
    @Override
    public void play(Note note) {
        System.out.println("Brass play " + note);
    }

    @Override
    public String toString() {
        return "Brass";
    }
}
