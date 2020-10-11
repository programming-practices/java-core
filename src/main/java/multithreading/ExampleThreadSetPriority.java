package Examples.Multithreading;

public class ExampleThreadSetPriority {

    public static volatile boolean stop = false;

    public static void main(String[] args) throws InterruptedException {
        final Thread[] threads = new Thread[32];
        for (int i = 0; i < 32; i++) {
            final int finalk = i;
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int index = 0; index < 1_000_000_000_000_000_000L; index++) {
                        if (stop) {
                            System.out.println(finalk + ":" + index);
                            break;
                        }
                    }
                }
            });
        }

        for (int i = 0; i < 32; i++) {
            threads[i].setPriority(i < 16 ? Thread.MIN_PRIORITY : Thread.MAX_PRIORITY);
        }

        for (int i = 0; i < 32; i++) {
            threads[i].start();
        }

        Thread.sleep(1_000);
        stop = true;
    }
}

/*
--------------------------------------------------------------------------------------------------------------------
ВНИМАНИЕ! Если вы в се-таки используете приоритеты в своих программах, вам следует знать об ошибках, распространенных 
среди начинающих. Так, если имеется несколько потоков исполне­ния с высоким приоритетом, которые не перестают быть 
активными, то менее приоритетные потоки могут вообще не выполниться. Всякий раз, когда планировщик потоков решает 
запустить новый поток исполнения, он выбирает сначала среди наиболее высокоприоритетных потоков, даже если они могут 
полностью подавить активность низкоприоритетных потоков.

Nе рекомендуется писать свои программы таким образом, чтобы их правильное функционирование зависело от уровней приоритетов.
--------------------------------------------------------------------------------------------------------------------
По умолчанию поток исполнения наследует приоритет того потока, который его создал.
--------------------------------------------------------------------------------------------------------------------
А установить приоритет потока исполнения можно,указав любое значение в пределах от MIN PRIORITY (определено в классе 
Thread рав­ным 1) до MAX PRIORITY (равно 10). Обычному приоритету соответствует значение NORM_PRIORITY, равное 5.
--------------------------------------------------------------------------------------------------------------------
Например, в Windows предусмотрено семь уровней приоритетов. Некоторые при­оритеты Java привязываются к тому же самому 
уровню приоритета операционной системы. В виртуальной машине O racle для Linux приоритеты потоков исполнения вообще 
игнорируются. Все потоки исполнения имеют одинаковый приоритет.
--------------------------------------------------------------------------------------------------------------------
*/
