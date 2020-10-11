package multithreading;

public class ExampleFinalMultithreading {
    static StrNotFinal strNotFinal;  // unsafe publishing
    static volatile StrNotFinal strNotFinalVolatile;  // safe publishing
    static StrFinal strFinal;  // safe publishing

    public static void main(String[] args) {
//---------------------------------------------------------------------------------------------------------------------

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                strNotFinal = new StrNotFinal(new char[]{'H', 'e', 'l', 'l', 'o'}, 0, 5);
//            }
//        }).start();
//
//        while (strNotFinal == null){
//            System.out.println(strNotFinal.value);
//            System.out.println(strNotFinal.off);
//            System.out.println(strNotFinal.leng);
//        }
//
//        // Eta prohrama mozet vivesti NullPointException
//                                //    null, 0, 0
//                                //    null, 0, 5
//                                //    Hello, 0, 0
//                                //    Hello, 0, 5
//                                //    eta prohrama mozet vivesti mnoho owiubochnix dannux

//---------------------------------------------------------------------------------------------------------------------

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                strNotFinal = new StrNotFinal(new char[]{'H', 'e', 'l', 'l', 'o'}, 0, 5);
//            }
//        }).start();
//
//        while (true){
//            StrNotFinal tmp = strNotFinal;
//            if (tmp != null){
//                System.out.println(tmp.value);
//                System.out.println(tmp.off);
//                System.out.println(tmp.leng);
//                break;
//            }
//        }
//        // Eto moia proba, xotel posmotret chto bydet

//---------------------------------------------------------------------------------------------------------------------

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                strFinal = new StrFinal(new char[]{'H', 'e', 'l', 'l', 'o'}, 0, 5);
//            }
//        }).start();
//
//        while (true){   // 0...infinity
//            StrFinal tmp = strFinal;
//            System.out.println(tmp);
//            if (tmp != null){
//                System.out.println(tmp.value);
//                System.out.println(tmp.off);
//                System.out.println(tmp.leng);
//                break;
//            }
//        }

        // eta prohrama dolzna vivesti Hell, 0, 5

//---------------------------------------------------------------------------------------------------------------------
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                strNotFinalVolatile = new StrNotFinal(new char[]{'H', 'e', 'l', 'l', 'o'}, 0, 5);
//            }
//        }).start();
//
//        while (true){
//            StrNotFinal tmp = strNotFinalVolatile;
//            System.out.println(tmp);
//            if (tmp != null){
//                System.out.println(tmp.value);
//                System.out.println(tmp.off);
//                System.out.println(tmp.leng);
//                break;
//            }
//        }

//---------------------------------------------------------------------------------------------------------------------

        new Thread(new Runnable() {
            @Override
            public void run() {
                FinalFieldExample.write();
            }
        }).start();

        FinalFieldExample.reader();


//---------------------------------------------------------------------------------------------------------------------
    }
}

class StrNotFinal {
    char[] value;
    int off;
    int leng;

    public StrNotFinal(char[] value, int off, int leng) {
        this.value = value;
        this.off = off;
        this.leng = leng;
    }
}


class StrFinal {
    final char[] value;
    final int off;
    final int leng;

    public StrFinal(char[] value, int off, int leng) {
        this.value = value;
        this.off = off;
        this.leng = leng;
    }
}

class FinalFieldExample {
    static FinalFieldExample finalFieldExample;
    final int valueFinal;
    int valueNotFinal;

    public FinalFieldExample() {
        this.valueFinal = 3;
        this.valueNotFinal = 4;
    }

    public static void write() {
        finalFieldExample = new FinalFieldExample();
    }

    public static void reader() {
        if (finalFieldExample != null) {
            System.out.println("valueFinal = " + finalFieldExample.valueFinal);
            System.out.println("valueNotFinal = " + finalFieldExample.valueNotFinal);
        }
    }
}