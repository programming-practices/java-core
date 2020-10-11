package Examples.OOP.Others.interfase_use.interfases_I_fabricas2;

public class Games {
    public static void playGame(GameFactory factory) {
        Game g = factory.getGame();
        while (g.move()) ;
    }
}
