package generics.biblioteka_kortezei;

public class SixTuple<A, B, C, D, E, Q> extends FiveTuple<A, B, C, D, E> {
    public final Q six;

    public SixTuple(A a, B b, C c, D d, E e, Q q) {
        super(a, b, c, d, e);
        six = q;
    }

    public String toString() {
        return "(" + first + ", " + second + ", " +
                third + ", " + fourth + ", " + fifth + ", " + six + ")";
    }

}
