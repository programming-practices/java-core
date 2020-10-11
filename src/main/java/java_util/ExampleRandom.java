package java_util;

import java.util.Random;

public class ExampleRandom {
    public static void main(String[] args) {
//---------------------------------------------------------------------------------------------------------------------
        // Demonstrate random Gaussian values.
        Random random = new Random();
        double val;
        double sum = 0;
        int bell[] = new int[10];

        for (int i = 0; i < 100; i++) {
            val = random.nextGaussian();
            sum += val;
            double t = -2;
            for (int x = 0; x < 10; x++, t += 0.5)
                if (val < t) {
                    bell[x]++;
                    break;
                }
        }
//        System.out.println("Average of values: " + (sum/100));

        // display bell curve, sideways
//        for(int i=0; i<10; i++) {
//            for(int x=bell[i]; x>0; x--) System.out.print("*");
//            System.out.println();
//        }
//---------------------------------------------------------------------------------------------------------------------
        Random random1 = new Random(47);
        for (int i = 0; i < 10; i++) {
            System.out.print(random.nextInt(100) + ", ");
        }
//---------------------------------------------------------------------------------------------------------------------

    }
}

/*
-----------------------------------------------------------------------------------------------------------------------
• IntStream ints()
• IntStream ints(int randomNumberOrigin, int randomNumberBound) 8
• IntStream ints(long streamSize) 8
• IntStream ints(long streamSize, int randomNumberOrigin, int randomNumberBound) 8
• LongStream longs() 8
• LongS tream longs (long randomNumberOrigin, long randomNumberBound) 8
• LongStream longs(long streamSize) 8
• LongS tream longs(long streamSize, long randomNumberOrigin, long randomNumberBound) 8
• DoubleStream doubles () 8
• DoubleStream doubles (double randomNumberOrigin, double randomNumberBound) 8
• DoubleStream doubles (long streamSize) 8
• DoubleStream doubles (long streamSize, double randomNumberOrigin, double randomNumberBound) 8
    Возвращают потоки произвольных чисел. Если указан аргумент streamSize, возвращается конечный поток с заданным количеством
    элементов. Если же предоставлены границы, то возвращается поток с элементами в пределах от randomNumberOrigin (включительно)
    до randomNumberBound(isklychitelno).
-----------------------------------------------------------------------------------------------------------------------
*/