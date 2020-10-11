package java_lang;


// Timing program execution.
public class ExampleSystemCurrentTimeMills {
    public static void main(String args[]) {
//---------------------------------------------------------------------------------------------------------------------

        long start, end;

        System.out.println("Timing lettersOfTheAlphabet for loop from 0 to 100,000,000");

        // time lettersOfTheAlphabet for loop from 0 to 100,000,000
        start = System.currentTimeMillis(); // get starting time
        for (long i = 0; i < 100000000L; i++) ;
        end = System.currentTimeMillis(); // get ending time

        System.out.println("Elapsed time: " + (end - start));

//---------------------------------------------------------------------------------------------------------------------

        System.out.println();
        long startNano, endNano;
        startNano = System.nanoTime(); // get starting nano time
        for (long i = 0; i < 100000000L; i++) ;
        endNano = System.nanoTime(); // get ending nano time

        System.out.println("Elapsed nano time: " + (endNano - startNano));

//---------------------------------------------------------------------------------------------------------------------
    }
}

