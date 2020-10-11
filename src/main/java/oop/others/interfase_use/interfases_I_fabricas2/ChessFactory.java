package Examples.OOP.Others.interfase_use.interfases_I_fabricas2;

class ChessFactory implements GameFactory {
    @Override
    public Game getGame() {
        return new Chess();
    }
}
