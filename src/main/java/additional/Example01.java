package additional;

import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.List;

public class Example01 {
    public static void main(String[] args) {
//----------------------------------------------------------------------------------------------------------------------

//        List<String> ref = Arrays.asList("s");
//        ref.remove(0);

//----------------------------------------------------------------------------------------------------------------------

//        Runnable runnable = () -> System.out.println("Hello");
//        Comparator<String> c = ((o1, o2) -> o1.hashCode() - o2.hashCode());

//        Predicate<String> p0 =  s -> s.length() > 16;
//        Predicate<String> p1 =  s -> s.length() < 10;
//        System.out.println(p0.or(p1).test("uuuuu"));
//
//        Function<String, Integer> fArgInt = String::length;

// ----------------------------------------------------------------------------------------------------------------------

//        Comparator<? super String> comparator = String::compareTo;
//        Arrays.sort(new String[]{"A"}, comparator);
//
//        Arrays.sort(new String[]{"A"}, String::compareTo);
//
//        List<String> list = new ArrayList<>();
//        list.addAll(Arrays.asList("A", "B", "C", ""));
//        System.out.println(list.filter(String::isEmpty).count());

// ----------------------------------------------------------------------------------------------------------------------

        List<String> list = asList("A", "B", "C");

        List<List<String>> res = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {

            String one = list.get(i);

            for (int j = 0; j < list.size(); j++) {

                String two = list.get(j);
                res.add(asList(one, two));
            }
        }
        System.out.println(res);


//        Iterable<List<String>> x = list.flatMap(one -> list.map(two -> asList(one, two)));
//        System.out.println(x);


//        System.out.println(list.forEach(one -> list.forEach(two -> asList(one, two))));;

// ----------------------------------------------------------------------------------------------------------------------
    }
}
