package Examples.OOP.Others.nasledovanie_ot_vnytrenoho_classa;
// Nasledovanie ot vnytrenohho classa

class WithInner {

    class Inner {
    }
}

public class InheritInner extends WithInner.Inner {
//    InheritInner(){ }   Ne komperiretsya

    InheritInner(WithInner wi) {
        wi.super();
    }


}
