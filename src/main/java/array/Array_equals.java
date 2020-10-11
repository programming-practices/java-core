package array;

import java.util.Arrays;

/**
 * This class is created for educational purposes.
 * This class may contain sham information.
 * Always check the information you are learning.
 *
 * @author Tsyupryk Roman
 * @email tsyupryk.roman@gmail.com
 * @since 16/07/19
 */
public class Array_equals {

    public static void main(String[] args) {
        int[] argA = new int[3];
        argA[0] = 1;
        argA[1] = 2;
        argA[2] = 3;

        int[] argB = new int[3];
        argB[0] = 1;
        argB[1] = 2;
        argB[2] = 3;

        System.out.println(argA.equals(argB));
        System.out.println(Arrays.equals(argA, argB));

    }

}
