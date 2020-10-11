package generics.Others;

import java.util.Arrays;
import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeSet;

public class Tests {
    public static void main(String[] args) {

        System.out.println("---------------TreeSet<String> states = new TreeSet<String>();-------------------");
        System.out.println();
        TreeSet<String> states = new TreeSet<String>(Arrays.asList("Германия", "Франция", "Италия", "Великобритания"));

        System.out.println(states);
        System.out.println();


        System.out.println("---------------states.first()---states.last()-------------------");
        System.out.println();
        System.out.println(states);
        System.out.println(states.first()); // получим первый - самый меньший элемент
        System.out.println(states.last()); // получим последний - самый больший элемент
        System.out.println();


        System.out.println("---------------SortedSet<String> sortedSet = states.subSet(\"Германия\", \"Франция\");-------------------");
        System.out.println();
        // получим поднабор от одного элемента до другого
        SortedSet<String> sortedSet = states.subSet("Германия", "Франция");
        System.out.println(states);
        System.out.println(sortedSet);
        System.out.println();


        System.out.println("---------------String greater = states.higher(\"Германия\");-------------------");
        System.out.println();
        // элемент из набора, который больше текущего
        String greater = states.higher("Германия");
        System.out.println(states);
        System.out.println(greater);
        System.out.println();


        System.out.println("---------------String lower = states.lower(\"Германия\");-------------------");
        System.out.println();
        // элемент из набора, который больше текущего
        String lower = states.lower("Германия");
        System.out.println(states);
        System.out.println(lower);
        System.out.println();


        System.out.println("---------------NavigableSet<String> navSet = states.descendingSet();-------------------");
        System.out.println();
        // возвращаем набор в обратном порядке
        NavigableSet<String> navSet = states.descendingSet();
        System.out.println(states);
        System.out.println(navSet);
        System.out.println();


        System.out.println("---------------SortedSet<String> setLower=states.headSet(\"Германия\");-------------------");
        System.out.println();
        // возвращаем набор в котором все элементы меньше текущего
        SortedSet<String> setLower = states.headSet("Германия");
        System.out.println(states);
        System.out.println(setLower);
        System.out.println();


        System.out.println("---------------SortedSet<String> setGreater=states.tailSet(\"Германия\");-------------------");
        System.out.println();
        // возвращаем набор в котором все элементы больше текущего
        SortedSet<String> setGreater = states.tailSet("Германия");
        System.out.println(states);
        System.out.println(setGreater);
        System.out.println();


//        TreeSet<Integer> states2 = new TreeSet<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
//        TreeSet<Integer> states22 = new TreeSet<Integer>();
//
//        states22 = (TreeSet<Integer>) states2.subSet(3,4);
//        System.out.println(states22);

//        TreeSet<Integer> states2 = new TreeSet<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
//        TreeSet<Integer> states22 = new TreeSet<Integer>();
//
//        int higher = states2.higher(0);
//        System.out.println(higher);

//        TreeSet<Integer> states2 = new TreeSet<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
//        TreeSet<Integer> states22 = new TreeSet<Integer>();
//
//        int lower2 = states2.lower(2);
//        System.out.println(lower2);

    }

}
