package generics.uprowchenie_ispolzovania_kortezei;

import generics.biblioteka_kortezei.*;

public class Tuple {

    public static <A, B> TwoTuple<A, B> tuple(A a, B b) {
        return new TwoTuple<A, B>(a, b);
    }

    public static <A, B, C> ThreeTuple<A, B, C> tuple(A a, B b, C c) {
        return new ThreeTuple<A, B, C>(a, b, c);
    }

    public static <A, B, C, D> FourTuple<A, B, C, D> tuple(A a, B b, C c, D d) {
        return new FourTuple<A, B, C, D>(a, b, c, d);
    }

    public static <A, B, C, D, E> FiveTuple<A, B, C, D, E> tuple(A a, B b, C c, D d, E e) {
        return new FiveTuple<A, B, C, D, E>(a, b, c, d, e);
    }

    public static <A, B, C, D, E, Q> SixTuple<A, B, C, D, E, Q> tuple(A a, B b, C c, D d, E e, Q q) {
        return new SixTuple<A, B, C, D, E, Q>(a, b, c, d, e, q);
    }
}
