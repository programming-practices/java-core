package collections.list;

import java.util.Arrays;
import java.util.List;

/**
 * This class is created for educational purposes.
 * This class may contain sham information.
 * Always check the information you are learning.
 *
 * @author Tsyupryk Roman
 * @email tsyupryk.roman@gmail.com
 * @since 16/07/19
 */
public class ExampleList_toArray {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(10, 4, -1, 5);

        Integer[] array_1 = list.toArray(new Integer[0]);
        System.out.println(Arrays.toString(array_1));          // [10, 4, -1, 5]

        Integer[] array_2 = list.toArray(new Integer[2]);
        System.out.println(Arrays.toString(array_2));          // [10, 4, -1, 5]

        Integer[] array_3 = list.toArray(new Integer[4]);
        System.out.println(Arrays.toString(array_3));          // [10, 4, -1, 5]

        Integer[] array_4 = list.toArray(new Integer[10]);
        System.out.println(Arrays.toString(array_4));          // [10, 4, -1, 5, null, null, null, null, null, null]
    }
}
