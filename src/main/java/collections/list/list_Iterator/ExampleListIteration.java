package collections.list.list_Iterator;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class ExampleListIteration {
    public static void main(String[] args) {
//--------------------------------------------------------------------------------------------------------------------
//        List<String> list = new LinkedList<>();
//        list.add("1");
//        list.add("2");
//        list.add("3");
//        list.add("4");
//        list.add("5");
//        list.add("6");
//        list.add("7");
//        list.add("8");
//        list.add("9");
//        list.add("10");
//
//        ListIterator<String> listIterator = list.listIterator();
//
//        while(listIterator.hasNext())
//            System.out.print(listIterator.next() + ", " + listIterator.nextIndex() +
//                    ", " + listIterator.previousIndex() + "; ");
//
//        System.out.println();
//
//        // Backwards:
//        while(listIterator.hasPrevious()){
//            System.out.print(listIterator.previous() + " ");
//        }
//
//        System.out.println();
//        System.out.println(list);
//
//        listIterator = list.listIterator(3);
//        while(listIterator.hasNext()) {
//            listIterator.next();
//            listIterator.set("setValue");
//        }
//        System.out.println(list);
//---------------------------------------------------------------------------------------------------------------------
        /*HA ЗАМЕТКУ! Впрочем, аналогия с курсором | не совсем точна. Операция удаления элемента из списка выполняется не
        совсем так, как при нажатии клавиши <Backspace>. Если метод remove() вызывается сразу же после метода next( ), то
        он действительно удаляет элемент, расположенный слева от итератора, как это и происходит при нажатии клавиши <Backspace>.
            Но если он вызывается сразу же после метода previous(), то удаляется элемент, расположенный справа от итератора.
        К тому же метод remove() нельзя вызывать два раза подряд.
            В отличие от метода add(), действие которого зависит только от позиции итератора, действие метода remove()
        зависит и отсостояния итератора.*/
//        List<String> linkedList1A = new LinkedList<>();
//        linkedList1A.add("1");
//        linkedList1A.add("2");
//        linkedList1A.add("3");
//        linkedList1A.add("4");
//        linkedList1A.add("5");
//        ListIterator<String> iteratorA = linkedList1A.listIterator();
//        while (iteratorA.hasNext()){
//            String next = iteratorA.next();
//            System.out.println(next);
////            if (next.equals("4")){ iteratorA.remove(); }
//        }
//        System.out.println(linkedList1A);

//        List<String> linkedList1AA = new LinkedList<>();
//        linkedList1AA.add("1");
//        linkedList1AA.add("2");
//        linkedList1AA.add("3");
//        linkedList1AA.add("4");
//        linkedList1AA.add("5");
//        ListIterator<String> iteratorAA = linkedList1AA.listIterator();
//        while (iteratorAA.hasNext()){
//            System.out.println(iteratorAA.next());
//        }
//        while (iteratorAA.hasPrevious()){
//            String next = iteratorAA.previous();
//            System.out.println(next);
////            if (next.equals("4")){ iteratorAA.remove(); }
//        }
//        System.out.println(linkedList1AA);
//---------------------------------------------------------------------------------------------------------------------
//        List<String> staff = new LinkedList();
//        staff.add("Amy");
//        staff.add("Bob");
//        staff.add("Carl");
//        System.out.println(staff);
//         Takim sposobom mozno vstavit nyznui element v nyznoe mesto
//        ListIterator<String> iter = staff.listIterator();
//        iter.next(); // пройти первый элемент списка
//        iter.add("Juliet");
//        iter.add("Juliet2");
//        System.out.println(staff);
//---------------------------------------------------------------------------------------------------------------------
        List<String> list = new LinkedList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        ListIterator<String> iterl = list.listIterator();
        ListIterator<String> iter2 = list.listIterator();
//        iterl.next();
//        iterl.remove();
//        iter2.next() ; // генерирует исключение ConcurrentModificationException
        /*При вызове метода iter2.next() генерируется исключение типа ConcurrentModificationException, поскольку
        итератор iter2 обнаруживает, что список был внешне видоизменен. */
        //--------------------------------------------------
        /*НА ЗАМЕТКУ! Но из приведенного выше правила обнаружения одновременных видоизменений имеется одно любопытное
        исключение. Связный список отслеживает лишь структурные модификации вроде ввода и удаления связок. А действие
        метода set() не считается структурной модификацией. К связному списку можно присоединить несколько итераторов,
        способных вызывать метод set() для изменения содержимого списка. Наличие такой возможности требуется во многих
        алгоритмах, применяемых в классе Collections, о котором речь пойдет далее в этой главе.*/
        iterl.next();
        iterl.set("rr");
        iter2.next(); // NE генерирует исключение ConcurrentModificationException
        //---sovmesno hasNext() i next() dvigayt cursorom
//        iterl.hasNext();
//        iterl.next();
        //-----------------------
        iterl.set("rr2");
        System.out.println(list);
//---------------------------------------------------------------------------------------------------------------------

    }
}

/*
-----------------------------------------------------------------------------------------------------------------------
И, наконец, если имеется целочисленный индекс п, в результате вызова метода list.listlterator (п) будет возвращен итератор,
установленный до элемента с индексом п. Это означает, при вызове метода next () получается тот же самый элемент, что и при
вызове метода list.get(n). Следовательно, получение такого итератора малоэффективно.
-----------------------------------------------------------------------------------------------------------------------
•
void add(E newElement)
Вводит новый элемент до текущей позиции в списке.
•
void set(E newElement)
Заменяет новым элементом последний элемент, обращение к которому было сделано при вызове ме­
тода next () или previous ( ) . Генерирует исключение типа HlegalStateException, если струк­
тура списка была видоизменена в результате последнего вызова метода next ( ) или previous ( ) .
•
boolean hasPrevious ()
Возвращает логическое значение true, если имеется еще один элемент для обращения при ите­
рации по списку в обратном направлении.
•
Е previous ()
Возвращает предыдущий объект. Генерирует исключение типа NoSuchElementException, если
достигнуто начало списка.
•
int nextlndex()
Возвращает индекс элемента, который должен быть возвращен при последующем вызове метода
next ().
•
int previous Index ()
Возвращает индекс элемента, который должен быть возвращен при последующем вызове метода
previous().
-----------------------------------------------------------------------------------------------------------------------
*/