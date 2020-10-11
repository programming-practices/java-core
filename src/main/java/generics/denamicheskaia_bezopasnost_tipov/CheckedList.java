package generics.denamicheskaia_bezopasnost_tipov;

import others.entities.Cappuccino;
import others.entities.Coffee;
import others.entities.Latte;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CheckedList {

    @SuppressWarnings("unchecked")
    static void oldStyleMethod(List probablyDogs) {
        probablyDogs.add(new Cappuccino());
    }

    public static void main(String[] args) {

        List<Latte> lattes = new ArrayList<Latte>();
        oldStyleMethod(lattes); // Quietly accepts a Cat
        List<Latte> lattes1 = Collections.checkedList(new ArrayList<Latte>(), Latte.class);
//        List<Coffee> lattes1 = Collections.checkedList(new ArrayList<Coffee>(), Coffee.class);

        try {
            oldStyleMethod(lattes1); // Throws an exception
        } catch (Exception e) {
            System.out.println(e);
        }

        // Derived types work fine:
        List<Coffee> pets = Collections.checkedList(new ArrayList<Coffee>(), Coffee.class);
        pets.add(new Cappuccino());
        pets.add(new Latte());
    }
}
