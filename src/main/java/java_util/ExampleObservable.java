package java_util;

import java.util.Observable;
import java.util.Observer;

public class ExampleObservable {
    public static void main(String[] args) {
//---------------------------------------------------------------------------------------------------------------------
//        //Demonstrate the Observable class and the Observer interface.
//        BeingWatched00 observed = new BeingWatched00();
//        Watcher observing = new Watcher();
//
//        //Add the observing to the list of observers for observed object.
//        observed.addObserver(observing);
//
//        observed.counter(10);
//---------------------------------------------------------------------------------------------------------------------
        //An object may be observed by two or more observers.
        BeingWatched01 observed01 = new BeingWatched01();
        Watcher1 observing1 = new Watcher1();
        Watcher2 observing2 = new Watcher2();

        // add both observers
        observed01.addObserver(observing1);
        observed01.addObserver(observing2);

        observed01.counter(10);
//---------------------------------------------------------------------------------------------------------------------
    }
}

// This is the first observing class.
class Watcher1 implements Observer {
    public void update(Observable obj, Object arg) {
        System.out.println("update() called, count is " +
                ((Integer) arg).intValue());
    }
}

// This is the second observing class.
class Watcher2 implements Observer {
    public void update(Observable obj, Object arg) {
        // Ring bell when done
        if (((Integer) arg).intValue() == 0)
            System.out.println("Done" + '\7');
    }
}

// This is the class being observed.
class BeingWatched01 extends Observable {
    void counter(int period) {
        for (; period >= 0; period--) {
            setChanged();
            notifyObservers(new Integer(period));
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Sleep interrupted");
            }
        }
    }
}

// This is the observing class.
class Watcher implements Observer {
    public void update(Observable obj, Object arg) {
        System.out.println("update() called, count is " +
                ((Integer) arg).intValue());
    }
}

// This is the class being observed.
class BeingWatched00 extends Observable {
    void counter(int period) {
        for (; period >= 0; period--) {
            setChanged();
            notifyObservers(new Integer(period));
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Sleep interrupted");
            }
        }
    }

}




/*
-----------------------------------------------------------------------------------------------------------------------
Класс Ob s e rvaЫe служит для создания подклассов, з а которыми могуг наблю­
дать остальные части прикладной программы. Когда в объекте такого подкласса
происходят изменения, об этом извещаются наблюдающие классы. Наблюдающие
классы должны реализовать интерфейс Ob s e rve r , в котором определен метод u p­
da te ( ) . Этот метод вызывается, когда наблюдатель получает извещение об изме­
нении наблюдаемого объекта.
В классе Ob s e rvaЫ e определяются методы, приведенные в табл. 1 9.8.
Наблюдаемый объект должен следовать двум простым правилам. Во-первых, если
он изменяется, то должен вызывать метод s e t Changed ( ) . Во-вторых, когда он
готов известить наблюдателей об этом изменении, то должен вызвать метод no­
t i fyOb s e r ve r s ( ) . Это вынуждает наблюдающий объект ( или объекты) вызывать
метод upda te ( ) . Следует, однако, иметь в виду, что если объект обращается к ме­
тоду noti fyOb s e rve r s ( ) , не вызвав предварительно метод se tChanged ( ) , то ни­
какого действия не последует. Наблюдаемый объект должен вызвать оба метода,
se t Changed ( ) и not i fyOb s e rve r s ( ) , прежде чем будет вызван метод upda te ( ) .
-----------------------------------------------------------------------------------------------------------------------
Класс Obs e rvaЫ e и интерфейс Obs e rve r позволяют реализовывать изощренные
программные архитекrуры, основанные на методике "документ-представление".
-----------------------------------------------------------------------------------------------------------------------
*/