package multithreading;

public class ExampleMultithreading00 {
    static int valueNotVolatiel = 0;
    static volatile int valueVolatiel = 0;
    static volatile boolean run = true;
    static boolean runNotVolatile = true;
    static volatile boolean runA = true;
    static volatile boolean runB = true;
    static Object objA = new Object();
    static Object objB = new Object();

    public synchronized static boolean isRunNotVolatile() {
        return runNotVolatile;
    }

    public synchronized static void setRunNotVolatile(boolean value) {
        runNotVolatile = value;
    }

    public static void main(String[] args) throws InterruptedException {

        // Esli potok "x" vuzovet y potoka "y" "y.start()" to mezdu startom "x.start" i startom "y.start" est suncronized whise

        // tobto potok "y" yvidet vse izmenenia kotorue zdelal potok "x"

//---------------------------------------------------------------------------------------------------------------------

//        new Thread(new Runnable() {
//            int i = 0;
//            @Override
//            public void run() {
//                while (run){
//                    i++;
//                }
//                System.out.println(i);
//            }
//        }).start();
////        Thread.sleep(1);
//        run = false;

//---------------------------------------------------------------------------------------------------------------------

//        value = 1;
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(value);
//            }
//        }).start();
//        value = 2;

//---------------------------------------------------------------------------------------------------------------------

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (run);
//                System.out.println(value);
//            }
//        }).start();
//        Thread.sleep(100);
//        run = false;
//        // tak ploxo net xepenbifo
//        value = 2;

//---------------------------------------------------------------------------------------------------------------------


//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (run);
//                System.out.println(value);
//            }
//        }).start();
//        Thread.sleep(100);
//        // a zdea est xependbifo
//        value = 2;
//        run = false;

//---------------------------------------------------------------------------------------------------------------------

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (true){
//                    boolean b = runB;
//                    System.out.println(value);
//                }
//            }
//        }).start();
//
//        value = 2;
//        runA = false;

//---------------------------------------------------------------------------------------------------------------------

//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                // esli tak ya delay to programa visnet, potomu chto
//                // value naxoditsa v kewe i ne meniaet svoiio snachenie,
//                // no esli value zdelat volatile to programa ne po povisnet
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
////                valueNotVolatiel = 1;
//                valueVolatiel = 1;
//            }
//        }).start();
//
////        while (valueNotVolatiel == 0);
//        while (valueVolatiel == 0);

//---------------------------------------------------------------------------------------------------------------------

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) { e.printStackTrace(); }
//
//                // tak programa ne visnet
////                run = false;
//
//                // a tak visnet
//                runNotVolatile = false;
//            }
//        }).start();
////        while (run);
//        while (runNotVolatile);

//---------------------------------------------------------------------------------------------------------------------
//        // syncronized whisd
//
//        Thread thread01 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) { e.printStackTrace(); }
//
//                runNotVolatile = false;
//            }
//        });
//        thread01.start();
//
//        // a v etom premere programa ne visnet potomy chto
//        // deistvuet hependbifo v etoi stroke while (thread01.isAlive());
//        // i toze thread01.join() bydet delat hependbifo
//        while (thread01.isAlive());
//        thread01.join();
////        thread01.run();
////        while (runNotVolatile);

//---------------------------------------------------------------------------------------------------------------------

//        // syncronized whisd
//
//        Thread thread01 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                // Sincronized bloki ili  metodu  delayt Heppens before.
//                // Toest esli odin potok zaxvachivaet syncronized i delaet kakie to izmenenia
//                // to posle toho kak on otpustet suncronzed blok ili metod bydyt vidnu vse zdelanue izmenenia
//                // dryhomy potoky kotorui zaxvatit suncronized blok ili method
//                synchronized (obj){
//                    runNotVolatile = false;
//                }
//            }
//        });
//        thread01.start();
//
//        while (true){
//            synchronized (obj){
//                System.out.println(runNotVolatile);
//            }
//        }

//---------------------------------------------------------------------------------------------------------------------
//        // syncronized whisd
//
//        // Analog prohramu kotorai prevoditsa vuwe
//
//        // Esli ybrat xotib odin suncronized iz metodov setRunNotVolatile() ili isRunNotVolatile() to
//        // prohrama ne obiwchaet rabotat korektno, mozet povisnyt
//        Thread thread01 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                setRunNotVolatile(false);
//            }
//        });
//        thread01.start();
//
//        while (isRunNotVolatile()){
//            System.out.println(isRunNotVolatile());
//        }

//---------------------------------------------------------------------------------------------------------------------

        // Chtobu bul efekt Heppends before v suncronized blokax ili metodax
        // oni dolzni but suncronizirovanumi na odnom obiekte ili na tom samom klase,
        // y nix dolzen bit odin i totze monitor

        Thread thread01 = new Thread(new Runnable() {
            @Override
            public void run() {
                // mezd etimi blokami suncronized nety Heppends before
                synchronized (objA) {
                    runNotVolatile = false;
                }
            }
        });
        thread01.start();

        while (runNotVolatile) {
            // mezd etimi blokami suncronized nety Heppends before
            synchronized (objB) {
                System.out.println(runNotVolatile);
            }
        }

        // Eta prohrama neoboviazana rabotat korektno  !!!!!!

//---------------------------------------------------------------------------------------------------------------------
    }
}
