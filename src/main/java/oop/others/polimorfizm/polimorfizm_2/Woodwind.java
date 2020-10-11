package Examples.OOP.Others.polimorfizm.polimorfizm_2;

public class Woodwind extends Wind {
    @Override
    public void play(Note note) {
        System.out.println("WoodWind play " + note);
    }

    @Override
    public String toString() {
        return "WoodWind";
    }
}
