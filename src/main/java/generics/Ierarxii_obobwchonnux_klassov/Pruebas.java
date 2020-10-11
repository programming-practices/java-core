package generics.Ierarxii_obobwchonnux_klassov;

public class Pruebas {
    public static void main(String[] args) {

    }
}

class A<T extends Comparable> {
    T t;

    public A(T t) {
        this.t = t;
    }
}

class B extends A {
    Integer e;

    public B(Comparable comparable, Integer ing) {
        super(comparable);
        this.e = ing;
    }

    public B(Comparable comparable) {
        super(comparable);
    }
}

class C extends B {

    public C(Comparable comparable) {
        super(comparable);
    }
}


