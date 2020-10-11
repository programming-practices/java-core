package Examples.OOP.Others.interfase_use.interfases_I_fabricas2;

public class ChackersFactory implements GameFactory {
    @Override
    public Game getGame() {
        return new Checkers();
    }
}
