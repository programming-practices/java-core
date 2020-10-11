package loops;

import java.util.*;

public class ExampleForEach {
    public static void main(String[] args) {

//======================================================================================================================
//======================================================================================================================
//======================================================================================================================

        // Create an array list for integers.
        ArrayList<Integer> values = new ArrayList<Integer>();

        // Add values to the array list.
        values.add(1);
        values.add(2);
        values.add(3);
        values.add(4);
        values.add(5);

        // Use for loop to display the values.
//        System.out.print("Original contents of vals: ");
//        for(int v : values){
//            System.out.print(v + ", ");
//        }
//        System.out.println();

        // Now, sum the values by using age for loop.
        int sum = 0;
        for (int v : values) {
            sum += v;
        }
//        System.out.println("Sum of values: " + sum);

//======================================================================================================================
//======================================================================================================================
//======================================================================================================================

        List<My2Class> arrayList = new ArrayList();
        arrayList.add(new My2Class("q"));
        arrayList.add(new My2Class("w"));
        arrayList.add(new My2Class("e"));
        arrayList.add(new My2Class("t"));
        arrayList.add(new My2Class("y"));
        arrayList.add(new My2Class("u"));

//        for (My2Class m : arrayList) {
//            System.out.println(m);
//        }

//======================================================================================================================
//======================================================================================================================
//======================================================================================================================

        Collection<String> cs = new LinkedList<>();
        Collections.addAll(cs, "Take the long way home".split(" "));
//        for(String str : cs) {
//            System.out.print("'" + str + "' ");
//        }

//======================================================================================================================
//======================================================================================================================
//======================================================================================================================

        List<Integer> arraylist = new ArrayList<>(Arrays.asList(234, 5, 1, 2, 3, 46, 7, 46, 3));
//        arraylist.forEach(obj -> System.out.print(obj + ", "));

//======================================================================================================================
//======================================================================================================================
//======================================================================================================================
    }
}

class My2Class {
    private String name;

    public My2Class(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "My2Class{" +
                "name='" + name + '\'' +
                '}';
    }
}

/*

There is also a "for-each" loop, which is used exclusively to loop through elements in an array:
            for (type variable : arrayname) {
                // code block to be executed
            }


ForEach -> can only go in froward.

ForEach -> cannot change or modify the elements of a collection.

ON A NOTE! 'ForEach' style loop variable enumerates array elements, not index values.

*/