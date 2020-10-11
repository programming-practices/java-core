package array;

import java.util.Arrays;

public class MergeTwoArrays {

    public static void main(String[] args) {

        int[] argsA = {1, 3, 4, 10};
        int[] argsB = {2, 11, 12, 13, 14};
        System.out.println(Arrays.toString(merge(argsA, argsB)));

        int[] argsA2 = {2, 11, 12, 13, 14};
        int[] argsB2 = {1, 3, 4, 10};
        System.out.println(Arrays.toString(merge(argsA2, argsB2)));

        int[] argsA3 = {1, 3, 5, 7};
        int[] argsB3 = {0, 2, 4, 6, 8};
        System.out.println(Arrays.toString(merge(argsA3, argsB3)));

        int[] argsA4 = {3, 3};
        int[] argsB4 = {3, 3};
        System.out.println(Arrays.toString(merge(argsA4, argsB4)));

        int[] argsA5 = {3, 3};
        int[] argsB5 = {1, 2};
        System.out.println(Arrays.toString(merge(argsA5, argsB5)));

    }

    public static int[] merge(int[] argsA, int[] argsB) {
        //TODO terminar los tests de este methodo, y pensar que hacer si algun de los parametros es null o ambos
        int[] result = new int[argsA.length + argsB.length];

        int aIndex = 0;
        int bIndex = 0;

        if (argsA.length == 0 && argsB.length == 0) {
            return new int[0];
        }

        if (argsA.length == 0 && argsB.length != 0) {
            return Arrays.copyOf(argsB, argsB.length);
        }
        if (argsA.length != 0 && argsB.length == 0) {
            return Arrays.copyOf(argsA, argsA.length);
        }

        while (aIndex + bIndex != result.length) {

            if (argsA[aIndex] <= argsB[bIndex]) {

                if (aIndex == argsA.length - 1) {

                    if (bIndex == argsB.length - 1) {
                        result[aIndex + bIndex] = argsA[aIndex];
                        result[aIndex + bIndex + 1] = argsB[bIndex];
                        return result;
                    }
                    result[aIndex + bIndex] = argsA[aIndex];
                    System.arraycopy(argsB, bIndex, result, aIndex + bIndex + 1, aIndex + bIndex);
                    return result;
                }
                result[aIndex + bIndex] = argsA[aIndex++];
            } else {

                if (bIndex == argsB.length - 1) {

                    if (aIndex == argsA.length - 1) {
                        result[aIndex + bIndex] = argsB[bIndex];
                        result[aIndex + bIndex + 1] = argsA[aIndex];
                        return result;
                    }
                    result[aIndex + bIndex] = argsB[bIndex];
                    System.arraycopy(argsA, aIndex, result, aIndex + bIndex + 1, aIndex + bIndex);

                    return result;
                }
                result[aIndex + bIndex] = argsB[bIndex++];
            }
        }
        return result;
    }
}
