package tem;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {

        int[] A = {1, 3, 6, 4, 1, 2};    // 5

        solution(A);
    }

    public static int solution(int[] A) {
        // write your code in Java SE 8
        Arrays.sort(A);

        int maxValue = A[A.length - 1];

//        System.out.println(maxValue);

        for (int i = A[0]; i < maxValue; i++) {

        }

        return 0;
    }
}


