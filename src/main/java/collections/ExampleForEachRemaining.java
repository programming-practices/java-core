package collections;

import java.util.ArrayList;
import java.util.Iterator;

public class ExampleForEachRemaining {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("C");
        arrayList.add("A");
        arrayList.add("E");
        arrayList.add("B");
        arrayList.add("D");
        arrayList.add("F");

        Iterator<String> iterator = arrayList.iterator();
        iterator.forEachRemaining(System.out::print);

        System.out.println(arrayList);
    }
}
