package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class ExampleRemoveIf {
    public static void main(String[] args) {
        Collection<Integer> collection_00 = new ArrayList<>(Arrays.asList(1, 1, 2, 3, 3, 4, 5, 6, 7, 8, 8, 9, 10, 10, 3));
        collection_00.removeIf(value -> value > 5);   // esli yslovie vosvrawchaet true to element ydaliaetsa
        System.out.println(collection_00);
    }
}
