package others.pereduvutus.Generics;

import java.util.Collection;
import java.util.List;

public class SomeType<T> {
    public <T> void test(Collection<T> tCollection) {
        for (T t : tCollection) {
            System.out.println(t);
        }
    }

    public void test(List<Integer> integerList) {
        for (Integer integer : integerList) {
            System.out.println(integer);
        }
    }
}
