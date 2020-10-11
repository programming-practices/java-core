package generics.hranichnie_sityacii;

import java.util.ArrayList;
import java.util.List;

public class FilledListMaker<T> {

    public static void main(String[] args) {

        FilledListMaker<String> stringMaker = new FilledListMaker<String>();

        List<String> list = stringMaker.create("Hello", 4);
//        List<String> list2 = stringMaker.create(new String("Hello"), 4);

        System.out.println(list);
//        System.out.println(list2);
    }

    List<T> create(T t, int amount) {

        List<T> result = new ArrayList<T>();

        for (int i = 0; i < amount; i++) result.add(t);

        return result;
    }
}
