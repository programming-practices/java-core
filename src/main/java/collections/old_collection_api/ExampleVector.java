package collections.old_collection_api;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

public class ExampleVector {
    public static void main(String[] args) {
//---------------------------------------------------------------------------------------------------------------------
        // Demonstrate various Vector operations.
        // initial size is 3, increment is 2
        Vector<Integer> vector = new Vector<Integer>(3, 2);

        System.out.println("Initial size: " + vector.size());
        System.out.println("Initial capacity: " +
                vector.capacity());

        vector.addElement(1);
        vector.addElement(2);
        vector.addElement(3);
        vector.addElement(4);

        System.out.println("Capacity after four additions: " + vector.capacity());
        vector.addElement(5);
        System.out.println("1Current capacity: " + vector.capacity());
        vector.addElement(6);
        vector.addElement(7);

        System.out.println("2Current capacity: " + vector.capacity());
        vector.addElement(9);
        vector.addElement(10);

        System.out.println("3Current capacity: " + vector.capacity());
        vector.addElement(11);
        vector.addElement(12);


        System.out.println("First element: " + vector.firstElement());
        System.out.println("Last element: " + vector.lastElement());

        if (vector.contains(3)) System.out.println("vector.contains(3) = true");

        // Enumerate the elements in the vector.
        Enumeration<Integer> vectorEnum = vector.elements();

        System.out.print("\nElements in vector for Enumeration: ");
        while (vectorEnum.hasMoreElements()) System.out.print(vectorEnum.nextElement() + " ");
        System.out.println();

        System.out.print("\nElements in vector for Iterator: ");
        Iterator iterator = vector.iterator();
        while (iterator.hasNext()) System.out.print(iterator.next() + " ");
        System.out.println();

        System.out.print("\nElements in vector for forech: ");
        for (Integer value : vector) {
            System.out.print(value + " ");
        }
        System.out.println();

        System.out.print("\nElements in vector for stream.forech: ");
        vector.stream().forEach(value -> System.out.print(value + " "));
//---------------------------------------------------------------------------------------------------------------------
    }
}

/*
------------------------------------------------------------------------------------------------------------------------------------------
 Vector — реализация динамического массива объектов. Позволяет хранить любые данные, включая null в качестве элемента.
 Vector появился в JDK версии Java 1.0, но как и Hashtable, эту коллекцию не рекомендуется использовать, если
 не требуется достижения потокобезопасности. Потому как в Vector, в отличии от других реализаций List, все
 операции с данными являются синхронизированными. В качестве альтернативы часто применяется аналог — ArrayList.
------------------------------------------------------------------------------------------------------------------------------------------
Этот класс реализует динамический массив. Он подобен классу A r r a yL i s t , но
и меет два отличия: синхронизирован и содержит немало устаревших методов,
дублирующих функции методов, определенных в каркасе коллекций Collectioнs
Framewoгk. С появлением коллекций класс Ve c t o r бьш переделан как расширение
КJra<·ca Ab s t r a c t L i s t и дополнен реализацией интерфейса L i s t . В версии JDК 5
он бьш переделан под синтаксис обобщений и дополнен реализацией интерфейса
I t e r a Ы e . Это означает, что класс Ve c t o r стал полностью совместимым с коллек­
циями, допуская перебор своего содержимого в усовершенствованном цикле fo r .
------------------------------------------------------------------------------------------------------------------------------------------
•Enumeration<E> elements()
        Возвращает объект перечисления, обходящий вектор по всем элементам.
------------------------------------------------------------------------------------------------------------------------------------------
*/
