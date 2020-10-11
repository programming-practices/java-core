package Examples.OOP.Others.class_use.game_ylydwenie;

public class Checkers implements Game {

    private static final int MOVES = 3;
    public static GameFactory factory =
            new GameFactory() {
                @Override
                public Game getGame() {
                    return new Checkers();
                }
            };
    private int moves = 0;

    private Checkers() {
    }

    @Override
    public boolean move() {
        System.out.println("Checkers move " + moves);
        return ++moves != MOVES;
    }
}
