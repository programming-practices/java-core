package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Collections_BinarySearch {
    public static void main(String[] args) {
//---------------------------------------------------------------------------------------------------------------------
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);
        list.add(21);
        list.add(12);
        list.add(27);
        list.add(82);
        list.add(92);
        int element = 27;
        /*Следует, однако, иметь в виду, что коллекция уже должна быть отсортирована, иначе алгоритм даст неверный результат.
        Чтобы найти нужный элемент в коллекции, следует передать ее, при условии, что она реализует интерфейс List, а также
        элемент, который требуется найти. */
//        list.sort(Comparator.naturalOrder());
//        int index = Collections.searching.binary_search(list, element);
//        System.out.println("index = " + index + " and value = " + list.get(index));

        /*Если коллекция не отсортирована методом сошрагеТо() из интерфейса Comparable, то необходимо предоставить также
        объект компаратора, как показано ниже.*/
        Comparator<Integer> comparatorNatural = Comparator.naturalOrder();
        // Zdes bydet error, potomu chto searching.binary_search xochet naturalnoi sortirovki toest ot 0 1 2 3 4... a ne na oborot ...4 3 2 1 0
//        Comparator<Integer> comparatorReversed = Comparator.reverseOrder();
        int index2 = Collections.binarySearch(list, element, comparatorNatural);
        System.out.println("index2 = " + index2 + " and value = " + list.get(index2));
        /*Неотрицательное числовое значение, возвращаемое методом searching.binary_search(), обозначает индекс найденного объекта.
        Следовательно, элемент с.get(i) равнозначен элементу element по порядку сравнения. Если же возвращается отрицательное
        числовое значение, это означает, что элемент не найден. Но возвращаемое значение можно использовать для определения
        места, куда следует ввести элемент element в коллекцию, чтобы сохранить порядок сортировки. Место ввода элемента определя­
        ется следующим образом:
                            insertionPoint = -i - 1;
        Это не просто значение - i , потому что нулевое значение было бы неоднозначным. Иными словами, приведенная ниже
        операция вводит элемент на нужном месте в коллекции.
                            if(i<0) list.add(-i - 1, element);
        Алгоритм двоичного поиска нуждается в произвольном доступе, чтобы быть эффективным. Так, если итерацию приходится
        выполнять поэлементно на половине связного списка, чтобы найти средний элемент, теряются все преимущества двоичного
        поиска. Поэтому данный алгоритм в методе searching.binary_search () превращается в линейный поиск, если этому методу передается
        связный список.*/
//---------------------------------------------------------------------------------------------------------------------
//        List<Integer> list = new ArrayList<>();
//        list.add(5);
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        list.add(4);
//        list.add(6);
//        System.out.println(list);
//        Collections.sort(list);
//        System.out.println(list);
//        int index = Collections.searching.binary_search(list, 5);
//        System.out.println(index);
//        System.out.println(list.get(index));
//---------------------------------------------------------------------------------------------------------------------
    }
}
