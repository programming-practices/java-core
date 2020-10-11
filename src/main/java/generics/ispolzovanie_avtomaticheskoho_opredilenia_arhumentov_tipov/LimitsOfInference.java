package generics.ispolzovanie_avtomaticheskoho_opredilenia_arhumentov_tipov;


import others.entities.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class LimitsOfInference {

    static void f(Map<Person, List<? extends Pet>> petPeople) {
        System.out.println("People: " + petPeople.keySet());
        System.out.println("Pets: " + petPeople.values());
        for (Person person : petPeople.keySet()) {
            System.out.println(person + " has:");
            for (Pet pet : petPeople.get(person))
                System.out.println("    " + pet);
        }
    }

    public static void main(String[] args) {

        Map<Person, List<? extends Pet>> listMap = generics.ispolzovanie_avtomaticheskoho_opredilenia_arhumentov_tipov.New.map();
        listMap.put(new Person("Vova"), Arrays.asList(new Cat("CatName"), new Dog("DogName")));
        listMap.put(new Person("Paraska"), Arrays.asList(new Cymric("CymricName"), new Rat("RatName")));

//         fArgInt(New.map()); // Does not compile
        f(listMap); // Does not compile
    }
}
