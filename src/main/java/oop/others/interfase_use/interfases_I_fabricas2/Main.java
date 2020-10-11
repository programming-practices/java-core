package Examples.OOP.Others.interfase_use.interfases_I_fabricas2;

public class Main {
    public static void main(String[] args) {
        Games.playGame(new ChackersFactory());
        Games.playGame(new ChessFactory());
    }
}
