package generics;

import others.entities.Apple;
import others.entities.Fruit;
import others.entities.Jonathan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExampleGenericsAndCovariance {
    public static void main(String[] args) {
        // Wildcards allow covariance:
        List<? extends Fruit> flist = new ArrayList<Apple>();
        List<? extends Fruit> flist2 = new ArrayList<Apple>(Arrays.asList(new Apple(), new Jonathan()));
        // Compile Error: can't add any type of object:
        // flist.add(new Apple());
//         flist.add(new Fruit());
//         flist.add(new Object());
//        flist.add(new Jonathan());
        flist.add(null); // Legal but uninteresting
        // We know that it returns at least Fruit:
        Fruit f = flist.get(0);
    }
}

