package multithreading;

public class ExampleConcurrentSkipListMap {

    public static void main(String[] args) {

    }

}

/*
---------------------------------------------------------------------------------------------------------------------
•ConcurrentHashMap<K, V>()
•ConcurrentHashMap<K, V>(int initialCapacity)
•ConcurrentHasbMap<K/ V>(int initialCapacity, float loadFactor, int concurrencyLevel)
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
