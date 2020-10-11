package generics.Owibki_neodnoznachnosti;

// Ambiguity caused by erasure on
// overloaded methods.
public class MyGenClass<T, V> {
    T ob1;
    V ob2;

    // ...

    // These two overloaded methods are ambiguous
    // and will not compile.
//    void set(T o) {
//        ob1 = o;
//    }

    void set(V o) {
        ob2 = o;
    }
}


