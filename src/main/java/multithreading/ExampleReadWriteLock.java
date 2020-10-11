package multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ExampleReadWriteLock {
    public static void main(String[] args) throws InterruptedException {
        ReadWriteLock rw = new ReentrantReadWriteLock();
        Lock readL = rw.readLock();
        Lock writeL = rw.writeLock();
//---------------------------------------------------------------------------------------------------------------------

//        // 1) Zdes pokazano chto dva potoki kotorue ispolzyyt odny i tuze blokirovky readL, ne blokiryytsa
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                readL.lock();
//                System.out.println("0");
//                while (true);
//            }
//        }).start();
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                readL.lock();
//                System.out.println("1");
//                while (true);
//            }
//        }).start();

//--------------------------------------------------------------------------------------------------------------------
//
//        // 2) A zdes pokazano chto dva potoki kotorue ispolzyyt odny i tuze blokirovky writeL blokiryytsa
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                writeL.lock();
//                System.out.println("0");
//                while (true);
//            }
//        }).start();
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                writeL.lock();
//                System.out.println("1");
//                while (true);
//            }
//        }).start();

//--------------------------------------------------------------------------------------------------------------------

        // 3) A zdes pokazano chto tri potoki kotorue ispolzyyt dve blokirovky reidL a dryhyiy
        // blokirovky writeL, oni blokiryytsa mezdy soboi.
        // Tobto zavisit ot toho kotorui potok zaxvatit snachala blokirovky. Esli snachala
        // zaxvatit blokirovky potok kotorui delaet readL to vupolniatsa 2 potoka kotorue delayt readL a
        // potok kotorui delaet writeL on zablokiryetsa.
        // I na oborot esli potok writeL zaxvatit snachala blokirovky to dva potoki readL budut zablokirovanu.

////        new Thread(new Runnable() {          // W
////            @Override
////            public void run() {
////                writeL.lock();
////                System.out.println("3");
////                while (true);
////            }
////        }).start();
//
//        new Thread(new Runnable() {          // R
//            @Override
//            public void run() {
//                readL.lock();
//                System.out.println("0");
//                while (true);
//            }
//        }).start();
//
//        new Thread(new Runnable() {          // R
//            @Override
//            public void run() {
//                readL.lock();
//                System.out.println("1");
//                while (true);
//            }
//        }).start();
//
//        new Thread(new Runnable() {          // W
//            @Override
//            public void run() {
//                writeL.lock();
//                System.out.println("2");
//                while (true);
//            }
//        }).start();

//--------------------------------------------------------------------------------------------------------------------

        new Thread(new Runnable() {          // R
            @Override
            public void run() {
                readL.lock();
                System.out.println("0");
                while (true) ;
            }
        }).start();

        new Thread(new Runnable() {          // W
            @Override
            public void run() {
                writeL.lock();
                System.out.println("2");
                while (true) ;
            }
        }).start();

        new Thread(new Runnable() {          // R
            @Override
            public void run() {
                readL.lock();
                System.out.println("1");
                while (true) ;
            }
        }).start();

//--------------------------------------------------------------------------------------------------------------------
    }

}
