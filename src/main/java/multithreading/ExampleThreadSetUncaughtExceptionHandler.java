package Examples.Multithreading;

public class ExampleThreadSetUncaughtExceptionHandler {
    public static void main(String[] args) throws Exception {
//---------------------------------------------------------------------------------------------------------------------
//       final ThreadGroup group = new ThreadGroup("stub");
////        new Thread(group, new Produser(0, 0, 0, new SingleElementBuffer()));
////        new Thread(group, new Produser(0, 0, 0, new SingleElementBuffer()));
////        new Thread(group, new Produser(0, 0, 0, new SingleElementBuffer()));
////        new Thread(group, new Consumer(0,new SingleElementBuffer()));
////        new Thread(group, new Consumer(0,new SingleElementBuffer()));
//        Thread me = Thread.currentThread();
//        me.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
//            @Override
//            public void uncaughtException(Thread t, Throwable e) {
//                System.out.println("bad");
//            }
//        });
//        throw new Exception();
//---------------------------------------------------------------------------------------------------------------------
        /*Метод run() потока исполнения не может генерировать никаких проверяемых исключений, но может быть прерван
         * непроверяемым исключением. В этом случае поток исполнения уничтожается. Но такой конструкции catch, куда
         * может распро­страниться исключение, не существует. Вместо этого, перед тем, как поток исполне­ния прекратит
         * свое существование, исключение передается обработчику необрабаты­ ваемых исключений. Такой обработчик должен
         * относиться к классу, реализующему интерфейс Thread.UncaughtExceptionHandler.*/
        final ThreadGroup group = new ThreadGroup("stub");

        Thread.UncaughtExceptionHandler exceptionHandler = new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                group.interrupt();
            }
        };

        Thread thread0 = new Thread(group, new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(Long.MAX_VALUE);
                } catch (InterruptedException e) {
                    System.out.println("thread0 - killed");
                }
            }
        });
        thread0.setUncaughtExceptionHandler(exceptionHandler);
        thread0.start();

        Thread thread1 = new Thread(group, new Runnable() {
            @Override
            public void run() {
                System.out.println("thread 1 - dead");
                throw new Error();
            }
        });

        /*Кроме того, можно установить обработчик по умолчанию для всех потоков с помощью статического метода
         * setDefaultUncaughtExceptionHandler() из класса Thread.*/
        thread1.setUncaughtExceptionHandler(exceptionHandler);
        thread1.start();
//---------------------------------------------------------------------------------------------------------------------
    }
}

/*
-----------------------------------------------------------------------------------------------------------------------------
Если не установить обработчик по умолчанию , то такой обработчик оказывается пустым (null). Но если не установить обработчик 
для отдельного потока исполнения, то им становится объект потока типа ThreadGroup.
-----------------------------------------------------------------------------------------------------------------------------
*/
