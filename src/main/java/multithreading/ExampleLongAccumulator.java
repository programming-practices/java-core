package Examples.Multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.IntStream;

public class ExampleLongAccumulator {

    public static void main(String[] args) {
        LongAdder counter = new LongAdder();
        ExecutorService executorService = Executors.newFixedThreadPool(8);

        int numberOfThreads = 4;
        int numberOfIncrements = 100;

        Runnable incrementAction = () -> IntStream
                .range(0, numberOfIncrements)
                .forEach(i -> counter.increment());

        for (int i = 0; i < numberOfThreads; i++) {
            executorService.execute(incrementAction);
        }

    }

}

/*
------------------------------------------------------------------------------------------------------------
При наличии очень большого количества потоков исполнения, где осуществля­
ется доступ к одним и тем же атомарным значениям, резко снижается производи­
тельность, поскольку для оптимистичных обновлений требуется слишком много по­
пыток. В качестве выхода из этого затруднительного положения в версии Java SE 8
предоставляются классы LongAdder и LongAccumulator.
------------------------------------------------------------------------------------------------------------
Подобный принцип обобщается в классе LongAccumulator до произвольной опе­
рации накопления. Конструктору этого класса предоставляется нужная операция,
а также нейтральный элемент. Для внедрения новых значений вызывается метод
accumulate(), а для получения текущего значения — метод get() . Так, следующий
фрагмент кода дает такой же результат, как и приведенный выше, где применялся класс LongAdder:
				LongAccumulator adder = new LongAccumulator(Long::sum, 0);
				// В некотором потоке исполнения...
				adder.accumulate(value);
В накапливающем сумматоре имеются переменные а2,а2, . . ап.Каждая перемен­
ная инициализируется нейтральным элементом (в данном случае — 0).
Когда метод accumulate () вызывается со значением v, одна из этих переменных
автоматически обновляется следующим образом: а2 * а 2 op v, где ор — операция
накопления в инфиксной форме записи. В данном примере в результате вызова мето­
да accumulate () вычисляется сумма а 2 * а 2 + тг для некоторой величины 1.
Авызов метода get() приводит к такомурезультату: а2 ор а2 ор ... ор ап. В
данном примере это сумма всех накапливающих сумматоров а 2 + а 2 + . . . + а п.
Если выбрать другую операцию, то можно вычислить максимум или минимум.
В общем, операция должна быть ассоциативной или коммуникативной. Это означа­
ет, что конечный результат не должен зависеть от порядка, в котором объединяются
промежуточные значения.
Имеются также классы DoubleAdder и DoubleAccumulator. Они действуют анало­
гичным образом, только оперируют значениями типа double.
------------------------------------------------------------------------------------------------------------
*/
