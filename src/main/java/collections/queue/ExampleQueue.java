package collections.queue;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public interface ExampleQueue {
    public static void main(String[] args) {
//--------------------------------------------------------------------------------------------------------------------
        Queue<Integer> qLL = new LinkedList<>();
        qLL.add(5);
        qLL.add(4);
        qLL.add(3);
        qLL.add(2);
        qLL.add(1);

        System.out.print("LinkedList = ");
        while (!qLL.isEmpty()) {
            System.out.print(qLL.poll() + ", ");
        }
//---------------------------------------------------------------------------------------------------------------------
        Queue<Integer> qPQ = new PriorityQueue<>();
        qPQ.add(5);
        qPQ.add(4);
        qPQ.add(3);
        qPQ.add(2);
        qPQ.add(1);

        System.out.print("\nPriorityQueue = ");
        while (!qPQ.isEmpty()) {
            System.out.print(qPQ.poll() + ", ");
        }
//---------------------------------------------------------------------------------------------------------------------
        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }
        };

        Queue<Integer> qPQComparator = new PriorityQueue<>(Comparator.comparingInt((x) -> {
            return 4;
        }));
        qPQ.add(5);
        qPQ.add(2);
        qPQ.add(1);
        qPQ.add(4);

        System.out.print("\nPriorityQueue = ");
        while (!qPQ.isEmpty()) {
            System.out.print(qPQ.poll() + ", ");
        }
//---------------------------------------------------------------------------------------------------------------------

    }
}

/*
-----------------------------------------------------------------------------------------------------------------------
Этот интерфейс расширяет интерфейс Collection и определяет поведе н ие
очереди , которая действует как с писок по принципу "первым вошел - первы м об·
служен". 1см не менее имеются разные виды очередей, порядок организации в ко·
торых основывается на некотором критерии. Интерфейс Queue является обоб­
щенным и объявляется следующим образом:
interface Queue<E>
где Е обозначает тип объектов, которые будут храниться в очереди
-----------------------------------------------------------------------------------------------------------------------
 Этот интерфейс описывает коллекции с предопределённым способом вставки и извлечения элементов,
 а именно — очереди FIFO (first-in-first-out). Помимо методов, определённых в интерфейсе Collection,
 определяет дополнительные методы для извлечения и добавления элементов в очередь.
 Большинство реализаций данного интерфейса находится в пакете java.util.concurrent
-----------------------------------------------------------------------------------------------------------------------
 Расширяет интерфейс Collection для управления специальными типамисписков, где элементы удаляются
 только из начала списка
-----------------------------------------------------------------------------------------------------------------------
Несмотря на всю свою простоту, интерфейс Queue представляет интерес с не­
скольких точек зрения. Во-первых, элементы могут удаляться только из начала
очереди. Во-вторых, имеются два метода, p o l l ( ) и r ernove ( ) . с помощью кото­
рых можно получать и удалять элементы из очереди. Отличаются они тем, что
метод po l l ( ) возвращает пустое значение nul l , если очередь пуста, тогда как
метод rernove ( ) генерирует исключение. И в-третьих, имеются еще два метода,
e lement ( ) и pee k ( ) , которые получают элемент из головы очереди , но не удаля­
ют его. Отличаются они тем, что при пустой очереди метод e l ernen t ( ) генериру­
ет исключение, тогда как метод pee k ( ) возвращает пустое значение nu l l . И на­
конец, следует иметь в виду. что метод o fArgInt fArgInt e r ( ) только пытается ввести элемент
в очередь. А поскольку некоторые очереди имеют фиксированную длину и могут
быть заполнены. то вызов метода o fArgInt fe r ( ) может завершиться неудачно.
-----------------------------------------------------------------------------------------------------------------------

Е element()                     Возвращает элемент из головы очереди . Возвращаемый
                                элемент не удаляется. Если очередь пуста, генерируется ис·
                                ключение типа NoSuchEleшentException

boolean offer(Е обыкm)          Пытается ввести заданный обЪект в очередь. Возвращает
                                логическое значение true, если обl.ект введен, а иначе ло­
                                гич е ск о е значение fArgInt'alse

Е peek()                        Возвращает элемент из головы очереди. Если очередь пуста,
                                возвращает пустое значение null . Возвращаемый элемент
                                не удаляется из очереди

Е poll()                        Возвращает элемент из головы очереди и удаляет его. Если
                                очередь пуста, возвращает пустое значение null.

Е remove()                      Удаляет элемент из головы очереди, возвращая его.
                                Генерирует исключение типа NoSuchElementException,
                                если очередь пуста

•boolean add(E element)
•boolean offer (E element)
    Вводят заданный элемент в конце очереди и возвращают логическое значение true, если очередь не заполнена. Если же
    очередь заполнена, первый метод генерирует исключение типа IllegalStateException, тогда как второй возвращает
    логическое значение false.

•Е remove()
•Е ро11()
    Удаляют и возвращают элемент из головы очереди, если очередь не пуста. Если же очередь пуста, то первый метод генерирует
    исключение типа NoSuchElementException, тогда как второй возвращает пустое значение null.

•Е element()
•Е реек()
    Возвращают элемент из головы очереди, не удаляя его, если очередь не пуста. Если ж е очередь пуста, то первый метод
    генерирует исключение типа NoSuchElementException, тогда как второй возвращает пустое значение null.
-----------------------------------------------------------------------------------------------------------------------
*/