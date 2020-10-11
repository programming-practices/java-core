package generics.contravariantnost;

import others.entities.Apple;
import others.entities.Jonathan;

import java.util.ArrayList;
import java.util.List;

public class SuperTypeWildcards {

    static void writeTo(List<? super Apple> apples) {
        apples.add(new Apple());
        apples.add(new Jonathan());
//        apples.add(new Fruit()); // Error
    }

    static void writeTo2(List<? extends Apple> apples) {
//        apples.add(new Apple());
//        apples.add(new Jonathan());
//        apples.add(new Fruit()); // Error
    }

    <T> void method() {
        List<? extends T> list = new ArrayList<>();
//        List<? super Apple> list2 = new ArrayList<Apple>(Arrays.asList(new Fruit(), new Object(), new Apple(),new Jonathan(), new Orange()));
    }
}
