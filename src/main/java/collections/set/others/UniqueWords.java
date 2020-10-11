package collections.set.others;

import java.util.Set;
import java.util.TreeSet;

public class UniqueWords {
    public static void main(String[] args) {
        Set<String> words = new TreeSet<String>(
                new TextFile("src/Books.Filosofia_Java/hlava11_kolekcii_obektof/mnozestvo/SetOperations.java", "\\W+"));
        System.out.println(words);
    }
}
