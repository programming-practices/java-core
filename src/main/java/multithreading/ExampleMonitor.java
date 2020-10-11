package multithreading;

public class ExampleMonitor {
    static volatile boolean inVolatile = false;
    static boolean inNotVolatile = false;

    public static void main(String[] args) throws InterruptedException {
// ---------------------------------------------------------------------------------------------------------------------
//		Object ref0 = new Object();
//		Object ref1 = new Object();
// ---------------------------------------------------------------------------------------------------------------------
//		synchronized (new Object()) {
//			// tak vuxodit exception java.lang.IllegalMonitorStateException,
//			// potomy chto nado syncronizirovatsa i vuzuvat metod wait() po
//			// odnomy i tomyze obiekty
//			new Object().wait();
//		}
// ---------------------------------------------------------------------------------------------------------------------
        // synchronized (ref0){
        // // holdsLock hovorit kto zaxvatil monitor
        // System.out.println(Thread.holdsLock(new Object())); // false
        // System.out.println(Thread.holdsLock(ref0)); // true
        // }
// ---------------------------------------------------------------------------------------------------------------------
        //
        // methodStatic();
        // new ExampleMultithreadingMonitor00().methodNotStatic();
// ---------------------------------------------------------------------------------------------------------------------
        // vzaimnoe isklychenie, zdes bydet prechatatsa veschas ili "A" ili "B" , no
        // potok kotorui pechataet
        // "A" budet pochti ves chas pechatat "A" iz za toho chto on stoi pervui v
        // poriadke, no pri lyboi sledyewcheho
        // zapysky prohramu mozet stobotat potok "B" .
        //
        // final Object montor = new Object();
        //
        // new Thread(new Runnable() {
        // @Override
        // public void run() {
        // synchronized (montor){
        // while (true){
        // System.out.println("A");
        // }
        // }
        // }
        // }).start();
        //
        // new Thread(new Runnable() {
        // @Override
        // public void run() {
        // synchronized (montor){
        // while (true){
        // System.out.println("B");
        // }
        // }
        // }
        // }).start();
// ---------------------------------------------------------------------------------------------------------------------
        // // A zdes potoki imeity raznue monitoru, i poetomy bydet pechatatsa "A" i "B"
        // final Object montor0 = new Object();
        // final Object montor1 = new Object();
        //
        // new Thread(new Runnable() {
        // @Override
        // public void run() {
        // synchronized (montor0){
        // while (true){
        // System.out.println("A");
        // }
        // }
        // }
        // }).start();
        //
        // new Thread(new Runnable() {
        // @Override
        // public void run() {
        // synchronized (montor1){
        // while (true){
        // System.out.println("B");
        // }
        // }
        // }
        // }).start();
// ---------------------------------------------------------------------------------------------------------------------
        //// A zdes potoki rabotayt po ocheridi, smotret preveddonunui kod i vse poimem
        //// pochemy tak proisxodit

        // final Object montor = new Object();
        //
        // new Thread(new Runnable() {
        // @Override
        // public void run() {
        // while (true){
        // synchronized (montor){
        // // +A i -A zdes atomarnu
        // System.out.println("+A");
        // System.out.println("-A");
        // }
        // }
        // }
        // }).start();
        //
        // new Thread(new Runnable() {
        // @Override
        // public void run() {
        // while (true){
        // synchronized (montor){
        // System.out.println("+B");
        // System.out.println("-B");
        // }
        // }
        // }
        // }).start();
// --------------------------------------------------------------------------------------------------------------------
        // final Object montor0 = new Object();
        // final Object montor1 = new Object();
        //
        // new Thread(new Runnable() {
        // @Override
        // public void run() {
        // while (true){
        // synchronized (montor0){
        // // +A i -A zdes ne atomarnu
        // System.out.println("+A");
        // System.out.println("-A");
        // }
        // }
        // }
        // }).start();
        //
        // new Thread(new Runnable() {
        // @Override
        // public void run() {
        // while (true){
        // synchronized (montor1){
        // System.out.println("+B");
        // System.out.println("-B");
        // }
        // }
        // }
        // }).start();
// ---------------------------------------------------------------------------------------------------------------------
        // final Object monitor = new Object();
        //
        // // Esli peremennaia volatile to vse rabotaet xorowo.
        // // No esli ne volatile to izmenenia zdelanue v potoke "thread" ne
        // // obezatelno bydyt vidnu v potoki maina, toest programa v meste gde
        // while(!inNotValue) povisnet.
        //
        // Thread thread = new Thread(new Runnable() {
        // @Override
        // public void run() {
        // synchronized (monitor){
        // inVolatile = true;
        // try {
        //// Thread.sleep(Long.MAX_VALUE);
        // Thread.sleep(10000);
        // } catch (InterruptedException ignor) { }
        // }
        // }
        // });
        // thread.start();
        //
        // System.out.println("A");
        // while (!inVolatile); // eto nazivaetsa spin lock ili busy waiting , toest eto
        // ozidanie nekotoroho deistvia1
        // System.out.println("B");
        // synchronized (monitor){
        // System.out.println("C");
        // }
        // Eto riwenie zadachi verno, a sledyewchee reweniw ne verno
// ---------------------------------------------------------------------------------------------------------------------
        // // Etot kod delaet odno i toze chto i kon s verxy no etot kod ne veren, pri bolwux nahryzkax .
        // // Imeetsa v vidy wtob potok "thread" zapustilsa do toho kak potok main
        // // ispolnit svoi kod, toest nado vupolnit potok "thread" snachala a potom main.
        // // No esli mnoho potokov to mozet takoe slychitsa chto potok "thread" zapystitsa
        // // posle vupolnenia koda iz maina, iz za toho chto main potok prosnetsaskoreie chem
        // // sheduler zapystit potok "thread" potomu chto sheduler imeet mnoho potokovv ozidanii
        // final Object monitor = new Object();
        //
        // Thread thread = new Thread(new Runnable() {
        // @Override
        // public void run() {
        // synchronized (monitor){
        // try {
        //// Thread.sleep(Long.MAX_VALUE);
        // Thread.sleep(10000);
        // } catch (InterruptedException ignor) { }
        // }
        // }
        // });
        // thread.start();
        //
        // Thread.sleep(1000_000);
        //
        // System.out.println("A");
        // System.out.println("B");
        // synchronized (monitor){
        // System.out.println("C");
        // }

// ---------------------------------------------------------------------------------------------------------------------
        // final Object monitor = new Object();
        //
        // Thread thread = new Thread(new Runnable() {
        // @Override
        // public void run() {
        // synchronized (monitor){
        // inVolatile = true;
        // try {
        //// Thread.sleep(Long.MAX_VALUE);
        //// Thread.sleep(10000); // Ttread.sleep() kohda lozitsa spat to ne otpyskaet
        // monitor
        //// Thread.yield(); // Delaet s etim kodom toze samoe wto Thread.sleep()
        // monitor.wait(); // Esli delat tak s weit to etot kod napichataet "C" potomy
        // // chto Thread.weit() kohda zasupaet on otpuskaet monitor
        // } catch (InterruptedException ignor) { }
        // }
        // }
        // });
        // thread.start();
        //
        // System.out.println("A");
        // while (!inVolatile); // eto nazivaetsa spin lock ili busy waiting , toest eto
        // ozidanie nekotoroho deistvia1
        // System.out.println("B");
        // synchronized (monitor){
        // System.out.println("C");
        // }
// ---------------------------------------------------------------------------------------------------------------------
        final Object monitor = new Object();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (monitor) {
                    inVolatile = true;
                    try {
                        System.out.println("X");
                        monitor.wait();
                        System.out.println("Y");
                    } catch (InterruptedException ignor) {
                    }
                }
            }
        });
        thread.start();

        System.out.println("A");
        // eto nazivaetsa spin lock ili busy waiting , toest eto ozidanie nekotoroho deistvia1
        while (!inVolatile) ;
        System.out.println("B");
        synchronized (monitor) {
            System.out.println("C"); // Posle "C" ne vozmozno chtobu bylo napichatano "Y"
            monitor.notify(); // V etom slychai prohrama zaverwitsa
            System.out.println("D"); // Ochen interesnui moment, chto bdet vuvedeno pervum "D" ili "Y"
        }
        System.out.println("E");

// ---------------------------------------------------------------------------------------------------------------------
        // waint-set i blocked-set - dlya kazdoho monitora svoi.
// ---------------------------------------------------------------------------------------------------------------------

    }

    // --------------------------------------------------------------------------------------------------------------------
    static synchronized void f() {
        g();
    }

    static synchronized void g() {
        h();
    }

    static synchronized void h() {
        System.out.println("Hello");
    }

    // -------------------------------------------------------------------------------------------------------------------
    static synchronized void methodStatic() {
        System.out.println("Method static!!!");
        System.out.println(
                "Thread.holdsLock(ExampleMultithreadingMonitor00.class) = " + Thread.holdsLock(ExampleMonitor.class));
        System.out.println();
    }

    synchronized void methodNotStatic() {
        System.out.println("Method not static!!!");
        System.out.println("Thread.holdsLock(this) = " + Thread.holdsLock(this));
    }
// ---------------------------------------------------------------------------------------------------------------------
}

/*
-----------------------------------------------------------------------------------------------------------------------
В терминологии Java монитор обладает следующими свойствами.
	• Монитор — это класс, имеющий только закрытые поля.
	• У каждого объекта такого класса имеется связанная с ним блокировка.
	• Все методы блокируются этой блокировкой. Иными словами, если клиент вы­зывает метод obj.method(), блокировка объекта 
	  obj автоматически захваты­ вается в начале этого метода и снимается по его завершении. А поскольку все поля класса 
	  монитора закрытые, то такой подход гарантирует, что к ним нель­зя будет обратиться ни в одном из потоков исполнения 
	  до тех пор, пока ими манипулирует какой-то другой поток.	
	• У блокировки может быть любое количество связанных с ней условий.
-----------------------------------------------------------------------------------------------------------------------
Но объекты в Java отличаются от мониторов в следующих трех важных отношени­ях,нарушающих безопасность потоков исполнения.
	• Поля не обязательно должны быть закрытыми (private).
	• Методы не обязаны быть синхронизированными (synchronized).
	• Встроенная блокировка доступна клиентам.
-----------------------------------------------------------------------------------------------------------------------
*/
