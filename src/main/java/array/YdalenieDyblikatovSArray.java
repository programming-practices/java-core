package array;

import java.util.Arrays;

public class YdalenieDyblikatovSArray {
    public static void main(String[] args) {
        final int[] arg = new int[14];
        arg[0] = 3;
        arg[1] = 5;
        arg[2] = 1;
        arg[3] = 0;
        arg[4] = 7;
        arg[5] = 8;
        arg[6] = 9;
        arg[7] = 2;
        arg[8] = 3;
        arg[9] = 4;
        arg[10] = 5;
        arg[11] = 8;
        arg[12] = 2;
        arg[13] = 2;

        System.out.println(Arrays.toString(arg));

        int[] result = deletValues(arg, 2);
        System.out.println(Arrays.toString(result));
        System.out.println(Arrays.toString(arg));
    }

    /**
     * Etot method polychaet array kopiryet eho i iz copii arraya ydalaet vse znachenia kotorue ravnu deletValue,
     * originalnui arra ne izmeniaetsa.
     */
    public static int[] deletValues(final int[] array, int deletValues) {
        int[] tmp = Arrays.copyOf(array, array.length);
        for (int i = 0; i < tmp.length; i++) {
            if (tmp[i] == deletValues) {
                tmp[i] = 0;
            }
        }
        return tmp;
    }
}
