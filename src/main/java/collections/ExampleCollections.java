package collections;

import java.util.*;

public class ExampleCollections {
    public static void main(String[] args) {
//--------------------------------------------------------------------------------------------------------------------

//--------------------------------------------------------------------------------------------------------------------
        // Demonstrate various algorithms.
        // Create and initialize linked list.
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(-8);
        linkedList.add(20);
        linkedList.add(-20);
        linkedList.add(8);
        // Create age reverse order comparator.
        Comparator<Integer> reverseOrder = Collections.reverseOrder();
        // Sort list by using the comparator.
        Collections.sort(linkedList, reverseOrder);
        System.out.print("List sorted in reverse: ");
        for (int i : linkedList) System.out.print(i + " ");

        // Create age natural order comparator.
        Comparator<Integer> naturalOrder = Comparator.naturalOrder();
        // Sort list by using the comparator.
        Collections.sort(linkedList, naturalOrder);
        System.out.println();
        System.out.print("List sorted in natural: ");
        for (int i : linkedList) System.out.print(i + " ");

        System.out.println();
        // Shuffle list.
        Collections.shuffle(linkedList);
        // Display randomized list.
        System.out.print("List shuffled: ");
        for (int i : linkedList) System.out.print(i + " ");

        System.out.println();
        System.out.println("Minimum: " + Collections.min(linkedList));
        System.out.println("Maximum: " + Collections.max(linkedList));
//------------------------------------------- Collections.singletonList() ----------------------------------------------
        /*А в результате вызова метода Collections.singleton(anObject) возвращается объект представления, реализующий
        интерфейс Set(в отличие от метода nCopies(), который возвращает коллекцию типа List). Возвращаемый объект
        реализует неизменяемое одноэлементное множество без издержек, характерных для структуры данных. Методы
        singletonList() и singletonMap() ведут себя аналогичным образом.*/
        List<String> list = Collections.singletonList("rrr");
        System.out.println(list);
//-------------------------------------------- Collections.emptySet() --------------------------------------------------
        /*Имеются также методы, производящие пустое множество, список, отображение и т.д. для каждого интерфейса в
          каркасе коллекций. Любопытно, что тип множества выводится автоматически следующим образом:
                           Set<String> deepThoughts = Collections.emptySet();*/
        Set<String> deepThoughts = Collections.emptySet();
        deepThoughts.forEach((v) -> System.out.print(v + ", "));
        System.out.println(deepThoughts.size());
//------------------------------------------- Collections.unmodifiable... ----------------------------------------------
        /*В состав класса Collections входят методы, производящие немодифицируемые представления коллекций. Такие представления
        вводят динамическую проверку в существующие коллекции. Если в ходе такой проверки обнаруживается попытка видоизменить
        коллекцию, генерируется исключение и коллекция остается невредимой. Получить немодифицируемые представления можно
        следующими шестью методами:
                            Collections.unmodifiableCollection
                            Collections.unmodifiableList
                            Collections.unmodifiableSet
                            Collections.unmodifiableSortedSet
                            Collections.unmodifiableMap
                            Collections.unmodifiableSortedMap*/
        List<Integer> integersList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        List<Integer> lookAt = Collections.unmodifiableList(integersList);
        /*Метод Collections, unmodifiableList() возвращает объект класса, реализующего интерфейс List. Его методы доступа
        извлекают значения из коллекции staff.Безусловно, метод lookAt () может вызывать все методы из интерфейса List, а не
        только методы доступа. Но все методы, изменяющие коллекцию, например add(), переопределены таким образом, чтобы
        немедленно генерировать исключение типа UnsupportedOperationException вместо передачи вызова базовой коллекции.*/
        //-----list-lookAt-nerazrewaetsa-minat--------
//        lookAt.add(5);
//        lookAt.clear();
//        lookAt.remove(4);
        /*Немодифицируемое представление не делает саму коллекцию немодифицируемой. Коллекцию можно по-прежнему
        видоизменить по ее исходной ссылке (в данном случае — integeresList). А модифицирующие методы можно вызывать
        для отдельных элементов коллекции.*/
        //----no-integereList-mozno-meniat------------
        integersList.add(566565656);
//--------------------------------------------- Collections.synchronizedMap() -------------------------------------------
        /*Например, статический метод synchronizedMap() из класса Collections может превратить любое отображение в
          объект типа Мар с синхронизированными методами доступа следующим образом:
                    Map<String, EmployeeRAF> map = Collections.synchronizedMap(new HashMap<String, EmployeeRAF>());

          После этого к объекту map можно обращаться из нескольких потоков исполнения. Такие методы, как get() и put(),
          сериализованы. Это означает, что каждый вызов метода должен полностью завершаться до того, как другой поток
          сможет его вызвать. Вопросы синхронизированного доступа к структурам данных подробнее обсуждаются в главе 14.*/
        Map<String, Integer> map = Collections.synchronizedMap(new HashMap<String, Integer>());
//        Map<String, Integer> map = new HashMap<String, Integer>();
        Thread threadA = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                map.put("A" + i, i);
            }
        });
        threadA.start();


        Thread threadB = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                map.put("B" + i, i);
            }
        });
        threadB.start();
        System.out.println(map.size());
//---------------------------------------------- Collections.checkedList() --------------------------------------------
        ArrayList<String> strings = new ArrayList();
        // ради совместимости с унаследованным кодом при компиляции этой строки кода выдается только предупреждение,
        // но не ошибка
        ArrayList rawList = strings;
        // теперь символьные строки содержат объект типа Date!
        rawList.add(new Date());
        /*Проверяемое представление позволяет обнаружить этот недостаток в коде. Для этого сначала определяется
        безопасный список:*/
        List<String> safeStrings = Collections.checkedList(strings, String.class);

        /*Затем в методе представления add() проверяется принадлежность объекта, вводимого в коллекцию , заданному
        классу. И если обнаружится несоответствие, то немедленно сгенерируется исклю чение типа ClassCastException,
        как показано ниже. Преимущество такого подхода заключается в том, что ошибка произойдет в том месте кода,
        где ее можно обнаружить и обработать.*/

//        List rawList2 = safeStrings;
//        rawList2.add (new Date()); // проверяемый список
        // генерирует исключение типа ClassCastException

        /*ВНИМАНИЕ! Проверяемые представления ограничиваются динамическими проверками, которые способна выполнить
        виртуальная машина. Так, если имеется списочный массив типа ArrayList<Pair<String>>, его нельзя защитить от
        ввода элемента типа Pair<Date>, поскольку виртуальной машине ничего неизвестно о единственном базовом классе Pair.*/

//--------------------------------------------- Collections.sort() -----------------------------------------------------
        List<Integer> integerList = new ArrayList<>();
        /*В этом методе предполагается, что элементы списка реализуют интерфейс Comparable.*/
        Collections.sort(integerList);
        /*Если же требуется отсортировать список каким-то другим способом, можно вызвать метод sort() из интерфейса List,
        передав ему объект типа Comparator в качестве параметра. Ниже показано, как отсортировать список элементов.*/
        integerList.sort(Comparator.comparingInt(Integer::intValue));
        /*Если требуется отсортировать список по убывающей, следует воспользоваться служебным статическим методом
        Comparator.reverseOrder(). Он возвращает компаратор, который, в свою очередь, возвращает результат вызова
        b.compareTo(а). Например, в приведенной ниже строке кода элементы списка staff сортируются в обратном порядке,
        который задается методом compareTo() для типа элементов списка,*/
        Collections.sort(integerList, Collections.reverseOrder());

//--------------------------------------------------------------------------------------------------------------------
        /*Имеется ряд операций, предназначенных для группового копирования или удаления элементов из коллекции. Так, в
        результате следующего вызова:
                                coll2.removeAll(со113);
        из коллекции coll2 удаляются все элементы, присутствующие в коллекции col13. А в результате приведенного ниже
        вызова из коллекции coll2 удаляю тся все элементы, отсутствующие в коллекции со113.
                                coll2.retamAll(со113) ;*/
//        List<Integer> coll2 = new ArrayList<>();
//        coll2.add(1);
//        coll2.add(2);
//        coll2.add(3);
//        coll2.add(4);
//        coll2.add(5);
//        coll2.add(6);
//        List<Integer> coll3 = new ArrayList<>();
//        coll3.add(3);
//        coll3.add(4);
//        coll3.add(5);
//
////        coll2.removeAll(coll3);
////        coll2.retainAll(coll3);
////        coll2.addAll(coll3);
//        coll2.addAll(coll3.subList(0,2));
////        coll2.subList(0,3).clear();
//        System.out.println(coll2);
//        System.out.println(coll3);
//--------------------------------------------------------------------------------------------------------------------
//        Map<String,String> map = Collections.emptyMap();
//        System.out.println(map);
//        map.put("A", "B");
//        System.out.println(map);
//--------------------------------------------------------------------------------------------------------------------
    }
}

/*
-----------------------------------------------------------------------------------------------------------------------
ВНИМАНИЕ! Метод unmodifiableCollection() (как, впрочем, и методы synchronized Collection() и checkedCollection(), о которых
речь пойдет далее) возвращает коллекцию, в которой метод equals () не вызывает одноименный метод из базовой коллекции. Вместо этого
он наследует метод equals() из класса Object, который проверяет объекты на равенство. Если просто преобразовать множество
или список в коллекцию, то проверить ее содержимое на равенство не удастся.
Представление действует подобным образом, потому что проверка на равенство четко определена на данном уровне иерархии.
Аналогичным образом в представлениях интерпретируется и метод hashCode(). Но в классах объектов, возвращаемых методами
unmodifiableSet() и unmodifiableList(), используются методы equals() и hashCode() из базовой коллекции.
-----------------------------------------------------------------------------------------------------------------------
НА ЗАМЕТКУ! Класс Collections содержит немало служебных методов с параметрами или возвращаемыми значениями в виде коллекций.
Не путайте его с интерфейсом Collection.
-----------------------------------------------------------------------------------------------------------------------
При попытке сравнить несовместимые типы некоторые из перечисленных
выше методов могут сгенерировать исключение типа C l a s s C a s t Except ion,
а при попытке видоизменить неизменяемые коллекции - исключение типа
Unsuppo rtedOpe r a t ionExcept i on. В зависимости от конкретного метода воз­
можны и другие исключения.
Особое внимание следует уделить ряду nроверяемwс методов вроде метода
chec kedCo l l e c t i on ( ) , возвращающего то, что в документации на прикладной
программный интерфейс API называется "динамически типизируемым представ­
лением" коллекций. Такое представление служит ссылкой на коллекцию, которая
во время выполнения контролирует вводимые в коллекцию объекты на предмет
совместимости типов. Любая попытка ввести в коллекцию несовместимый объект
вызовет исключение типа C l a s s C a s t Exception. Пользоваться этим представле­
нием удобно на стадии отладки, поскольку оно гарантирует наличие в коллекции
достоверных элементов. К числу проверяемых относятся методы che c kedSet ( ) ,
chec kedLi s t ( ) , che c kedMap ( ) и т.д. Они позволяют получить динамически типи­
зированное представление указанной коллекции.
Следует заметить, что некоторые методы наподобие s ynchroni ze dL i s t ( )
и s ynchroni z e dS e t ( ) служат для получения синхронизированных ( nоттсобезопас­
ных) копий различных коллекций. Как упоминалось ранее, стандартные реализа-
ции коллею\иЙ , как нравило, не синхронизированы . Для синхронизации следует
применять си нхрон изирующие ал горитмы . И еще одно замечание: итераторы
синхронизированных коллекций должн ы иснользоваться в пределах блоков кода
с модификатором доступа s yn c h r o n i z ed.
Ряд н,еизменяем ых методов, имена которых начинаются с префикса unrnodi fArgInt iаЫе,
возвращают представления различных коллекций, которые не мо1уг быть измене­
ны. Это может оказаться удобным в том случае, если требуется гарантировать досrуп
к коллекциям только для чтения и без права заниси.
В и нтерфейсе C o l l e c t i on определены три статические переменные: ЕМРТУ
S E T , Е М Р Т У L I S T и Е М Р Т У _МА Р . Все они неизменяемы.
-----------------------------------------------------------------------------------------------------------------------
static <Т> Ьoolean addAll(Collection<? super Т> с, T... elemetu)
                                Всtавляет заданные мементы в указанную кол­
                                лекцию с. Возвращает логическое значение true,
                                если элементы были добавлены, а иначе - логиче­
                                ское значение false

st&tic <Т> Queue<T> asLifoQueue(Deque<T> с)
                                Возвращает представление заданной коJ111екции с
                                в виде стека, действующего по принципу "послед·
                                ним пришел - первым обслужен"

static <Т> int searching.binary_search(List<? extends Т> список , Т значение , Comparator<? super Т> с)
                                Осуществляет поиск указанного значения в за­
                                данном списке, упорядоченном в соответствии
                                заданным компаратором с. Возвращает позицию
                                указанного зшzчения в заданном спш:хе или отрица­
                                тельное значение, если зночение не найдено

static <Т> int searching.binary_search(List<? Extends ComparaЫe<? super Т>> спиrок, Т значение)
                                Осуществляет поиск указанного значения в задан­
                                ном спшже, кагорый должен быть агсортирован.
                                Возвращает позицию указанного значения в задан­
                                ном списке или отрицательное значение, если
                                element не найдено

static <Е> Collection<E> checkedCollection(Collection<E> с, Class<E> t)
                                Возвращает динамически типизируемое представ­
                                ление колл е кции. Попытка ввести несовмести­
                                мый элемент в коллекцию вызовет исключение
                                типa ClassCastException

static <Е> List<E> checkedList(List<E> с, Class<E> t)
                                Возвращает динамически типизируемое представ­
                                ление списка типа List. Попытка ввести несо­
                                вместимый элемент в список вызовет исключение
                                типa ClassCastException

static <К, V> Map<K,V> checkedМap(Map<К , V> с, Class<К> тип_ключа, Class<V> тип_значения)
                                Возвращает динамически типизируемое представ­
                                ление отображения типа мар. Попытка ввести
                                несовместимый элемент в агображение вызовет
                                исключение типа СlаssСаstЕхсерtiоn

static <К , V> NavigableМap<К , V> checltedNavigableМa
                (NavigableМap<К , V> пт, Class<E> тип_ключа , Class<V> тип_значения)
                                Возвращает динамически типизируемое представ­
                                ление отображения типа NaviqaЬleМap. Попытка
                                ввести несовместимый элемент в отображение
                                вызовет исключение типа Clas scastException
                                (добавлен в версииJDК 8)

static <Е> NaviqaЬleSet<E> checkedNaviqaЬleSet(NaviqaЬleSet<E> ns, Class<E> t)
                                Возвращает динамически типизируемое пред став­
                                ление в множество типа NaviqaЬleSet. Попьrrка
                                ввести несовместимый элемент в множество вы­
                                зовет исключение типа ClassCastException (до­
                                бавлен в версииJDК 8)

static <Е> Queue<E> checltedQueue (Queue<E> q, Class<E> t)
                                Возвращает динамически типизируемое представ­
                                ление очереди типа checltedQueue. Попытка вве­
                                сти несовместимый элемент в множество вызовет
                                исключение типа ClassCastException (добавлен
                                в версииJDК 8)

static <Е> List<E> checltedSet(Set<E> с, Class<E> t)
                                Возвращает динамически типизируемое пред­
                                ставление множества типа Set. Попытка ввести
                                несовместимый элемент в множество вызовет ис­
                                ключение типа ClassCastException

static <К , V> SortedМap<К , V>
                checkedSorteclМap(SorteclМap<К, V> с, Class<D тиn_ключа, Class<V> тип_ значения)
                                Возвращает динамически типизируемое представ­
                                ление отображения типа SortedМap. Попытка
                                ввести несовмеL-тимый элемент в агображение
                                вызовет исключение типа ClassCastException

static <Е> SortedSet<E> checltedSortedSet(SortedSet<E> с, Class<E> t)
                                Возвращает динамически типизируемое представ­
                                ление множества типа SortedSet. Попытка вве­
                                сти несовместимый элемент в множество вызовет
                                исключение типа СlаsвсаstЕхсерtiоn

static <Т> void copy (List<? super Т> спisокl , List<? Extendз Т> список2)
                                Копирует элементы из спpisка2 в спisокl

static boolean disjoint (Collection<?> а, Collection<?> h)
                                Сравнивает элементы kolleccii а и Ь.
                                Возвращает логическое значение true, если обе
                                коллекции не содержат общие элементы (т.е. не­
                                п ересекающиеся множества элементов) , а иначе -
                                логическое зна•1ение false

static <Т> Enumeration<T> emptyEnumeration()
                                Возвращает пустое перечисление, т.е. перечисле­ние без элементов

static <Т> I terator<T> emptyiterator()
                                Возвращает пустой итератор, т.е. итератор без элементов

static <Т> Li st<T> emptyList()
                                Возвращает неизменяемый, 11устой список типа, выводимого из интерфейса List

static <Т> Listi terator<T> emptyListiterator()
                                Возвращает пустой итератор списка, т.е. итератор списка без элементов

static <К , V> мар<К , V> еmрtуМар()
                                Возвращает неизменяемое, пустое отображение типа, выводимого из интерфейса мар

static <К , V> NavigableМap<К , V> eшptyNavigableMap()
                                Возвращает неизменяемое, пустое отображение
                                типа, выводимого из интерфейса NavigaЬleМap
                                (добавлен в версииJDК 8)

static <Е> NavigaЬleSet<E> emptyNavigableSet()
                                Возвращает неизменяемое, 11устое множество
                                типа, выводимого из интерфейса NaviqaЬleSet
                                (добавлен в версииJDК 8)

static <Т> Set<T> eшptySet()
                                Возвращает неизменяемое, пустое множество
                                типа, выводимого из интерфейса Set

static <К , V> SortedМap<К , V> emptySortedМap()
                                Возвращает неизменяемое, пустое отображение
                                типа, выводимого из интерфейса Sortec!Мap (до­
                                бавлен в версииJDК 8)

static <Е > SortedSet<E> emptySortedSet()
                                Возвращает неизменяемое, пустое множество
                                типа, выводимого из интерфейса SortedSet (до­
                                бавлен в версииJDК 8)

static <Т> Enumeration<Т> enumeration(Collection<T> с)
                                Возвращает перечисление элементов из за­
                                данной коллекции с. (См. раздел "Интерфейс
                                Enumeration" далее в этой главе)

static <Т> void fill(List<? super Т> cnucoк , Т oбiieюn)
                                Присваивает указанный объект каждому эл ементу
                                заданного списка

static int frequency(Collection<?> с, oЬject oбiieюn)
                                Подсчитывает количество вхождений указанного
                                объеюпа в заданной коллекции с и возвращает ре­зультат

static int indexOfSuЬLis t (List<?>сnисок, Lis t<?> nодсписок)
                                Осуществляет поиск первого вхождения указанно­
                                го подсписка в заданный список . Возвращает индекс
                                первого совпадения или значение -1, если совпа·
                                дение не обнаружено

s tatic int lastindexOfSuЬList(List<?> spisok, List<?> podspisok)
                                Осущесrв.ляет поиск последнего вхождения ука­
                                занного подспшжа в заданный сnисок. Возвращает
                                индекс первого совпадения или значение -1, если
                                совпадение не обнаружено

static <Т> ArrayList<T> list(Enumeration<Т> perechislenie)
                                Возвращает списочный массив типа ArrayList,
                                содержащий элементы заданного перечшления

static <Т> Т шax (Collection<? extends T> с, Coшparator<? super Т> comparator)
                                Возвращает максимальный элемент из ука­
                                занной коллекции с, определяемый заданным

static <Т extends OЬject & Сошраrаblе<? super Т>> Тmах(Collection<? extends Т> с)
                                Возвращает максимальный элемент из указанной
                                коллекции с, определяемый есrесrвенным упорядо­
                                чением. Коллекция доткна бьrгь отсортированной

•static <E> Collection unmodifiableCollection(Collection<E> c)
•static <E> List unmodifiableList (List<E> c)
•static <E> Set unmodifiableSet (Set<E> c)
•static <E> SortedSet unmodifiableSortedSet(SortedSet<E> c)
•static <E> NavigableSet synchronizedNavigableSet (NavigableSet<E> c) 8
•static <K, V > Map unmodif iableMap(Map<K, V > c)
•static <K, V> SortedMap unmodifiableSortedMap(SortedMap<K, V > c)
•static <K, V> NavigableMap<K, V> synchronizedNavigableMap (NavigableMap<K, V> c)8
        Конструируют представления коллекций, в которых модифицирующие методы генерируют исключение
        типа UnsupportedOperationException.

•static <Е> Collection<E> checkedCollection(Collection<E> с)
•static <Е> List checkedList(List<E> c)
•static <E> Set checkedSet (Set<E> c)
•static <E> SortedSet checkedSortedSet(SortedSet<E> c)
•static <E> NavigableSet checkedNavigableSet (NavigableSet<E> c, Class<E> elementType) 8
•static <K, V > Map<K, V > checkedMap (Map<K, V > c)
•static <K, V > SortedMapCK, V > checkedSortedMap (SortedMapCK, V > c)
•static <K, V > NavigableMap checkedNavigableMap (NavigableMapCK, V > c, Class<K> keyType, Class<V> valueType) 8
•static <E> Queue<E> checkedQueue(Queue<E> queue, Class<E> elementType) 8
        Конструируют представления коллекций с методами, генерирующими исключение типа ClassCastException,
        если вводится элемент неверного типа.

•static <Е> List<E> nCopies(int п, Е value)
•static <Е> Set<E> singleton(Е value)
•static <E> List<E> singletonList(E value)
•static <K, V > MapCK, V> singletonMap (K key, V value)
        Конструируют представление объекта в виде немодифицируемого списка из п одинаковых элемен­
        тов или же в виде множества с единственным элементом.

•static <Е> List<E> emptyListO
•static <Т> Set<T> emptySetO
•static <E> SortedSet<E> emptySortedSetO
•static NavigableSet<E> emptyNavigableSet()
•static <K,V> Map<K,V> emptyMapO
•static <K,V> SortedMap<K/V> emptySortedMap()
•static <K,V> NavigableMap<K/V> emptyNavigablёMap()
•static <T> Enumeration<T> emptyEniameration ()
•static <T> Iterator<T> emptylterator()
•static <T> ListIterator<T> enptyListlterator()
        Выдают пустую коллекцию, отображение или итератор.

•static <T extends Coroparable<? super Т » void sort(List<T> elements)
        Сортируют элементы в списке, используя алгоритм устойчивой сортировки. Выполнение алгоритма
        гарантируется за время 0(л log л), где л — длина списка.

•static void shuffle (List<?> elements)
•static void shuffle (List<?> elements, Random r)
        Случайно перетасовывают элементы в списке. Этот алгоритм выполняется за время 0(п а ( п)),
        где п — длина списка, тогда как а(п) — среднее время доступа к элементу списка.

•static <T extends Comparables super Т » int searching.binary_search (List<T>elements, T key)
•static <T> int searching.binary_search(List<T> elements, T key, Comparators super T> c)
        Осуществляют поиск по указанному ключу key в отсортированном списке, используя линейный поиск, если заданный объект
        elements расширяет класс AbstractSequentialList, в противном случае - двоичный поиск. Выполнение алгоритма поиска
        гарантируется за время 0(a(n) log л), где п —длина списка, тогда как а(л) — среднее время доступа к элементу.
        Возвращают индекс указанного ключа key в списке или отрицательное значение i, если ключ не найден в списке.
        В этом случае указанный ключ key должен быть введен на позиции с индексом -i-1, чтобы список остался отсортированным.

•static <T extends Comparable<? super Т >> T min (Collection<T> elements)
•static <T extends Comparable<? super Т >> T max (Collection<T> elements)
•static <T> min(Collection<T> elements, Comparator<? super T> c)
•static <T> max(Collection<T> elements, Comparator^ super T> c)
        Возвращают наименьший или наибольший элемент из коллекции (границы параметров упрощены для ясности).

•static <Т> void copy(List<? super Т> to, List<T> from)
        Копирует все элементы из исходного списка на те же позиции целевого списка. Целевой список должен быть не
        короче исходного.

•static <Т> void fill(List<? super Т> 1, Т value)
        Устанавливает на всех позициях списка одно и тоже значение.

•static <Т> boolean addAll(Collections super T> с, Т... values) 5.0
        Вводит все значения в заданную коллекцию и возвращает логическое значение true, если в результате этого
        коллекция изменилась.

•static <Т> boolean replaceAll (List<T> 1, T oldValue, T newValue) 1.4
        Заменяет на newValue все элементы, равные oldValue.

•static int indexOfSubList(List<?> I, List<?> s) 1.4
•static int lastlndexOfSubList(List<?> 1, List<?> s) 1.4
        Возвращают индекс первого и последнего подсписков I , равных списку s, или значение - 1 , если ни
        один из подсписков 1 не равен списку з . Так, если список 1 содержит элементы [s, t, а, г ] ,
        а список s — элементы [t, а, г ] , то оба метода возвращают индекс, равный 1.

•static void swap(List<?> 1, int i, int j) 1.4
        Меняет местами элементы списка на указанных позициях.

•static void reverse(List<?> 1)
        Меняет порядок следования элементов в списке. Например, в результате обращения списка [t,а,r] порождается список
        [r,a,t]. Этот метод выполняется за время 0(л), где п — длина списка.

•static void rotate (List<?> 1, int d) 1.4
        Циклически сдвигает элементы в списке, перемещая элемент по индексу i на позицию (i+d) % 1 .
        size(). Например, в результате циклического сдвига списка [t,а,r] на 2 позиции порожда­
        ется список [а,r,t]. Этот метод выполняется за время 0(п), где п — длина списка.

•static int frequency(Collections> c, Object o) 5.0
        Возвращает количество элементов в коллекции с, равных заданному объекту о.

•boolean disjoint(Collection<?> cl, Collection<?> c2) 5.0
        Возвращает логическое значение true, если у коллекций отсутствуют общие элементы.

---------------------------
static <Т> Т IDin ( Collection<? extends Т> с, Coшparator<? super Т> компаратор>
Возвращает минимальный элемент из указан-
ной коллекции с, определяемый заданным
КОМ11йрат.оро.м. Коллекция необязательно должна
быть отсортированной
static <Т extends OЬject
&СошраrаЫе<? superТ>>Т
lllin (Collection<? extends Т> с) Возвращает максимальный элемент из указанной
коллекции с, определяемый есrественным упоря­
дочением
static <Т> List<Т> nCopies ( int Возвращает заданное количество копий указанно­
го об6еюпа, содержащихся в неизменяемом списке.
Значение параметра ко.лuчество должно быть
больше или равно нулю
количество, Т
обl;екm)
static <Е> Set<E>
newSetFrol!Мap (Мap<E , Вoolean> т) Создает и возвращает множество, исходя из ука­
занного отображения т, которое должно быть
пустым на момент вызова данного метода
static <Т> Ьoo lean
replaceAll ( List<'l'>
Т старый, Т новый) Заменяет все вхождения заданного элемента
старый на элемент новый в указанном спшже
Возвращает логическое значение true, если про­
изведена хотя бы одна замена, а иначе - логиче­
ское значение fArgInt'alse
спш:ок,
.
static void reverse (List<'l'> Изменяет на обратный порядок следования эле­
ментов в указанном спшже
static <Т> Coшparator<'l'>
reverseOrcler (Coшparator<Т> Возвращает компаратор, обратный переданному
компаратору. Следовательно, возвращаемый ком­
паратор обращает результат сравнения, выпол­
ненного заданным компаратором
спиrок)
КОМ11йраmоjJ)
Возвращает обратный компаратор, который об­
ращает результат сравнения двух элементов кол­
лекции
static <Т>
Coшparator<Т>reverseOrder ( )
static void rotate (List<Т>
int n)
сnисок,
Смещает указанный спш:ок на п позиций вправо.
Для смещения влево следует указать отрицатель­
ное значение параметра n
static void shuffle (List<T> Перетасовы вает ( с луч а й н ы м обра:юм ) элементы
тиаж , ука:Jанного списка , испол ьзуя значение параметра
Random r)
r в
качестве
исходного для по.ll}ч е ния случайных
чисел
s tatic void shuffle (List<Т>
Перетасоны вает (случай ным образом ) элементы
muaж ) указа нного
static <Т> Set<T>
singleton (Т объект) го множества. Это п ростейший способ преобразо­
ашска
В озв р ащает аадан н ы й обr.ект в вилс неизменяемо­
вать одиноч н ы й объект в множество
static <Т> List<T>
singletonLis t (T обl.екm)
static <К , V> Нар<К ,
V>singletonМap (K k , V
В озвра щ а ет :щ1щнный обr.ект в виде неизменяемо­
го списка . Это п ростейший способ преобразовать
ОДИНО'IНЫЙ объект в с писок
В о з в р ащает пару k,
v )
v
"
ключ-зн а ч е н и е
"
в виде неиз­
меняемого от о бр аже н и я . Это п р о ст ей ш и й способ
п реобразовать пару "ключ-значен ие" в отображе­
ние
static <Т> void sort (Li s t<T>
muaж , Comparator<? super Т>
компаратQ/J )
s tatic <Т extends
ComparaЫe<? super Т>> void
sort (List<T> спиаж)
static void swap (List<T>
int инОексl , int индекс2)
ашсок,
Copтиpyt..vr элементы указанного
ст вии с заданны м компарапюром
С о 1 ли рует элементы указанного
стви и
списка в соответ­
ашска в соответ­
ст е с тв е н н ы м упорядочением
с е
Меняет местами элементы указанного спш:ка , обо­
параметрами и11дексl и индекс2
значаемые
static <Т> Collection<Т>
synchroni zedCollection
(Collection<T> с) Возвращас_vr по т ок об е з о п а сную коллекцию, исхо­
дя из указанной кою1екции с
static <Т> List<T>
synchronizedLi.st (List<T> ашсок) Возвращает потокобезопасный с п и с о к, исходя из
указанного ашска
static <К, V> мар<К ,
V>synchronizedМap (Нap<К , V> m) Возвращаеr потокобезопасное отображение, ис·
ходя и з указанного о тоб р аже н и я т
static <К , V> NavigaЫeМap<К , V>
synchronizeclNavigaЫeМap
(NavigaЫeМ&p<К , V> nm) Возвращает синхронизированное навигационное
отображение, исходя из указанного о т о браж е ни я
пт (добавлен в версииJDК 8)
static <Т> NavigaЫeSet<Т>
synchronizedNavigaЬleSet
(NavigaЬleSet<Т> ns) Возвращает синхронизированное навигационное
множество, исходя из указанного множества ns
(добавлен в версииJDК 8)
static <Т> Зеt<Т>
synchroni zedSet ( Set<T> s) Возвращает потокобезопасное множесrво, исходя
из указанного множества s
static <К, V> SortedМap<К , V>
synchronizedSortedИap ( SortedМap
<К , V> sm) Возвращает потокобезопасное отсортированное
отображение, исходя из указанного отображе­
ния sm
static <Т>
SortedSet<Т> synchroni.­
zedSortedSet (SortedSet<Т> sr)
static <Т> Collection<Т>
WUllOdifiaЫe Collection
(Collection<? extends Т> с)
static <Т> List<Т>
WUllOdifiaЬleList (List<? extends
Т> спиrок)
static <К, V> Мар<К,
V>wullodi.fiaЬleМap (Мap<? extends
К, ?extends V> m)
static <К, V> NavigaЬleМap<К, V>
WUllOdif iaЬleNavigaЬleМap
(NavigaЬleМap<К, ? extends V> nm)
static <Т> NavigaЬleSet<Т>
WUllOdifiaЬleNavigaЬleSet
(NavigaЬleSet<Т> m)
static <Т> Set <Т>
unmod.ifiaЬleSet (Set<? extends Т> s)
static <К, V> SorteclМap<К ,
V>WUllOdi fiaЬleSorted-
мap (SortedИap<К , ?extends V> sm)
static <Т> SortedSet<Т>
WIDIOClifiaЬleSortedSet
(SortedSet<Т> ss)
Описание
Возвращает потокобезопасное аrсортщюванное
множесгво, исходя из указанного множесгва sr
Возвращает неизменяемую коллекцию, исходя из
указанной коллекции с
Возвращает неизменяемый список, исходя из ука­
занного ama
Возвращает неизменяемое отображение, исходя
из указанного отображения т
Возвращает неизменяемое навигационное ото­
бражение, исходя из указанного отображения пт
(добавлен в версии JDK 8)
Возвращает неизменяемое навигационное множе­
ство, исходя из указанного множесгва т (добав­
лен в версииJDК 8)
Возвращает неизменяемое множество, исходя из
указанного множества s
Возвращает неизменяемое отсортированное ото­
бражение, исходя из указанного отображения sm
Возвращает неизменяемое отсортированное мно­
жесгво, исходя из указанного множесгва sr
-----------------------------------------------------------------------------------------------------------------------

-----------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------
*/
