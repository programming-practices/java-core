package Examples.Multithreading;

import java.util.concurrent.atomic.AtomicInteger;

public class ExampleAtomicInteger {
    private final static int N = 1_000_000;
    public static AtomicInteger largest = new AtomicInteger();
    private static AtomicInteger counter = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
//--------------------------------------------------------------------------------------------
    	/*Имеются также методы для автоматической установки, сложения и вычитания
		  значений, но если требуется выполнить более сложное их обновление, то придется
		  вызвать метод compareAndSet(). Допустим, в нескольких потоках исполнения тре­
		  буется отслеж ивать наибольшее значение. Приведенный ниже код для этой цели не
		  годится.*/

        int observed = 3;
        int oldValue;
        int newValue;
        // В некотором потоке исполнения...
        largest.set(Math.max(largest.get(), observed));
        // ОШИБКА из-за условия гонок!
    	/*Такое обновление не является атомарным. Вместо этого следует вычислять новое
    	значение и вызывать метод compareAndSet () в цикле, как показано ниже.*/
        do {
            oldValue = largest.get();
            newValue = Math.max(oldValue, observed);
        } while (!largest.compareAndSet(oldValue, newValue));
    	/*Если переменная largest обновляется и в другом потоке исполнения, то
		  вполне возможно, что он одержит верх над текущим потоком. И тогда метод
		  compareAndSet() возвратит логическое значение false, не установив новое значение.
		  В таком случае будет осуществлена еще одна попытка выполнить приведенный выше
		  цикл с целью прочить обновленное значение и попытаться изменить его.
		  
		  Начиная с версии Java SE 8, организовывать подобный цикл больше не нужно.
		  Вместо этого достаточно предоставить лямбда-выражение, чтобы требующееся значе­
		  ние обновлялось автоматически. Так, в рассматриваемом здесь примере можно сде­
		  лать один из следующих вызовов:*/
        largest.updateAndGet(х -> Math.max(observed, observed));
        //или
        largest.accumulateAndGet(observed, Math::max);
//--------------------------------------------------------------------------------------------
//        Thread thread_1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for(int i = 0; i < N; i++){
//                    counter.incrementAndGet();
//                }
//            }
//        });
//        Thread thread_2 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for(int i = 0; i < N; i++){
//                    counter.incrementAndGet();
//                }
//            }
//        });
//        thread_1.start();
//        thread_2.start();
//        thread_1.join();
//        thread_2.join();
//        System.out.println(counter);
//--------------------------------------------------------------------------------------------
    }
}

/*
--------------------------------------------------------------------------------------------------
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
--------------------------------------------------------------------------------------------------
*/
