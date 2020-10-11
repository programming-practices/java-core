package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class ExampleRetailAll {
    public static void main(String[] args) {
        Collection<Integer> collection_00 = new ArrayList<>(Arrays.asList(1, 1, 2, 3, 3, 4, 5, 6, 7, 8, 8, 9, 10, 10, 3));
        Collection<Integer> collection_01 = new ArrayList<>(Arrays.asList(6, 7, 8, 9, 10));
        boolean b = collection_00.retainAll(collection_01);
        System.out.println(b);
        System.out.println(collection_00);
    }
}

/*
boolean retainAll(Collection<?> сoll)
                        Удаляет из вызывающей коллекции вес элементы,
                        кроме элементов заданной коллекции сoll. Возвращает
                        логическое значение true, если в конечном итоге
                        коллекция изменяется (т.е. элементы из нее удале­ны), а
                        иначе - логическое значение false

*/
