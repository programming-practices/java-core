package multithreading;

public class ExampleLongAdder {

    public static void main(String[] args) {

    }

}

/*
------------------------------------------------------------------------------------------------------------
При наличии очень большого количества потоков исполнения, где осуществля­
ется доступ к одним и тем же атомарным значениям, резко снижается производи­
тельность, поскольку для оптимистичных обновлений требуется слишком много по­
пыток. В качестве выхода из этого затруднительного положения в версии Java SE 8
предоставляются классы LongAdder и LongAccumulator.
В частности, класс LongAdder
состоит из нескольких полей, общая сумма значений в которых составляет текущее
значение. Разные слагаемые этой суммы могут обновляться во многих потоках ис­
полнения, а новые слагаемые автоматически предоставляются по мере увеличения
количества потоков.
------------------------------------------------------------------------------------------------------------
Если предвидится высокая степень состязательности потоков исполнения за до­ступ к общим данным, то вместо 
класса AtomicLong следует воспользоваться классом LongAdder. Методы в этом классе называются несколько иначе. 
Так, для и нкремен­ тирования счетчика вызывается метод increment(), для прибавления величины — метод add(), 
а для извлечения итоговой суммы — метод sum(), как показано ниже.
				final LongAdder adder = new LongAdder();
				for (...)
					pool.submit(() -> {
						while(...){
						...
						if (. . .) adder.increment();
						}
					 });
					 ...
				long total = adder.sum());
------------------------------------------------------------------------------------------------------------
*/
