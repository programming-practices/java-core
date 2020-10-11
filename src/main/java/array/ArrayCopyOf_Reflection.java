package array;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * This program demonstrates the use of reflection for manipulating arrays.
 *
 * @author Cay Horstmann
 * @version 1.2 2012-05-04
 */
public class ArrayCopyOf_Reflection {
    public static void main(String[] args) {
        /*Следует, однако, иметь в виду, что метод goodCopyOf() можно применять для на­ ращивания массива любого типа,
        а не только массива объектов, как показано ниже.*/
        int[] a = {1, 2, 3};
        a = (int[]) goodCopyOf(a, 10);
        System.out.println(Arrays.toString(a));

        String[] b = {"Tom", "Dick", "Harry"};
        b = (String[]) goodCopyOf(b, 10);
        System.out.println(Arrays.toString(b));

        System.out.println("The following call will generate an exception.");
        b = (String[]) badCopyOf(b, 10);
    }
//---------------------------------------------------------------------------------------------------------------------
    /*Но в этом коде возникает затруднение, связанное с фактическим использованием получаемого в итоге массива. Этот
    массив содержит объекты и относится к типу Object[], поскольку он создан с помощью следующего выражения:
    new Object[newLength] Массив объектов типа Object[] не может быть преобразован в мас­сив типа EmployeeRAF[]. При
    попытке сделать это возникнет исключение типа ClassCastException. Как пояснялось ранее, в ходе выполнения программы
    испол­няющая система Java запоминает первоначальный тип элементов массива, т.е . тип, указанный в операции new.
    Массив типа EmployeeRAF[] можно временно преобра­зовать в массив типа Object[] и обратно, но массив, изначально
    созданный как относящийся к типу Object[], преобразовать в массив типа EmployeeRAF[] нельзя.*/

    /**
     * This method attempts to grow an array by allocating a new array and copying all elements.
     *
     * @param a         the array to grow
     * @param newLength the new length
     * @return a larger array that contains all elements of a. However, the returned array has
     * type Object[], not the same type as a
     * <p>
     * <p>
     * NOT USEFUL
     */
    public static Object[] badCopyOf(Object[] a, int newLength) {
        Object[] newArray = new Object[newLength];
        System.arraycopy(a, 0, newArray, 0, Math.min(a.length, newLength));
        return newArray;
    }
//---------------------------------------------------------------------------------------------------------------------
    /*А для того чтобы опре­делить тип элементов нового массива, необходимо выполнить следующие действия.
        1. О пределить, какому именно классу принадлежит объект а.
        2. Убедиться в том, что он действительно является массивом.
        3. Воспользоваться методом getComponentType() из класса Class (определен лишь для объектов типа Class,
           представляющих массивы), чтобы получить требуемый тип массива.

       Следует, однако, иметь в виду, что метод goodCopyOf() можно применять для на­ращивания массива любого типа, а
       не только массива объектов, как показано ниже.
                    int[] а = {1,2,3,4,5};
                    а = (int[]) goodCopyOf(а, 10);
       Для этого параметр метода goodCopyOf() объявляется как относящийся к типу Object, а не как массив объектов
       (т.е. типа Object[]). Массив типа int[] можно пре­образовать в объект типа Object, но не в массив объектов!*/

    /**
     * This method grows an array by allocating a new array of the same type and
     * copying all elements.
     *
     * @param a the array to grow. This can be an object array or a primitive
     *          type array
     * @return a larger array that contains all elements of a.
     */
    public static Object goodCopyOf(Object a, int newLength) {
        Class cl = a.getClass();
        if (!cl.isArray()) return null;
        Class componentType = cl.getComponentType();
        int length = Array.getLength(a);
        Object newArray = Array.newInstance(componentType, newLength);
        System.arraycopy(a, 0, newArray, 0, Math.min(length, newLength));
        return newArray;
    }
}
