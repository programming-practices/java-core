package collections;

import java.util.ArrayList;
import java.util.Arrays;

public class Example_EnsureCapacity_TrimpToSize {
    public static void main(String[] args) {
        ArrayList<Integer> arraylist = new ArrayList<>(Arrays.asList(234, 5, 1, 2, 3, 46, 7, 46, 3));
        arraylist.forEach(obj -> System.out.print(obj + ", "));

        arraylist.ensureCapacity(20);
        System.out.println("\n" + arraylist.size());  // mehod size vivodit kolichestvo elemento a ne obiom Lista

        arraylist.trimToSize();
        System.out.println(arraylist.size());  // mehod size vivodit kolichestvo elemento a ne obiom Lista
    }
}
