package Examples.OOP.Others.polimorfizm_vuzov_metoda_z_constructora;

public class Glyph {
    Glyph() {
        System.out.println("Glyph perd vizovom draw()");
        draw();
        System.out.println("Glyph posle vizova draw()");
    }

    void draw() {
        System.out.println("Glyph.draw()");
    }

}
