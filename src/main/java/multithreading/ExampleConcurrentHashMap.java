package Examples.Multithreading;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.LongAdder;

public class ExampleConcurrentHashMap {
    public static void main(String[] arg) {
	   /*Можно ли в таком случае воспользоваться хеш-отображением типа Concurrent
		 HashMap<String, Long>? Рассмотрим пример инкрементирования счета. Очевидно, что
		 приведенный ниже фрагмент кода не является потокобезопасным, поскольку в следую­
		 щем потоке исполнения может быть одновременно обновлен тот же самый счет.*/
        Map<String, Long> map = new ConcurrentHashMap<>();
        String word = "Hello";
        Long oldValue = map.get(word);
        Long newValue = oldValue == null ? 1 : oldValue + 1;
        map.put(word, newValue); // ОШИБКА - заменить значение
        // переменной oldValue, возможно, не удастся*/
        /*В качестве классического приема можно воспользоваться операцией, выполняе­
        мой методом replace(), где прежнее значение атомарно заменяется новым значени­
        ем, при условии, что прежнее значение не было раньше заменено на нечто иное ни
        в одном другом потоке исполнения. Эту операцию придется продолжать до тех пор,
        пока метод replace() не завершится успешно, как показано ниже.*/
        do {
            oldValue = map.get(word);
            newValue = oldValue == null ? 1 : oldValue + 1;
        } while (!map.replace(word, oldValue, newValue));

        /*С другой стороны, можно воспользоваться хеш -отображением типа Concurrent
        HashMap<String, AtomicLong> или же хеш -отображен ием типа ConcurrentHash
        Map<String, LongAdder>, начиная с версии Java SE 8. И тогда код обновления запи­
        сей в хеш-отображении будет выглядеть следующим образом:*/
        Map<String, LongAdder> map1 = new ConcurrentHashMap<>();
        map1.putIfAbsent(word, new LongAdder());
        map1.get(word).increment();
    }
}

/*
---------------------------------------------------------------------------------------------------------------------
НА ЗАМЕТКУ! Некоторых программистов удивляет, что в потокобезопасной, предположительно,
структуре данных разрешаются операции, не являющиеся потокобезопасными. Но этому имеют­
ся два совершенно противоположных объяснения. Если простое хеш -отображение типа HashMap
модифицируется в нескольких потоках исполнения, они могут нарушить его внутреннюю структуру
(т.е. массив связных списков). В итоге некоторые связи могут быть пропущены и даже зациклены,
приведя структуру данных в полную негодность. Ничего подобного не может произойти с хеш -о ­
тображением типа ConcurrentHashMap. В приведенном выше примере кода вызовы методов
get() и put() вообще не нарушают структуру данных. Но поскольку последовательность выпол­
няемых операций не является атомарной, то ее результат непредсказуем.
---------------------------------------------------------------------------------------------------------------------
HA ЗАМЕТКУ! В хеш-отображении типа ConcurrentHashMap пустые значения null не допуска­
ются. Имеется немало методов, в которых пустое значение null служит для указания на то, что
заданный ключ отсутствует в отображении.
---------------------------------------------------------------------------------------------------------------------
•ConcurrentHashMap<K, V>()
•ConcurrentHashMap<K, V>(int initialCapacity)
•ConcurrentHashMap<K/ V>(int initialCapacity, float loadFactor, int concurrencyLevel)
	Конструируют отсортированное хеш-отображение, безопасно доступное из многих потоков.
		Параметры: initialCapacity  Исходная емкость данной
									коллекции. По умолчанию
									она равна 16
						loadFactor  Управляет изменением
									размера коллекции: если
									средняя загрузка на группу
									превышает этот показатель,
									то размер хеш-таблицы изменяется
				  concurrencyLevel  Ожидаемое количество
									конкурирующих потоков,
									исполняющих запись
									
•ConcurrentSkipLi stMap<K, V> ()
•ConcurrentSkipListSet<K, V> (Comparator^ super K> camp)
	Конструируют отсортированное хеш-отображение, безопасно доступное из многих потоков испол­
	нения. Первый конструктор требует, чтобы элементы множества относились к классу, реализующе­
	му интерфейс Comparable.
---------------------------------------------------------------------------------------------------------------------
*/