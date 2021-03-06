package java_util;

import java.util.IdentityHashMap;

public class ExampleSystemIdentityHashCode {
    public static void main(String[] args) {
        IdentityHashMap identityHashMap = new IdentityHashMap();
    }
}

/*
--------------------------------------------Hde-vukorustovyesa-etot method---------------------------------------------
Класс IdentityHashMap предназначен для построения хеш-отображения идентичности, преследующего особые цели, когда
хеш-значения ключей должны вычисляться не методом hashCode(), а методом System.identityHashCode(). В этом методе для
вычисления хеш-кода, исходя из адреса объекта в памяти, используется метод Object.hashCode(). Кроме того, для сравнения
объектов типа IdentityHashMap применяется операция ==, а не вызов метода equals(). Иными словами, разные объекты-ключи
рассматриваются как отличающиеся, даже если они имеют одинаковое содержимое. Этот класс удобен для реализации алгоритмов
обхода объектов (например, сериализации объектов), когда требуется отслеживать уже пройденные объекты.
A
-----------------------------------------------------------------------------------------------------------------------
•static int identityHashCode(Object o b j) 1.1
    Возвращает хеш-код, вычисляемый методом Object.hashCode() , исходя из адреса памяти, по которому хранится объект,
    даже если в классе, к которому относится заданный объект obj, переопределяется метод hashCode().
-----------------------------------------------------------------------------------------------------------------------
*/
