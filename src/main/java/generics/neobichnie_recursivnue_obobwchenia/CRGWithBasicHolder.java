package generics.neobichnie_recursivnue_obobwchenia;

class Subtype extends BasicHolder<Subtype> {
}
//class Subtype2 extends ArrayList<Subtype2> {}

public class CRGWithBasicHolder {

    public static void main(String[] args) {

        Subtype st1 = new Subtype(), st2 = new Subtype();
        st1.set(st2);

        Subtype st3 = st1.get();
        st1.f();
    }
}

//class CRGWithBasicHolder2 {
//
//    public static void main(String[] args) {
//
//        Subtype2 st1 = new Subtype2(), st2 = new Subtype2();
//        st1.set(st2);
//
//        Subtype2 st3 = st1.get();
//        st1.fArgInt();
//    }
//}
