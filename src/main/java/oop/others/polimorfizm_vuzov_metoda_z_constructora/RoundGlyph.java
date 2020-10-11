package Examples.OOP.Others.polimorfizm_vuzov_metoda_z_constructora;

public class RoundGlyph extends Glyph {
    private /*static*/ int radius = 1;

    RoundGlyph(int r) {
        radius = r;
        System.out.println("RoundGlyph.RoundGlyph, radius = " + radius);
    }

    @Override
    void draw() {
        System.out.println("RoundGlyph.draw(), radius = " + radius);
    }
}
