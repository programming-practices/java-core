package Examples.Multithreading;

public class ExampleThreadLocal {
    public static void main(String[] args) throws InterruptedException {
        MyRunnable sharedRunnableInstance = new MyRunnable();

        Thread thread1 = new Thread(new MyRunnable());
        Thread thread2 = new Thread(new MyRunnable());

        thread1.start();
        thread2.start();

        thread1.join();  // ждать завершения потока 1
        thread2.join();  // ждать завершения потока 2
    }
}

class MyRunnable implements Runnable {
    private ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();

    @Override
    public void run() {
        threadLocal.set((int) (Math.random() * 100D));

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }

        System.out.println(threadLocal.get());
    }
}

/*
 * -------------------------------------------------------------------------------------------------------------
 * Класс позволяет иметь различное значение для каждого из потоков с использованием только одной переменной
 * -------------------------------------------------------------------------------------------------------------
 * •T get() Получает текущее значение в данном
 * потоке исполнения. Если этот метод вызывается в первый раз, то значение
 * получается в результате вызова метода initialize ().
 *
 * •protected initialize () Этот метод следует переопределить, чтобы он
 * предоставил исходное значение. По умолчанию этот метод возвращает пустое
 * значение null.
 *
 * •void set(T t) Устанавливает новое значение для данного потока исполнения.
 *
 * •void remove() Удаляет значение из потока исполнения.
 *
 * •static <S> ThreadLocal<S> withlnitial(Supplier<? extends S> supplier) 8
 * Создает в потоке исполнения локальную переменную, исходное значение которой
 * получается в ре­ зультате вызова заданного поставщика информации.
 * -------------------------------------------------------------------------------------------------------------
 */
