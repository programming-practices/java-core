package Examples.Multithreading;


public class ExampleThreadGroup {
    public static void main(String args[]) {
        ThreadGroup groupA = new ThreadGroup("Group A");
        ThreadGroup groupB = new ThreadGroup("Group B");

        NewThread ob1 = new NewThread("One", groupA);
        NewThread ob2 = new NewThread("Two", groupA);
        NewThread ob3 = new NewThread("Three", groupB);
        NewThread ob4 = new NewThread("Four", groupB);

        System.out.println("\nHere is output from list():");
        groupA.list();
        groupB.list();
        System.out.println();

        System.out.println("Suspending GroupA");
        Thread tga[] = new Thread[groupA.activeCount()];
        groupA.enumerate(tga); // get threads in group
        for (int i = 0; i < tga.length; i++) {
            ((NewThread) tga[i]).mysuspend(); // suspend each thread
        }

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }

        System.out.println("Resuming Group A");
        for (int i = 0; i < tga.length; i++) {
            ((NewThread) tga[i]).myresume(); // resume threads in group
        }

        // wait for threads to finish
        try {
            System.out.println("Waiting for threads to finish.");
            ob1.join();
            ob2.join();
            ob3.join();
            ob4.join();
        } catch (Exception e) {
            System.out.println("Exception in Main thread");
        }

        System.out.println("Main thread exiting.");
    }
}

//Demonstrate thread groups.
class NewThread extends Thread {
    boolean suspendFlag;

    public NewThread(String threadname, ThreadGroup tgOb) {
        super(tgOb, threadname);
        System.out.println("New thread: " + this);
        suspendFlag = false;
        start(); // Start the thread
    }

    // This is the entry point for thread.
    public void run() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println(getName() + ": " + i);
                Thread.sleep(1000);
                synchronized (this) {
                    while (suspendFlag) {
                        wait();
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Exception in " + getName());
        }
        System.out.println(getName() + " exiting.");
    }

    synchronized void mysuspend() {
        suspendFlag = true;
    }

    synchronized void myresume() {
        suspendFlag = false;
        notify();
    }
}


/*
 * -------------------------------------------------------------------------------------------------------------------------
 * НА ЗАМЕТКУ! Группа потоков — это коллекция потоков исполнения, которой можно управлять со­вместно. По умолчанию все
 * создаваемые потоки исполнения относятся к одной и той же группе потоков, но можно устанавливать и другие группы. Теперь в
 * Java имеются более совершенные средства для выполнения операций над коллекциями потоков исполнения, поэтому пользоваться
 * группами потоков в собственных программах не рекомендуется.
 * ------------------------------------------------------------------------------------------------------------------------
 * Класс ThreadGroup реализует интерфейс Thread.UncaughtExceptionHandler.Его метод uncaughtException() выполняет следующие
 * действия.
 * 1. Если у группы потоков имеется родительская группа, то из нее вызывается ме­тод uncaughtException().
 * 2. Иначе, если методThread.getDefaultExceptionHandler() возвращает непу­стой обработчик (т.е. неnull), то вызывается именно
 * этот обработчик. 3. Иначе, если объект типа Throwable является экземпляром класса ThreadDeath, то ничего не происходит.
 * 4. Иначе имя потока исполнения и трассировка стека объекта типа Throwable выводятся в стандартный поток сообщений об
 * ошибках System.err.
 * ------------------------------------------------------------------------------------------------------------------------
 * •void uncaughtException (Thread t, Throwable e)
 * 		Этот метод вызывается из родительской группы потоков, если таковая имеется, или же вызывается обработчик по умолчанию
 * 		из класса Thread, если таковой имеется, а иначе выводится трассиров­ка стека в стандартный поток сообщений об ошибках.
 * 		(Но если е — объект типа ThreadDeath, то трассировка стека подавляется. Объекты типа ThreadDeath формируются
 * 		устаревшим и не реко­мендованным к применению методом stop().)
 * ------------------------------------------------------------------------------------------------------------------------
 */
