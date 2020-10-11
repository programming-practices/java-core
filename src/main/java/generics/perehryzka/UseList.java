package generics.perehryzka;

import java.util.List;

public class UseList<W, T, V> {

    //    void fArgInt(List<V> v) {}   // ERROR
//    void fArgInt(List<T> v) {}   // ERROR
    void f(List<W> v) {
    }

}
