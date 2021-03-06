package collections.map;

public interface ExampleMapEntry {
}

/*
-----------------------------------------------------------------------------------------------------------------------

Этот интерфейс позволяет обращаться с отдельными записями в отображе-
11ии. Ва11омни м , что метод e n t r y S e t ( ) объя вляемый в интерфейсе Мар , воз·
вращает множество типа S e t , содержащее записи из отображения. Каждый элемент
этого м11ожества 11редставляет собой объект типа Мар . En t r y .

В версииJDК 8 в интерфейс введены два статических метода. Первый
из них назывсtется c omp a r i ng B yKe y ( ) и возвращает компаратор типа Comp a r a t o r ,
сравнивающий записи в отображении по зманному ключу. А второй называется
comp a r i n g B yVa l u e ( ) и возвращает компарсtтор типа C ompa r a t o r , сравнивающий
записи в отображении по указанному значению.

-----------------------------------------------------------------------------------------------------------------------

boolean equals(Object о6ъект)           Возвращает логическое значение true, есл и заданный обыкт п р ед·
                                        ставляет запись из отображения типа Мар . Еntrу, ключ и значение
                                        в которой такие же, как и у вызывающего объекта

К gеtкеу()                              Возвращает ключ данной записи из отображения

V getValue()                            Возвращает значение данной записи из отображения

int hashCode()                          Возвращает хеш-код данной записи из отображения

V setValue(V v)                         Устанавливает указанное значение v в данной записи из ото­
                                        бражения. Если значение v не относится к типу, допустимому
                                        для данного отображения, то генерируется исключение типа
                                        ClassCastException. Если же значение v указано неверно, то
                                        генерируется исключение типа IlleqalArgwвentException.
                                        А если значение v оказывается пустым ( nul l ) и в отображении
                                        нельзя хранить пустые ключи, то генерируется исключение
                                        типа NullPointerException. И наконец, если в отображение
                                        нельзя вносить изменения, то генерируется исключение типа
                                        Unsupport edOpe rationException

•
К getKeyO
•
V getValueO
Возвращают ключ или значение из данного элемента отображения.
•
V setValue(V newValue)
Заменяет прежнее значение новым в связанном с ним отображении и возвращает прежнее зна­
чение.
-----------------------------------------------------------------------------------------------------------------------


*/
