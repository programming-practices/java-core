package generics.iavnoe_ykazanie_tipov;


import generics.ispolzovanie_avtomaticheskoho_opredilenia_arhumentov_tipov.New;
import others.entities.Person;
import others.entities.Pet;

import java.util.List;
import java.util.Map;

public class ExplicitTypeSpecification {

    static void f(Map<Person, List<? extends Pet>> petPeople) {
    }

    public static void main(String[] args) {

        f(New.<Person, List<? extends Pet>>map());
    }
}
