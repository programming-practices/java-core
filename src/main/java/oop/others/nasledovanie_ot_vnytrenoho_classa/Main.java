package Examples.OOP.Others.nasledovanie_ot_vnytrenoho_classa;

public class Main {
    public static void main(String[] args) {
        WithInner with = new WithInner();
        InheritInner i = new InheritInner(with);
    }
}
