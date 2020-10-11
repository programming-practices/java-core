package Examples.OOP.Others.kovariantnost_vozcrawchaimux_danux;

public class CovariantReturn {
    public static void main(String[] args) {
        Mill m = new Mill();
        Grain g = m.proces();
        System.out.println(g);
        m = new WheatMill();
        g = m.proces();
        System.out.println(g);
    }
}
