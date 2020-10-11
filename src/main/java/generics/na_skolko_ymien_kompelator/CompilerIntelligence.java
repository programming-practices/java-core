package generics.na_skolko_ymien_kompelator;

import others.entities.Apple;
import others.entities.Fruit;
import others.entities.Jonathan;
import others.entities.Orange;

import java.util.Arrays;
import java.util.List;

public class CompilerIntelligence {

    public static void main(String[] args) {

        List<? extends Fruit> fruitList = Arrays.asList(new Apple(), new Jonathan(), new Orange());

        Apple a = (Apple) fruitList.get(0); // No warning
        Apple a1 = (Apple) fruitList.get(1); // No warning
//        Apple a2 = (Apple)flist.get(2); // No warning      //   ERROR is it ORANGE,Orange is not Apple

        fruitList.contains(new Apple()); // Argument is 'Object'
        fruitList.indexOf(new Apple()); // Argument is 'Object'
        System.out.println(fruitList.contains(new Apple()));
        System.out.println(fruitList.indexOf(new Apple()));
    }
}
