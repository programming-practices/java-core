package generics.Owibki_neodnoznachnosti;

// Ambiguity caused by erasure on
// overloaded methods.
public class MyGenClass2<T, V extends Number> {
    T ob1;
    V ob2;

    // ...


    public MyGenClass2(T ob1, V ob2) {
        this.ob1 = ob1;
        this.ob2 = ob2;
    }

    // These two overloaded methods are ambiguous
    // and will not compile.
    void set(T o) {
        ob1 = o;
    }

    void set(V o) {
        ob2 = o;
    }
}


class Test {
    public static void main(String[] args) {
        MyGenClass2<Number, Number> mg = new MyGenClass2<>(new Integer(3), new Integer(4));

//        mg.set(new Integer(4));    // ERROR

    }
}