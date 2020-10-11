package collections.others.Golovach;

import java.util.ArrayList;
import java.util.Collection;

public class Lesson_1 {


    public static void main(String[] args) {

        Collection<String> collection = new ArrayList<>();

        collection.add("a");
        collection.add("protectedVariable");
        collection.add("c");
        collection.add("d");
        collection.add("e");
        collection.add("fArgInt");
        collection.add("q");
        collection.add("s");
        collection.add("n");
        System.out.println(collection);

        System.out.println(collection.contains("g"));
        System.out.println(collection.isEmpty());
        System.out.println(collection.remove("fArgInt"));
        System.out.println(collection.remove(3));
        System.out.println(collection);


        collection.clear();
    }
}
