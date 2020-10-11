package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This program demonstrates the random shuffle and sort algorithms.
 *
 * @author Cay Horstmann
 * @version 1.11 2012-01-26
 */
public class ExampleCollectionsShuffle {
    public static void main(String[] args) {
//---------------------------------------------------------------------------------------------------------------------
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 49; i++)
            numbers.add(i);
        Collections.shuffle(numbers);
        List<Integer> winningCombination = numbers.subList(0, 6);
        Collections.sort(winningCombination);
        System.out.println(winningCombination);
//---------------------------------------------------------------------------------------------------------------------
    }
}

/*
----------------------------------------------------------------------------------------------------------------------
В классе Collections реализован алгоритм перетасовки и соответствующий метод shuffle(), который выполняет задачу,
противоположную сортировке, изменяя случайным образом порядок расположения элементов в списке, как показано в при­
веденном ниже примере кода.
                    ArrayList<Card> cards =...;
                    Collections.shuffle(cards);
Если предоставить список, который не реализует интерфейс RandomAccess, то метод shuffle() скопирует все его элементы в
массив, перетасует этот массив, послечего скопирует перетасованные элементы обратно в список.
----------------------------------------------------------------------------------------------------------------------
*/