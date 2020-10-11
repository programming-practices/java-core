package collections.others.dobavlenie_hryp_elementov;

// Dpbavlenie hryp elementov v obiektu Collection.

import java.util.*;

public class AddingGroups {
    public static void main(String[] args) {

        Collection<Integer> collection =
                new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
        Integer[] moreInts = {6, 7, 8, 9, 10};
        collection.addAll(Arrays.asList(moreInts));

        // Rabotaet znchitelno bustree no Collection
        // tak ckonstruirovat nevozmozno:

        Collections.addAll(collection, 11, 12, 13, 14, 15);
        Collections.addAll(collection, moreInts);

        // Sozdat spisok na baze masiva:

        List<Integer> list = Arrays.asList(16, 17, 18, 19, 20);
        list.set(1, 99);  // OK -- izmenit element
        //list.add(21);  // Owibka vremini vipolnenia, potomy chto
        // razmer bazovoho masiva izmeniatsa ne mozet.

        for (Integer numbers : collection) {
            System.out.print(numbers + ", ");
        }
        System.out.println();
        for (Integer numbers2 : list) {
            System.out.print(numbers2 + ", ");
        }
    }

}
