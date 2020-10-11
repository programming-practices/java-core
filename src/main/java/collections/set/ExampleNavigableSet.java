package collections.set;

public interface ExampleNavigableSet {
    public static void main(String[] args) {

    }
}


/*
-----------------------------------------------------------------------------------------------------------------------
Расширяет интерфейс SortedSet для извлечения элементов по результатам поиска ближайшего совпадения
-----------------------------------------------------------------------------------------------------------------------
Этот интерфейс расширяет интерфейс SortedSet и определяет поведение кол­
лекции, извлечение элементов из которой осуществляется на основании наиболее
точного совпадения с заданным значением или несколькими значениями. Интерфейс
NavigableSet является обобщенным и объявляется следующим образом:
interface NavigaЬleSet<E>
где Е обозначает тип объектов, содержащихся в множестве. Помимо методов,
наследуемых из интерфейса SortedSet, в интерфейсе NavigableSet опре­
деляются методы, перечисленные в табл. 18.5. Они генерируют исключение
типа ClassCastException , если заданный объект несовместим с элементами
множества. Исключение типа NullPointerException генерируется при по­
пытке ввести пустой объект, когда в множестве не допускаются пустые значе­
ния null. А при указании неверного аргумента передается исключение типа
IllegalArgumentException.
-----------------------------------------------------------------------------------------------------------------------
Интерфейс NavigableSet, внедренный в версии Java SE 6, предоставляет больше возможностей для контроля над подобными
операциями с поддиапазонами элементов коллекций. Так, в приведенных ниже методах из этого интерфейса можно указать, следует
ли вклю чать в выборку элементов из коллекции заданные границы поддиапазона.
                NavigableSet<E> subset(Е from, boolean fromlnclusive, E to, boolean tolnclusive)
                NavigableSet<E> headset(E to, boolean tolnclusive)
                NavigableSet<E> tailSet(E from, boolean fromlnclusive)
-----------------------------------------------------------------------------------------------------------------------
E ceiling(E object)                Vupolniaet poisk v mnozestve naimenshoho elementa e po kriterii
                                   e >= object. Esli takoi element naiden , on vozvrawchaetsa, v
                                   protuvnom slychai pystoe znachenie null

Iterator<E> descendingIterator()   Vozvrashchaet iterator, vupolniaiywchui obxod ot bolsheho elementa
                                   mnozestva k menwemy toest obratnui iterator.

NavigableSet<E> descendingSet()    Vozvrawchaet obiekt NavigableSet obratnniui po otnoweniy k vuzuvaimomy
                                   mnozestvy. Rezyltiryiywchoe mnozestvo podderzevaetsa vuzuvaywchim mnozestvom

E floor(E object)                  Vupolniaet poisk v mnozestve naibolweho elementa e po kriteriy e <= object
                                   Esli takoi element naiden, on vozvrawchaetsa, v protuvnom slychai pustoeznachenie

NavigableSet<E> headSet(E verwuna_hranicu, boolean vklychitelno)
                                   Возвращает объект типа NavigableSet, содержащий vse элемен­
                                   ты из вызывающего множества, menwe zadanoi verxnii_hranicu
                                   Esli ze parameter vklychitelno prinimaet znachenie true, to
                                   v vozvrawchaiywchee mnozestvo vkluchaetsa element, ravnui zadanoi verxnii_hranice
                                   Rezyltiryiywchee mnozestvo podderzevaetsa vuzuvaiywchm mnozestvom­

.... zdes est ewcho metodu


NavigaЬleSet<E> tailSet (E nizniaia_hranica, boolean включительно)
                                   Возвращает объект типа NavigaЬleSet, включающий все
                                   элементы из вызывающего множества, которые больше за­
                                    данной ниж:ней_границы. Если же параметр включите.льно
                                    принимает логическое значение true, то в результирующее
                                    множество включается элемент, равный заданной нижней_
                                    гран ице. Результирующее множество поддерживается вызы­
                                    вающим множеством

•
E higher(E value)
•
E lower(E value)
Возвращают наименьший элемент, который больше указанного значения v a l u e , или наибольший
элемент, который меньше указанного значения v a l u e , а если такой элемент не обнаружен — пу­
стое значение null.
•
Е ceiling(Е value)
• Еfloor(Еvalue)
Возвращают наименьший элемент, который больше или равен указанному значению v a l u e , или
наибольший элемент, который меньше или равен указанному значению v a l u e , а если такой эле­
мент не обнаружен — пустое значение null.
•
Е pollFirstO
•
Е pollLastO
Удаляют и возвращают наименьший или наибольший элемент во множестве или ж е пустое значе­
ние null, если множество оказывается пустым.
•
Iterator<E> descending]! tera tor О
Возвращает итератор, обходящий данное множество в обратном порядке.
•
NavigableSet<E> subset(E from, boolean framlncluded, E to,
boolean tolncluded)
•
NavigableSet<E> headset (E to, boolean tolncluded)
•
NavigableSet<E> tailSet(E from, boolean framlncluded)
Возвращают представление элементов множества в заданном диапазоне. Параметры типа
boolean определяют, следует ли включать в представление заданные границы диапазона.
-----------------------------------------------------------------------------------------------------------------------

*/