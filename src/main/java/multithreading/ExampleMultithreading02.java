package Examples.Multithreading;

public class ExampleMultithreading02 {
    static int valueNotVolatile = 0;
    static volatile int valueVolatile = 0;

    // Specificacia java hovorit  esli pole "runNotVolatile" ne volatile to prohrama ne obiwchaet
    // rabotat corectno, no mozet rabotat i korektno .
    static boolean runNotVolatile = true;

    // Specificacion java hovorit esli pole "runVolatile" volatile to programa obezatelno ostanovitsa
    static volatile boolean runVolatile = true;

    public static void main(String[] args) throws InterruptedException {

        // JMM java memory model
        // JVM zaverwaet raboty ne tohda kohda zaverwaetsa metod main,
        // a tohda kohda vse potoki kotorue sozdal metod main (potoki kotorue ne demonu)zakonchat
        // raboty.
        // No eslli ostalis tolko potoki demonu to JVM zaverwaet raboty tohda kohda zaverwaetsa
        // metod main i JVM ybivaet vse potoki demonu.

        // Esli potok demon i ot neho nasledyytsa to, ynasledovanui potok toze bydet demon.

//---------------------------------------------------------------------------------------------------------------------

//        Thread thread00 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (runNotVolatile) ;  // 0...infinity
//            }
//        });
//
//        // esli etot potok demon to eho ybiet JVM tohda kohda maverwitsa method main,
//        // i eta prohrama ne povisnet.
//        thread00.setDaemon(true);
//
//        // Vse eti metodu set...() dolznu iti pered metodom thread00.start():
//        // setDaemon(), setName(), setPriority(), setContextClassLoader(), setUncaughtExceptionHandler();
//        // No esli oni bydyt iti posle metoda stat() to bydet isklychenie java.lang.IllegalThreadStateException
//
//        thread00.start();

//---------------------------------------------------------------------------------------------------------------------

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
////                while (runNotVolatile);  // 0...infinity
//                // esli peremenna ne volatil to kompilator mozet ee soptemezirovat i zdelat tak
//                while (true);  // 0...infinity
//                // potomy chto "runNotVolatle" = true , i compelator prosto zameschaet "runNotVolatle" na true
//            }
//        }).start();
//
//        // Esli peremennaia ne volatil to compilator mozet ee ybrat, dlia optemizacii coda
//        runNotVolatile = false;
//        // no esli ya ee bydy sechas chitat ili chtoto delat s neii  to compelator ee ne mozet ybrat
////        System.out.println(runNotVolatile);


//---------------------------------------------------------------------------------------------------------------------

        // Peremennue volatile delayt happend before

        Thread thread02 = new Thread(new Runnable() {
            @Override
            public void run() {
                // a zdes while(runVolatile) tormozit thread02 i threadMain yspevaet
                // izmenit znachenia peremennux do toho vremeni kak thread02 zaxochit ix napichatat
//                while (runVolatile);

                // zdes nado bit ostoroznum potomy chto thred02 obhonit treadMein,
                // i vuvodit znachenia peremennux do toho kak peremennue izmeniat svoiio znachenie
                System.out.println(runVolatile);
                System.out.println(valueNotVolatile);
            }
        });
        thread02.start();  // mne kazetsa zdes toze proisxodit heppend before

        // Esli ya zdes izmeny znachenie peremennoi "valueNotVolatile" to
        // izmennonnoe znachenie pravelno otobrazitsa v System.out.println() v drygom potoke
        // potomy chto zdes proisxodit heppends before
        Thread.sleep(1000); // eto delaetsa dlia toho chtob zamedlit potok mein
        valueNotVolatile = 1;

        runVolatile = false;  // heppends before

////      No esli ya zdes izmeny znachenie peremennoi "valueNotVolatile" to
////      izmennonnoe znachenie ne pravelno otobrazitsa  v System.out.println() v drygom potoke
////      potomy chto zdes posle runVolatile ne proisxodit heppends before
//        Thread.sleep(1000);  // eto delaetsa dlia toho chtob zamedlit potok mein
//        valueNotVolatile = 3;


//---------------------------------------------------------------------------------------------------------------------
    }
}
