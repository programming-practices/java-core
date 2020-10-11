package java_util_Arrays;

import others.entities.entitiesCollection.*;

import java.util.*;

public class Arrays_AsList {
    public static void main(String[] args) {
// ---------------------------------------------------------------------------------------------------------------------
        // Arrays.asList() vozvrawchaet spisok kotorui ne vozmozn yvilichit ili
        // ymenwit no mozno izmeniat znachenia peremennux xraniawchixcia v masive
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
//        list.add(3);  // eroro
        list.set(2, 55); // nety erora

        List<Integer> listA = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        listA.add(3); // nety errora

// ------------------------------------------- ModifyingArraysAsList ---------------------------------------------------
        Random rand = new Random(47);
        Integer[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        List<Integer> list1 = new ArrayList<>(Arrays.asList(array));
        System.out.println("Before shuffling: " + list1);

        Collections.shuffle(list1, rand);

        System.out.println("After shuffling: " + list1);
        System.out.println("array: " + Arrays.toString(array));

        List<Integer> list2 = Arrays.asList(array);
        System.out.println("Before shuffling: " + list2);

        Collections.shuffle(list2, rand);

        System.out.println("After shuffling: " + list2);
        System.out.println("array: " + Arrays.toString(array));

// ------------------------------------------ AsListInference ----------------------------------------------------------
        //Arrays.asList() putaetsa yhadat tip
        List<Show> show1 = Arrays.asList(new Crusty(), new Slush(), new Powder());

        // Ne kompeliryetsy
        List<Show> show2 = Arrays.asList(new Light(), new Heavy());
        // Kompilator soobwchaet:
        // polycheno : java.util.List<Powder>
        // trebuetsya : java.util.List<Show>
        // y Collections.addAll() problem nety:
        List<Show> show3 = new ArrayList<Show>();
        Collections.addAll(show3, new Light(), new Heavy());

        // Podskazka s iavno ykazanim arhymentom tipa:
        List<Show> show4 = Arrays.<Show>asList(new Light(), new Heavy());
// ---------------------------------------------------------------------------------------------------------------------

    }
}
