package generics;


import others.entities.Cappuccino;
import others.entities.Coffee;

import java.util.ArrayList;
import java.util.Arrays;

public class ExampleGenericsTest {
    public static void f(ArrayList<Coffee> list) {
    }

    public static void f2(Coffee coffee) {
    }

    public static void main(String[] args) {
        ArrayList<Coffee> coffees = new ArrayList<>();
        ArrayList<Cappuccino> cappuccinos = new ArrayList<>();

//        fArgInt(cappuccinos);                  // ERROR
        f(coffees);

        Coffee coffee = new Coffee();
        Cappuccino cappuccino = new Cappuccino();

        f2(cappuccino);
        f2(coffee);

//        ArrayList<Coffee> c = new ArrayList<Cappuccino>();                   //ERROR

//        Object[] objects = new Integer[3];
//        objects[0] = "ere";                       //  ERROR  compeliryetsa no vo vrema vipolnenia prohrami lomaetsa

        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);

        ArrayList<? extends Object> objects1 = new ArrayList<Integer>(Arrays.asList(1, 2, 3));
        ArrayList<? extends Object> objects2 = new ArrayList<Integer>(integers);
//        objects1.size(1);            // ERROR
//        objects1.set(new Integer(2));               // ERROR
//        objects1.add(new Object(2)));                  // ERROR
        Object o1 = objects1.get(0);
        System.out.println(o1);


        ArrayList<? super Integer> objects11 = new ArrayList<Integer>(Arrays.asList(1, 2, 3));
        ArrayList<? super Integer> objects22 = new ArrayList<Integer>(integers);
//        objects11.size(1);            // ERROR
//        objects22.set(new Integer(2));               // ERROR
//        objects11.add(new Object(2)));                   // ERROR
        objects22.add(4);
        Object o11 = objects1.get(0);
        System.out.println(o1);

    }
}
