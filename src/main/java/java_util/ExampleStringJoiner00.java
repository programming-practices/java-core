package Examples.java_util;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class ExampleStringJoiner00 {
    public static void main(String[] args) {
//-----------------------------------------------------------------------------------------------------------------------------------------------

        StringJoiner joiner = new StringJoiner(",");
        joiner.add("foo");
        joiner.add("bar");
        joiner.add("baz");
        String joined = joiner.toString(); // "foo,bar,baz"
        System.out.println(joined);

        // add() calls can be chained
        joined = new StringJoiner("-").add("foo").add("bar").add("baz").toString(); // "foo-bar-baz"
        System.out.println(joined);

//----------------------------------------------------------------------------------------------------------------------------------------------

        // join(CharSequence delimiter, CharSequence... elements)
        String joined01 = String.join("/", "2014", "10", "28"); // "2014/10/28"
        System.out.println(joined01);

        // join(CharSequence delimiter, Iterable<? extends CharSequence> elements)
        List<String> list = Arrays.asList("foo", "bar", "baz");
        joined01 = String.join(";", list); // "foo;bar;baz"
        System.out.println(joined01);

//----------------------------------------------------------------------------------------------------------------------------------------------

        List<Person> list03 = Arrays.asList(
                new Person("John", "Smith"),
                new Person("Anna", "Martinez"),
                new Person("Paul", "Watson ")
        );

        String joinedFirstNames = list03.stream()
                .map(Person::getFirstName)
                .collect(Collectors.joining(", ")); // "John, Anna, Paul"
        System.out.println(joinedFirstNames);

//----------------------------------------------------------------------------------------------------------------------------------------------

    }
}


class Person {
    private static String firstName;
    private static String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;

        this.lastName = lastName;
    }

    public static String getFirstName(Person person) {
        return firstName;
    }
}