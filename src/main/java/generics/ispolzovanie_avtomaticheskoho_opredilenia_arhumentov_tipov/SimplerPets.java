package generics.ispolzovanie_avtomaticheskoho_opredilenia_arhumentov_tipov;

import others.entities.Person;
import others.entities.Pet;

import java.util.List;
import java.util.Map;

public class SimplerPets {
    public static void main(String[] args) {
        Map<Person, List<? extends Pet>> petPeople = New.map();
        // Rest of the code is the same...
    }
}
