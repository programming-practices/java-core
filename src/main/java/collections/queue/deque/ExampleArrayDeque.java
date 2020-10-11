package collections.queue.deque;

import java.util.ArrayDeque;
import java.util.Deque;

public class ExampleArrayDeque {
    public static void main(String[] args) {
//---------------------------------------------------------------------------------------------------------------------

        // Create age tree set.
        ArrayDeque<String> adq = new ArrayDeque<String>();

        // Use an ArrayDeque like age stack.
        adq.push("A");
        adq.push("B");
        adq.push("D");
        adq.push("E");
        adq.push("F");

        System.out.print("Popping the stack: ");

        while (adq.peek() != null)
            System.out.print(adq.pop() + " ");

        System.out.println();

//--------------------------------------------------------------------------------------------------------------------

        // create an empty array deque with an initial capacity
        Deque<Integer> deque = new ArrayDeque<Integer>(8);

        // use add() method to add elements in the deque
        deque.add(10);
        deque.add(20);
        deque.add(30);
        deque.add(40);

        System.out.print("\nElements available in deque: ");
        deque.forEach(number -> System.out.print(number + ", "));

        deque.push(50);
        deque.push(60);
        deque.push(70);

        System.out.print("\nElements available in deque: ");
        deque.forEach(number -> System.out.print(number + ", "));

        //offerFirst-adds elements at the front of the ArrayDeque
        deque.offerFirst(44);

        //offerLast inserts the element at the last of ArrayDeque
        deque.offerLast(99);

        // printing all the elements available in deque
        System.out.print("\nElements available in deque: ");
        deque.forEach(number -> System.out.print(number + ", "));

        System.out.println("\ndeque.pop() = " + deque.pop());

        // printing all the elements available in deque after using pop()
        System.out.print("Elements available in deque: ");
        deque.forEach(number -> System.out.print(number + ", "));


//--------------------------------------------------------------------------------------------------------------------

    }
}

/*
-----------------------------------------------------------------------------------------------------------------------
Класс ArrayDeque расширяет класс AbstractCollection и реализует интерфей с Deque. Он не добавляет свои методы. Класс
ArrayDeque со:щает динамический массив, не имеющий ограничений по емкости . ( Интерфейс Deque поддерживает реализации с
ограниченной емкостью, но не накладывает на се величину никаких ограничений.)
-----------------------------------------------------------------------------------------------------------------------
 ArrayDeque — реализация интерфейса Deque, который расширяет интерфейс Queue методами, позволяющими реализовать
 конструкцию вида LIFO (last-in-first-out). Интерфейс Deque и реализация ArrayDeque были добавлены в Java 1.6.
 Эта коллекция представляет собой реализацию с использованием массивов, подобно ArrayList, но не позволяет
 обращаться к элементам по индексу и хранение null. Как заявлено в документации, коллекция работает быстрее
 чем Stack, если используется как LIFO коллекция, а также быстрее чем LinkedList, если используется как FIFO.
-----------------------------------------------------------------------------------------------------------------------
Как упоминалось выше, обычная (односторонняя) очередь позволяет эффективно вводить элементы в свой хвост и удалять элементы
из своей головы, а двухсторонняя очередь — вводить и удалять элементы на обоих своих концах, хотя ввод элементов в середине
очереди не поддерживается. В версии Java SE 6 появился интерфейс Deque, реализуемый классами A r r ayDeq ue и LinkedList,
причем оба класса предоставляют двухстороннюю очередь, которая может расти по мере надобности. В главе 14 будут приведены
примеры применения ограниченных одно- и двухсторонних очередей.
-----------------------------------------------------------------------------------------------------------------------
•ArrayDequeO
•ArrayDeque(int initialCapacity)
    Конструируют неограниченные двунаправленные очереди с начальной емкостью 1 6 элементов или заданной начальной емкостью.
-----------------------------------------------------------------------------------------------------------------------

*/
