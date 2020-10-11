package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExampleSort {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(9, 1, 2, 45, 3, 4, 10, 5, 6, 50));
//        list.sort((o1, o2) -> o1 < o2 ? o1 : o2);
        list.sort((o1, o2) -> o1.compareTo(o2));  // No eto rewenie pod voprosom !!!!!!!
        System.out.println(list);
    }
}
