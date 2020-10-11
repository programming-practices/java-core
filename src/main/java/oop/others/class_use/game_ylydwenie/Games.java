package Examples.OOP.Others.class_use.game_ylydwenie;

public class Games {
    public static void playGame(GameFactory factory) {
        Game s = factory.getGame();
        while (s.move()) ;
    }

    public static void main(String[] args) {
        playGame(Checkers.factory);
        playGame(Chess.factory);
    }
}
