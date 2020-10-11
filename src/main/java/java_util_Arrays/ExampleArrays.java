package java_util_Arrays;


import java.util.ArrayList;
import java.util.Arrays;

public class ExampleArrays {
    public static void main(String[] args) {
//--------------------------------------------------------------------------------------------------------------------
        // Allocate and initialize array.
        int array[] = new int[10];
        for (int i = 0; i < 10; i++) array[i] = -3 * i;

        // Display, sort, and display the array.
        System.out.print("Original contents: ");
        display(array);
        Arrays.sort(array);
        System.out.print("Sorted: ");
        display(array);

        // Fill and display the array.
        Arrays.fill(array, 2, 6, -1);
        System.out.print("After fill(): ");
        display(array);

        // Sort and display the array.
        Arrays.sort(array);
        System.out.print("After sorting again: ");
        display(array);

        // Binary search for -9.
        System.out.print("The value -9 is at location ");
        int index = Arrays.binarySearch(array, -9);
//        int index = Arrays.searching.binary_search(array, -33);

        System.out.println(index);

        System.out.println();
        ArrayList<String> arrayList = new ArrayList();
        arrayList.add("q");
        arrayList.add("w");
        arrayList.add("e");
        arrayList.add("t");
        arrayList.add("y");
        arrayList.add("u");
        System.out.println(Arrays.toString(arrayList.toArray()));
//--------------------------------------------------------------------------------------------------------------------
        /*Напомним, что этот метод служит для наращивания уже заполнен­
        ного массива. Ниже показано, каким образом такое наращивание реализуется в коде.*/
        String[] a = new String[100];
        // массив заполнен
        a = Arrays.copyOf(a, 2 * a.length);
//--------------------------------------------------------------------------------------------------------------------

//--------------------------------------------------------------------------------------------------------------------
    }

    static void display(int array[]) {
        for (int i : array)
            System.out.print(i + " ");

        System.out.println();
    }
}

/*
-----------------------------------------------------------------------------------------------------------------------
А для создания потока данных из части массива служит метод
                Arrays.stream(array, from, to).
-----------------------------------------------------------------------------------------------------------------------
•
static <E> List<E> asList (E... array)
Возвращает представление списка элементов массива, который является модифицируемым, но
с неизменяемым размером.

• static <T> StreanKT> stream (T[] array, int startlnclusive, int endExclusive) 8
Возвращает поток данных, элементы которого сформированы из заданного диапазона в
указанном массиве.
-----------------------------------------------------------------------------------------------------------------------
*/
