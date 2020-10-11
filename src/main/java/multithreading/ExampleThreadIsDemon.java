package Examples.Multithreading;

public class ExampleThreadIsDemon {
    public static void main(String[] args) {
        ChilderThread childerThread = new ChilderThread();
//        childerThread.setDaemon(false);
        System.out.println(childerThread.isDaemon());
    }
}

class ParentThreadDeamon extends Thread {
    public ParentThreadDeamon() {
        this.setDaemon(true);
    }
}

class ChilderThread extends ParentThreadDeamon {
    public ChilderThread() {
    }
}

/*
-----------------------------------------------------------------------------------------------------------------------
JVM zaverwaet raboty ne tohda kohda zaverwaetsa metod main, a tohda kohda vse potoki kotorue sozdal metod main (potoki 
kotorue ne demonu)zakonchat raboty.

No eslli ostalis tolko potoki demonu to JVM zaverwaet raboty tohda kohda zaverwaetsa metod main i JVM ybivaet vse 
potoki demonu.

Esli potok demon i ot neho nasledyytsa to, ynasledovanui potok toze bydet demon.
esli etot potok demon to eho ybiet JVM tohda kohda maverwitsa method main, i eta prohrama ne povisnet.

Vse eti metodu set...() dolznu iti pered metodom thread00.start():
setDaemon(), setName(), setPriority(), setContextClassLoader(), setUncaughtExceptionHandler();

No esli oni bydyt iti posle metoda stat() to bydet isklychenie java.lang.IllegalThreadStateException
-----------------------------------------------------------------------------------------------------------------------
Потоковый демон вообще не должен обращаться к такому постоянному ресурсу, как файл или база данных, поскольку он может 
быть прерван в любой мо­мент, даже посередине операции.
-----------------------------------------------------------------------------------------------------------------------
•void setDaemon (boolean isDaemon)
	Помечает данный поток исполнения ка к демон или пользовательский поток. Этот метод должен вызываться перед запуском 
	потока исполнения.
-----------------------------------------------------------------------------------------------------------------------

*/