package generics.sozdanie_ekzempliarov_tipov;

public class Foo2<T> {
    private T x;

    public <F extends FactoryI<T>> Foo2(F factory) {
        x = factory.create();
    }
    // ...
}
