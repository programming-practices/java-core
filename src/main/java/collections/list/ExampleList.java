package collections.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface ExampleList {
    public static void main(String[] args) {
//---------------------------------------------------------------------------------------------------------------------
        /*Для многих коллекций можно формировать представления поддиапазонов. Доп устим, имеется список staff, из которого
        требуется извлечь элементы с 10-го по 19.С этой целью следует вызвать метод subList(), чтобы получить представление под­
        диапазона списка:
                            List<EmployeeRAF> group2 = staff.s ubList(10, 20);
        Первый индекс включается в выборку элементов из списка, а второй исключаетсяиз нее. Аналогичным образом действуют
        параметры метода substring() из класса String.*/
//        List<Integer> staff = Arrays.asList(1, 2, 3, 4,90,9,78,34,45, 5, 56, 7, 8); // Unsuported Error
        List<Integer> staff = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 90, 9, 78, 34, 45, 5, 56, 7, 8));
        List<Integer> group2 = staff.subList(3, 6);
        System.out.println(staff);
        System.out.println(group2);
        /*Над полученным в итоге поддиапазоном элементов списка можно выполнить любые операции, а их результаты автоматически
        отразятся на списке в целом. Например, весь поддиапазон элементов списка можно удалить, как показано ниже. В
        итоге выбранные элементы автоматически удаляются из списка staff, а поддиапазон group2 становится пустым.
                    group2.clear(); // сократить штат*/
        group2.clear();
//        group2.set(0, 444444);
        System.out.println(staff);
        System.out.println(group2);
//----------------------------------------------------------------------------------------------------------------------
    }
}

/*
-----------------------------------------------------------------------------------------------------------------------

Этот интерфейс расширяет интерфейс Collection и определяет такое поведе­
ние комекций, которое сохраняет последовательность элементов. Элементы мо­
гут быть введены или извлечены по индексу их позиции в списке, начиная с нуля.
Список может содержать повторяющиеся элементы. Интерфейс L i s t является
обобщенным и объявляется приведенным ниже образом, где Е обозначает тип
объектов, которые должен содержать список.
interface Lis t<E>
Помимо методов, объявленных в интерфейсе Collection, в интерфейсе List
определяется ряд своих методов, перечисленных в табл. 1 8.3. Однако некоторые из
этихметодов генерируютисключениетипа UnsuрроrtеdОреrаtiоnЕхсерtiоn, если
комекция не может быть видоизменена, а исключение типа ClassCastException
генерируется, если объекты неоовместимы, например, при попытке ввести в спи­
сок элемент несовместимого типа. Кроме того, некоторые методы генерируют ис­
ключение типа IndexOutOfBounsException , если указан неверный индекс. А ис­
ключение типа NullPointerException генерируется при попытке ввести в список
пустой объект со значением null , когда пустые элементы в данном списке не допу­
скаются. И наконец, исключение типа IllegalArgumentException генерируется
при указании неверного аргумента.

-----------------------------------------------------------------------------------------------------------------------

 Реализации этого интерфейса представляют собой упорядоченные коллекции. Кроме того, разработчику предоставляется
 возможность доступа к элементам коллекции по индексу и по значению (так как реализации позволяют хранить дубликаты,
 результатом поиска по значению будет первое найденное вхождение).

-----------------------------------------------------------------------------------------------------------------------

void add(int индекс, Е obiekt)  Вводит заданный оlЛ;ект на позиции вызывающего
                                списка по указанному индексу. Любые введенные
                                ранее элементы смещаются, начиная с указанной
                                позиции и далее к началу списка. Это означает, что
                                элементы в списке не перезаписываются

boolean addAll(int index, Collection<? extends E> coll)
                                Вводит все элементы из коллекции с в вызывающий
                                список, начиная с позиции по указанному индексу.
                                Введенные ранее элементы смещаются, начиная
                                с указанной позиции и далее к началу списка. Это
                                означает, что элементы в списке не перезаписывают­
                                ся. Возвращает логическое значение true, если вы­
                                зывающий список изменяется, а иначе - логическое
                                значение false

E get(int index)                Возвращает объект, хранящийся в вызывающем спи­
                                ске на позиции по указанному индексу

int indexOf(OЬject obiekt)      Возвращает индекс первого экземпляра заданного
                                обiекта в вызывающем списке. Если заданный обr.ект
                                отсугсгвует в списке, возвращается значение - 1

int lastindexOf(OЬject obiekt)  Возвращает индекс последнего экземпляра заданного
                                обiекта в вызывающем списке. Если заданный обiект
                                отсугсгвует в списке, возвращается значение - 1

ListIterator<E> listIterator()  Возвращает итератор для обхода элементов с начала
                                вызывающего списка

ListIterator<E> listIterator(int индекс)
                                Возвращает итератор для обхода элементов вызы­
                                вающего списка, начиная с позиции по указанному инdексу

Е remove(int index)
                                Удаляет элемент из вызывающего списка на позиции
                                по указанному инiJексу и возвращает удаленный эле­
                                мент. Результирующий список уплотняется, т.е. эле­
                                менты, следующие за удаленным, смещаются на одну позицию назад

default void replaceAll(UnaryOperator<E> opToApply)
                                Обновляет каждый элемент списка значением, по­
                                лучаемым из функции, определяемой параметром
                                opToApply (добавлен в версииJDК 8)

Е set ( int индекс, Е o&elan)   Присваивает заданный о&еюп элементу, находя­
                                щемуся в списке на позиции по указанному инdексу.
                                Возвращает прежнее значение

default void sort(Comparator<? super Е> comparator)
                                Сортирует список, используя заданный компаратор
                                (добавлен в версииJDК 8)

List<E> suBList(int nachlo, int konec)
                                Возвращает список, включающий элементы от пози­
                                ции nachalo до позиции конец-1 из вызывающего спи­
                                ска. Ссылки на элементы из возвращаемого списка
                                сохраняются и в вызывающем списке

•
ListIterator<E> listlterator()
Возвращает итератор списка, который можно использовать для перебора элементов списка.
•
ListIterator<E> listlterator(int i n d e x )
Возвращает итератор списка для обращения к элементам списка, если в результате вызова метода
next ( ) возвращается элемент этого списка с заданным индексом.
•
voidadd(int i, E element)
Вводит элемент на указанной позиции в списке.
•
void addAll(int i, Collections extends E> e le m e n ts)
Вводит все элементы из коллекции на указанной позиции в списке.
•
Е remove (int 1)
Удаляет и возвращает элемент на указанной позиции в списке.
•
Е get (int i)
Получает элемент на указанной позиции в списке.
•
Еset(int i, Е element)
Заменяет элемент на указанной позиции в списке новым элементом и возвращает прежний элемент.
•
int indexOf(Object elem ent)
Возвращает позицию первого вхождения искомого элемента в списке или значение - 1 , если ис­
комый элемент не найден.
•
int lastlndexOf(Object ele m e n t)
Возвращает позицию последнего вхождения искомого элемента в списке или значение - 1 , если
искомый элемент не найден.
•
List<E> subList(int firstIncluded, int firstExcluded)
Возвращает представление списка элементов в заданном диапазоне позиций.
•
default void sort (Comparators super T> comparator) 8
Сортирует данный список, используя указанный компаратор.
•
default void replaceAll(UnaryOperator<E> op) 8
Выполняет указанную операцию над всеми элементами данного списка.
-----------------------------------------------------------------------------------------------------------------------
*/

