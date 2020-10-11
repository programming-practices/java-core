package array;

import java.util.Arrays;

/**
 * This program shows how to store tabular data in a 2D array.
 */
public class Array2D {
    public static void main(String[] args) {
// ---------------------------------------------------------------------------------------------------------------------
        final double STARTRATE = 10;
        final int NRATES = 6;
        final int NYEARS = 10;

        // set interest rates to 10 . . . 15%
        double[] interestRate = new double[NRATES];
        for (int j = 0; j < interestRate.length; j++)
            interestRate[j] = (STARTRATE + j) / 100.0;

        double[][] balances = new double[NYEARS][NRATES];

        // set initial balances to 10000
        for (int j = 0; j < balances[0].length; j++)
            balances[0][j] = 10000;

        // compute interest for future years
        for (int i = 1; i < balances.length; i++) {
            for (int j = 0; j < balances[i].length; j++) {
                // get last year's balances from previous row
                double oldBalance = balances[i - 1][j];

                // compute interest
                double interest = oldBalance * interestRate[j];

                // compute this year's balances
                balances[i][j] = oldBalance + interest;
            }
        }

        // print one row of interest rates
        for (int j = 0; j < interestRate.length; j++)
            System.out.printf("%9.0f%%", 100 * interestRate[j]);

        System.out.println();

        // print balance table
        for (double[] row : balances) {
            // print table row
            for (double b : row)
                System.out.printf("%10.2f", b);

            System.out.println();
        }

// ---------------------------------------------------------------------------------------------------------------------
        int[][] matirnxA = new int[2][3];
        matirnxA[0][0] = 1;
        matirnxA[0][1] = -2;
        matirnxA[0][2] = 3;
        matirnxA[1][0] = 4;
        matirnxA[1][1] = 1;
        matirnxA[1][2] = 7;

//        for (int i = 0; i < matirnxA.length; i++) {     // idom po storkam
//            for (int j = 0; j < matirnxA[i].length; j++) {      // idom po stolbcam
//                System.out.print(matirnxA[i][j] + "\t");
//            }
//            System.out.println();
//        }
// ---------------------------------------------------------------------------------------------------------------------
        int[][] a = new int[5][5];
        int[][][] b = new int[3][4][5];
        int[][][][] c = new int[2][4][5][5];

        int[][] a1 = new int[5][];
        a1[0] = new int[1];
        a1[1] = new int[2];
        a1[2] = new int[3];
        a1[3] = new int[4];
        a1[4] = new int[5];
//        for (int i = 0; i < java.a1.length; i++) {
//            for (int j = 0; j < java.a1[i].length; j++) {
//                System.out.print(java.a1[i][j] + " ");
//            }
//            System.out.println();
//        }
// ---------------------------------------------------------------------------------------------------------------------
        int[][] array2D = new int[3][3];
        array2D[0][0] = 1;
        array2D[0][1] = 2;
        array2D[0][2] = 3;
        array2D[1][0] = 4;
        array2D[1][1] = 5;
        array2D[1][2] = 6;
        array2D[2][0] = 7;
        array2D[2][1] = 8;
        array2D[2][2] = 9;
        for (int i = 0; i < array2D.length; i++) {
            for (int j = 0; j < array2D[i].length; j++) {
                System.out.print(array2D[i][j] + "\t");
            }
            System.out.println();
        }

        for (int i = 0; i < array2D.length; i++) {
            System.out.println("min = " + Arrays.stream(array2D[i]).min().getAsInt() +
                    " max = " + Arrays.stream(array2D[i]).max().getAsInt());
        }
// ---------------------------------------------------------------------------------------------------------------------
        /*int[][] r = new int[2][5];

        r[0][0] = 1;
        r[0][1] = 2;
        r[0][2] = 3;
        r[0][3] = 4;
        r[0][4] = 5;

        r[1][0] = 6;
        r[1][1] = 7;
        r[1][2] = 8;
        r[1][3] = 9;
        r[1][4] = 10;

        int[] rr [] = new int[2][5];

        rr[0][0] = 1;
        rr[0][1] = 2;
        rr[0][2] = 3;
        rr[0][3] = 4;
        rr[0][4] = 5;

        rr[1][0] = 6;
        rr[1][1] = 7;
        rr[1][2] = 8;
        rr[1][3] = 9;
        rr[1][4] = 10;

        System.out.println(Arrays.deepToString(r));
        System.out.println();
        System.out.println(Arrays.deepToString(rr));
        System.out.println(rr[0][4]);
        System.out.println(rr[1][3]);*/

        int[][] r = new int[2][5];

        r[0][0] = 1;
        r[0][1] = 2;
        r[0][2] = 3;
        r[0][3] = 4;
        r[0][4] = 5;

        r[1][0] = 6;
        r[1][1] = 7;
        r[1][2] = 8;
        r[1][3] = 9;
        r[1][4] = 10;

        int[][] r2 = new int[2][3];
        r[0] = new int[10];
        r[1] = new int[10];

        int[][][] r3 = new int[2][3][4];
        r[0] = new int[10];
        r[1] = new int[10];

        int[] x[], t;
        t = new int[2];
//        t = new int[2][3];
        x = new int[2][];

        int[][] x2, t2;
        t = new int[2];
//        t = new int[2][2];
        x = new int[2][];
// ---------------------------------------------------------------------------------------------------------------------
    }
}
