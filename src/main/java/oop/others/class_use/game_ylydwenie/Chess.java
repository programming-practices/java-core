package Examples.OOP.Others.class_use.game_ylydwenie;

public class Chess implements Game {

    private static final int MOVES = 4;
    public static GameFactory factory =
            new GameFactory() {
                @Override
                public Game getGame() {
                    return new Chess();
                }
            };
    private int moves = 0;

    private Chess() {
    }

    @Override
    public boolean move() {
        System.out.println("Chess moves" + moves);
        return ++moves != MOVES;
    }
}
