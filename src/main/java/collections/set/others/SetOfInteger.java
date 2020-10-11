package collections.set.others;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class SetOfInteger {
    public static void main(String[] args) {

        Random rand = new Random(46);

        Set<Integer> intset = new HashSet<>();

        for (int i = 0; i < 10000; i++) {
            int ae = rand.nextInt(30);
//            System.out.println(ae);
            intset.add(ae);
        }

        System.out.println(intset);

//        for (int i = 0; i < 14; i++) {
//            System.out.print(rand.nextInt(30) + " ");
//        }
    }
}
