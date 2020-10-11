package java_util_Arrays;

import java.util.Arrays;
import java.util.Comparator;

public class Arrays_Sort {
    public static void main(String[] args) {

//======================================================================================================================

        String[] args2 = {"aa", "ab", "lk", "nne", "ae", "bee", "ze", "cae", "aaaaze"};
        System.out.println("Original              ---> " + Arrays.toString(args2));

        Arrays.sort(args2);
        System.out.println("After sorting         ---> " + Arrays.toString(args2));

        Arrays.sort(args2, Comparator.reverseOrder());
        System.out.println("After reverse sorting ---> " + Arrays.toString(args2));

//======================================================================================================================

        String[] args3 = {"aa", "ab", "lk", "nne", "ae", "bee", "ze", "cae", "aaaaze"};
        System.out.println("Array original              ---> " + Arrays.toString(args3));

        String[] args3Copy = Arrays.copyOf(args3, args3.length);
        System.out.println("Array copy                  ---> " + Arrays.toString(args3Copy));
        Arrays.sort(args3Copy);
        System.out.println("Array copy sorted           ---> " + Arrays.toString(args3Copy));

//======================================================================================================================
    }
}

/*
----------------------------------------------------------------------------------------------------------------------
Метод sort() из класса array позволяет упорядочить массив объектов при одном условии:
    1. Oбъекты должны принадлежать классам, реализующим интерфейс Comparable.
----------------------------------------------------------------------------------------------------------------------
НА ЗАМЕТКУ! На первый взгляд может показаться, что метод sort ( ) из класса Arr ay оперирует
только массивами типа Comparable [ ] и что компилятор выдаст предупреждение, как только об­
наружит вызов метода sort() для массива, элементы которого не реализуют данный интерфейс.
Увы, это не так. Вместо этого метод sort О принимает массивы типа Object [ ] и выполняет при­
ведение типов, как показано ниже.
// Такой подход принят в стандартной библиотеке,
// но применять его все же не рекомендуется
if (((Comparable) a[i]).compareTo(a[j]) > 0)
{
// переставить элементы массива a[i] и a[j]
}
Если элемент массива a[i] не принадлежит классу, реализующему интерфейс Comparable, вир­
туальная машина сгенерирует исключение.
----------------------------------------------------------------------------------------------------------------------
•static void sort(Object[] a)
    Сортирует элементы массива а по алгоритму слияния. Все элементы массива должны соответство­
    вать классам, реализующим интерфейс Comparable, и быть совместимыми.
----------------------------------------------------------------------------------------------------------------------
*/