package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExampleArrayCovariant {
    public static void main(String[] args) {
        Fruit[] fruit = new Apple[10];
        fruit[0] = new Apple(); // OK
        fruit[1] = new Jonathan(); // OK
//        fruit[2] = new Fruit();
//        fruit[3] = new Orange();
        // Runtime type is Apple[], not Fruit[] or Orange[]:
        try {
            // Compiler allows you to add Fruit:
            fruit[0] = new Fruit(); // ArrayStoreException
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            // Compiler allows you to add Oranges:<T>
            fruit[0] = new Orange(); // ArrayStoreException
        } catch (Exception e) {
            System.out.println(e);
        }

//        List<Fruit> list = new ArrayList<Apple>();       // ERROR
        List<? extends Fruit> list1 = new ArrayList<Apple>(Arrays.asList(new Apple(), new Jonathan()));
        List<Fruit> list2 = new ArrayList<Fruit>(Arrays.asList(new Orange(), new Apple(), new Jonathan(), new Fruit()));

//       list1.add(new Apple());
//       list1.add(new Jonathan());
//        list1.add(new Apple());   // ERROR
//        Apple s = list1.get(0);    // ERROR
        Apple s2 = (Apple) list1.get(0);
        Fruit f = list1.get(0);
    }
}

class Fruit {
}

class Apple extends Fruit {
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}

class Jonathan extends Apple {
}

class Orange extends Fruit {
}