package collections;

import java.util.ArrayList;
import java.util.ListIterator;

public class ExampleListIterator {
    public static void main(String[] args) {
//--------------------------------------------------------------------------------------------------------------------

        // Create an array list.
        ArrayList<String> arrayList = new ArrayList<String>();

        // Add elements to the array list.
        arrayList.add("C");
        arrayList.add("A");
        arrayList.add("E");
        arrayList.add("B");
        arrayList.add("D");
        arrayList.add("F");

        System.out.print("Original contents of getArrayListPets: ");
        ListIterator<String> listIterator = arrayList.listIterator();
        while (listIterator.hasNext()) {
            String element = listIterator.next();
            System.out.print(element);
        }

        System.out.println();
        // Modify objects being iterated.
        listIterator = arrayList.listIterator();
        while (listIterator.hasNext()) {
            String element = listIterator.next();
            listIterator.set(element + "+");
        }

        System.out.print("Original contents of getArrayListPets: ");
        listIterator = arrayList.listIterator();
        while (listIterator.hasNext()) {
            String element = listIterator.next();
            System.out.print(element);
        }

        System.out.println();
        // Now, display the list backwards.
        System.out.print("Modified list backwards: ");
        while (listIterator.hasPrevious()) {
            String element = listIterator.previous();
            System.out.print(element);
        }
        System.out.println();

//--------------------------------------------------------------------------------------------------------------------

    }
}

/*
-----------------------------------------------------------------------------------------------------------------------
List  mozno izmenit s pomowchiy ListIterator
-----------------------------------------------------------------------------------------------------------------------

Безусловно, интерфейс ListIterator доступен только тем видам коллекций, которые реализуют интерфейс List.

-----------------------------------------------------------------------------------------------------------------------
Нередко требуется перебрать все элементы коллею щ и , юшример, выве­
сти к аж д ы й ее элемент. Для этого можно, на п ри мер , воспользоваться иrперато­
ром - объектом класса, р еализующего один из двух и н т е р ф ей с ов : I t e r a t o r или
L i s t i t e r a t o r . В частности , интерфейс I t e r a t o r 1юзволяет организовать цикл
для перебора коллекции , извлекая или удаляя iz нее элементы. А интерфейс
L i s t l t e r a t o r расширяет интерфейс I t e r a t o r для двустороннего обхода списка
и видоизменения его элементов. Интерфейсы I t e r a t o r и L i s t i t e r a t o r являют·
ся обобщенными и объявляются следующим образом:
interface Iterator<E>
interface Lis titerator<E>
где Е обозначает тип перебираемых объектов. В интерфейсе I t e r a t o r объявля·
ются методы, перечисленные в табл. 1 8. 1 0. А методы, объявляемые в интерфейсе
L i s t l t e r a t o r . перечислены в табл. 1 8. 1 1 . В обоих случаях операции, видоизменя­
ющие базовую коллекцию, необязательн ы . Например, метод r emove ( ) сгенериру·
ет исключение типа Un s uppo r t e dOpe r a t i on E x c e p t i o n , если вызвать его для кол­
лекции , досrупной только для чтения. Возможны и другие исключения.

----------------------------------------------------------------------------------------------------------------------

void add(Е obj)                 Вводит заданный obj перед элементом, который дол­
                                жен быть возвращен в результате последующего вызова
                                метода next()

default void forEachRemaining(Consumer <? super Е> действие)
                                Выполняет заданное действие над каждым необработан·
                                ным элементом коллекции (добавлен в версии JDK 8)

boolean hasNext()               Возвращает логическое значение true, если в списке
                                имеется следующий элемент, а иначе - логическое зна­
                                чение fаlsе

Ьoo lean hasPrevious()          Возвращает логическое значение true, если в списке
                                имеется предыдущий элемент, а иначе - логическое зна­
                                чение fаlsе

.....

----------------------------------------------------------------------------------------------------------------------

*/
