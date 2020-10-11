package reflection_api;

public class ExampleReflectionArray {
    public static void main(String[] args) {
//        array.getLength(obj);
    }
}

/*
----------------------------------------------------------------------------------------------------------------------
Класс array из пакета java. lang. reflect позволяет создавать массивы динами­чески.
----------------------------------------------------------------------------------------------------------------------
•static Object get (Object array,int index)
•static xxx getXxx (Object array, int index)
    Возвращают значение элемента указанного массива по заданному индексу. (Символами ххх обо­
    значаются примитивные типы boolean, byte, char, double, float, int, long, short.)

•static void set (Object array, int index, Object newValue)
•static setXxx(Object array, xnt index, xxx nevValue)
    Устанавливают новое значение в элементе указанного массива по заданному индексу. (Символами
    ххх обозначаются примитивные типы boolean, byte, char, double, float, int, long, short.)

•static int getLength (Object array)
    Возвращает длину указанного массива.

•static Object newlnstance (Class componentType, intlength)
•static Object newlnstance (Class componentType, int[] lengths)
    Возвращают новый массив, состоящий из компонентов указанного типа и имеющий заданную раз­мерность.
----------------------------------------------------------------------------------------------------------------------
*/
