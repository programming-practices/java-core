package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class ExampleClearCollection {
    public static void main(String[] args) {
        Collection<Integer> collection_00 = new ArrayList<>(Arrays.asList(1, 1, 2, 3, 3, 4, 5, 6, 7, 8, 8, 9, 10, 10, 3));
        collection_00.clear();
        System.out.println(collection_00);
    }
}
