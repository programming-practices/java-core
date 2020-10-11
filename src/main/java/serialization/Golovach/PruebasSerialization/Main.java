package serialization.Golovach.PruebasSerialization;


import serialization.Golovach.SerializacionDemo;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class Main {
    private static <T> void print(Person[] persons) {
        for (Person p : persons) {
//            System.out.println("First name: " + p.getFirstName());
//            System.out.println("Last name: " + p.getLastName());
//            System.out.println("Age: " + p.getAge());
//            System.out.println("Sexo: " + p.isSexo());
//            System.out.println("hashCode: " + p.hashCode());
            System.out.println(p);
        }

    }

    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Person[] persons0 = new Person[]{new User("Casablanca", "Anna", (byte) 23, false, 1),
                new User("Parra", "Antonio", (byte) 43, true, 2)};
        Person[] persons1 = SerializacionDemo.deepCopy(persons0);
//        System.out.println(persons0 != persons1);
        print(persons0);
        System.out.println(persons0.hashCode());
        System.out.println();
        print(persons1);
        System.out.println(persons1.hashCode());
        System.out.println("----------------------------------------------------------------------------------------------------------------");


    }
}
