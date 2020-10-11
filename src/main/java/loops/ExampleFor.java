package loops;

public class ExampleFor {
    public static void main(String[] args) {
//======================================================================================================================
//=============================================== Ordinary cycle =======================================================
//======================================================================================================================
        // Increase on one
//        for (int i = 0; i < 10; i++) {
//            System.out.print(i + ", ");
//        }

        // Increase on two
//        for (int i = 0; i < 10; i = i+2) {
//            System.out.print(i + ", ");
//        }

        // Increase on two
//        for (int i = 0; i < 10; i += 2) {
//            System.out.print(i + ", ");
//        }

        // Index 'i' multiplication on two
//        for (int i = 1; i < 50; i = i*2) {
//            System.out.print(i + ", ");
//        }

        // Index 'i' division on two
//        for (int i = 100; i > 1; i = i/2) {
//            System.out.print(i + ", ");
//        }

//======================================================================================================================
//=============================================== Reverse cycle =======================================================
//======================================================================================================================

        // The index decreases by one
//        for (int i = 9; i > 0; i--) {
//            System.out.print(i + ", ");
//        }

        // The index decreases by two
//        for (int i = 10; i > 0; i -= 2) {
//            System.out.print(i + ", ");
//        }

//======================================================================================================================
//==================================== Using a loop for a two-dimensional array ========================================
//======================================================================================================================

        /* Output: (0, 0)(0, 1)(0, 2)(0, 3)(0, 4)
                   (1, 0)(1, 1)(1, 2)(1, 3)(1, 4)
                   (2, 0)(2, 1)(2, 2)(2, 3)(2, 4)
                   (3, 0)(3, 1)(3, 2)(3, 3)(3, 4)
                   (4, 0)(4, 1)(4, 2)(4, 3)(4, 4)
         */
//        for (int i = 0; i < 5; i++) {
//            for (int d = 0; d < 5; d++) {
//                System.out.print("(" + i + ", " + d + ")");
//            }
//            System.out.println();
//        }


         /* Output: ----+
                    ---++
                    --+++
                    -++++
                    +++++
         */
//        for (int i = 0; i < 5; i++) {
//            for (int d = 0; d < 5; d++) {
//                System.out.print((i + d > 3) ? "+" : "-");
//            }
//            System.out.println();
//        }


        /* Output: -----
                   +----
                   ++---
                   +++--
                   ++++-
         */
//        for (int i = 0; i < 5; i++) {
//            for (int d = 0; d < 5; d++) {
//                System.out.print((i > d) ? "+" : "-");
//            }
//            System.out.println();
//        }


        int[] array_A = {0, 10, 20, 30, 40};
        /* Interesting array output
           Output: 0 10 20 30 40
                   0 10 20 30
                   0 10 20
                   0 10
                   0
         */
//        for (int i = array_A.length - 1; i >= 0; i--) {
//            for (int j = 0; j <= i; j++) {
//                System.out.print(array_A[j] + " ");
//            }
//            System.out.println();
//        }


        /* Interesting array output:
           Output: 40
                   40 30
                   40 30 20
                   40 30 20 10
                   40 30 20 10 0
        */
//        for (int i = array_A.length - 1; i >= 0; i--) {
//            for (int j = array_A.length - 1; j >= i; j--) {
//                System.out.print(array_A[j] + " ");
//            }
//            System.out.println();
//        }


        /* Interesting array output:
           Output: 40 30 20 10 0
                   30 20 10 0
                   20 10 0
                   10 0
                   0
        */
//        for (int i = array_A.length - 1; i >= 0; i--) {
//            for (int j = i; j >= 0; j--) {
//                System.out.print(array_A[j] + " ");
//            }
//            System.out.println();
//        }


        /*  Interesting array output
           Output: 0
                   0 10
                   0 10 20
                   0 10 20 30
                   0 10 20 30 40
         */
//        for (int i = 0; i < array_A.length; i++) {
//            for (int j = 0; j <= i; j++) {
//                System.out.print(array_A[j] + " ");
//            }
//            System.out.println();
//        }

//======================================================================================================================
//=================================== Using a loop for a three-dimensional array =======================================
//======================================================================================================================

//        for (int i = 0; i < 5; i++) {
//            for (int j = 0; j < 5; j++) {
//                for (int d = 0; d < 5; d++) {
//                    System.out.print("(" + i + ", " + ", " + d + ")");
//                }
//                System.out.println();
//            }
//            System.out.println();
//        }

//======================================================================================================================
//================================== Number with a decimal value in the condition ======================================
//======================================================================================================================

        // ATTENTION! Be careful when checking the equality of two floating point numbers in a for().
        // The loop below may not complete at all.
        double goldWeight = 10.0;
        for (double i = 0; i != goldWeight; i += 0.1) {
//            System.out.println(i);
            if (i > 10.1) {
                break;
            }
        }
        // Due to a rounding error, the number will not be received.
        // Variable 'goldWeight' will change its value from 9.999999999999998 immediately to 10.099999999999998.
        // variable 'x' will change its value from 9.999999999999998 immediately to 10.099999999999998.
        // Because for the number 0.1 there is no exact binary representation.

        // This loop works without problems.
        for (double i = 0; i < 10.0; i += 0.1) {
//            System.out.println(i);
            if (i > 10.1) {
                break;
            }
        }


//======================================================================================================================
//======================================================================================================================
//======================================================================================================================


//======================================================================================================================
//=============================================== Bad loop usage =======================================================
//======================================================================================================================

        /*
            Such solutions for cycle use cannot be used in programming, because they are very difficult to read.
            This code is only for the sake of knowing that you can write a loop
        */


        // This loop is endless
        // This for() like to while(true)
//        for (; ; ) {
//            System.out.println("A");
//        }

        // Bad usage decrement
//        for (int i = 0; i < 10; i++) {    // i equal 0 because i++
//            System.out.print(i + ", ");   // i equal 0
//            i--;                          // i equal -1 because i--
//            System.out.println(i);        // i equal -1
//        }

        // One more example.
//        int i = 0;
//        for (; i < 10; i++) {
//            System.out.println(i + ", ");
//        }

        // This loop works without problems.
        // But this loop will not stop, that the exit condition is always equal 'true'
//        for (int i = 0; true; i++) {
//            System.out.println(i + ", ");
//        }

        // This loop works without problems.
        // But this loop will not stop, that the index does not increase.
//        for (int i = 0; i < 10;) {
//            System.out.println(i + ", ");
//        }

//========================== So you can use a loop, but these are VERY BAD decisions for use.
        // These five loop implementations do the same job:
        // 1.
//        for (int i = 0; i < 10; i++) {
//            System.out.print(i + ", ");
//        }

        // 2.
//        for (int i = 0; i < 10; ) {
//            System.out.print(i + ", ");
//            i++;
//        }

        // 3.
//        for (int i = 0; ; ) {
//            if (i < 10) {
//                System.out.print(i + ", ");
//                i++;
//            } else {
//                break;
//            }
//        }

        // 4.
//        int i = 0;
//        for (;;) {
//            if (i < 10) {
//                System.out.print(i + ", ");
//                i++;
//            } else {
//                break;
//            }
//        }

        // 5.
//        int k = 0;
//        while (true) {
//            if (k < 10) {
//                System.out.print(k + ", ");
//                k++;
//            } else {
//                break;
//            }
//        }

//======================================================================================================================
//======================================================================================================================
//======================================================================================================================

    }
}

/*
The for loop loops through a block of code a number of times.

            for(indexInitialization; condition to exit; indexIncrements)

            for (statement 1; statement 2; statement 3) {
                    // code block to be executed
            }
Statement 1 is executed (one time) before the execution of the code block.
Statement 2 defines the condition for executing the code block.
Statement 3 is executed (every time) after the code block has been executed.




*/
