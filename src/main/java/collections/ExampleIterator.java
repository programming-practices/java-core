package collections;

import static others.PrintUtils.lineSeparator;

import java.util.*;

// Source: https://www.youtube.com/watch?v=RrveUXePAwU&index=2&list=PLoij6udfBnchPaTkPuMaSJeNpfSkiwX2r
//         start-> 3:00 end-> ...

public class ExampleIterator {
    public static void main(String[] args) {
//--------------------------------------------------------------------------------------------------------------------

        Collection<Integer> collection_A = new ArrayList<>(Arrays.asList(1, 1, 2, 3, 3, 4, 5, 6, 7, 8, 8, 9, 10, 10, 3));
        Iterator<Integer> iterator_A = collection_A.iterator();
//
//        while (iterator_A.hasNext()){
//            System.out.print(iterator_A.next() + ", ");
//        }
//--------------------------------------------------------------------------------------------------------------------

//        // Create an array list.
        List<String> listChars = new ArrayList<>();
//
//        // Add elements to the array list.
        listChars.add("C");
        listChars.add("A");
        listChars.add("E");
        listChars.add("B");
        listChars.add("D");
        listChars.add("F");

        lineSeparator(1);
//        // Use iterator to display contents of al.
        System.out.print("Original contents of listChars: ");
        Iterator<String> iterator_B = listChars.iterator();
        while (iterator_B.hasNext()) {
            System.out.print(iterator_B.next());
        }

        lineSeparator(2);
        System.out.print("Modified contents of listChars: ");
        iterator_B = listChars.iterator();
        while (iterator_B.hasNext()) {

            //Iterator ne mozet izminat collection
            // Tak ne meniaetsa kolekcia
            System.out.print(iterator_B.next());

            // Vot tak toze neizmenitsa kolekcia
            System.out.print(iterator_B.next());

        }

        lineSeparator(3);
        System.out.print("Contents of listChars: ");
        iterator_B = listChars.iterator();
        while (iterator_B.hasNext()) {
            System.out.print(iterator_B.next());
        }
//--------------------------------------------------------------------------------------------------------------------
        /*Но важнее то, что между вызовами методов next () и remove () существует определенная связь. В частности, вызывать
        метод remove () не разрешается, если перед ним не был вызван метод next (). Если же попытаться сделать это, будет
        сгенерировано исклю чение типа IllegalStateException. А если из коллекции требуется удалить два соседних элемента,
        то нельзя просто вызвать метод remove () двараза подряд, как показано ниже.
                        it.remove();
                        it.remove(); // ОШИБКА!
        Вместо этого нужно сначала вызвать метод next (), чтобы пройти удаляемый элемент, а затем удалить его, как следует
        из приведенного ниже примера кода.
                        it.remove();
                        it.next();
                        it.remove(); // Допустимо!*/
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("C");
        arrayList.add("A");
        arrayList.add("E");
        arrayList.add("B");
        arrayList.add("D");
        arrayList.add("F");
//        Iterator<String> it = arrayList.iterator();
//        while (it.hasNext()){
        //---------ERROR-----------------
//            it.remove();
//            it.remove(); // ОШИБКА!
        //---------ERROR-----------------
//            it.remove();
//            it.next();
//            it.remove(); // ERROR
        //---NOT-ERROR----REMOVE-TWO-VALUES---------
//            it.next();
//            it.remove();
//            it.next();
//            it.remove();
        //--------------------------
//            arrayList.forEach(System.out::print);
//        }
//--------------------------------------------------------------------------------------------------------------------
    }
}


/*
----------------------------------------------------------------------------------------------------------------------
 Iterator ne mozet izmeniat kollekciy. No eto nado ewcho tochno viasnit
----------------------------------------------------------------------------------------------------------------------
НА ЗАМЕТКУ! Напротив, итератор коллекции из пакета java.util генерирует исключение типа
ConcurrentModificationException, если в коллекцию внесены изменения после создания
этого итератора.
----------------------------------------------------------------------------------------------------------------------
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
default void forEachRemaining(Consumer<? super Е> действие)
                                    Выполняет заданное действие над каждым необработан·
                                    ным элементом коллекции (добавлен в версии JDК 8)

boolean hasNext()                   Возвращает логическое значение true, если в кол·
                                    лекции еще имеются элементы, а иначе - логическое
                                    значение false

Е next()                            Возвращает следующий элемент из кол-
                                    лекции. Генери рует исключение типа
                                    NoSuchElementException, если в коллекции больше
                                    нет элементов

void remove()                       Удаляет текущи й элемент из коллекции. Генерирует
                                    исключение типа IlleqalStateException, если
                                    предп ринимается попытка вызвать метод reшove() ,
                                    которому не предшествовал вызов метода next()
                                    В варианте этого метода по умолчанию генерируется
                                    исключение типа UnsupportedOpera>tionException


boolean hasNextO
Возвращает логическое значение true, если в коллекции еще имеются элементы, к которым мож­
но обратиться.
•
Е next()
Возвращает следующий перебираемый объект. Генерирует исключение типа NoSuchElement
Exception, если достигнут конец коллекции.
•
void remove ()
Удаляет последний перебираемый объект. Этот метод должен вызываться сразу же после обраще­
ния к удаляемому элементу. Если коллекция была видоизменена после обращения к последнему ее
элементу, этот метод генерирует исключение типа HlegalStateException.
----------------------------------------------------------------------------------------------------------------------
*/
