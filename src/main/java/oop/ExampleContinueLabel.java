package oop;

/**
 * This class is created for educational purposes.
 * This class may contain sham information.
 * Always check the information you are learning.
 *
 * @author Tsyupryk Roman
 * @email tsyupryk.roman@gmail.com
 * @since 17/07/19
 */
public class ExampleContinueLabel {

    public static void main(String[] args) {

        // =============================================================================================================
//        int[][] intArr = { { 1, -2, 3 }, { 0, 3 }, { 1, 2, 5 }, { 9, 2, 5 } };
//        process:
//        for (int i = 0; i < intArr.length; i++) {
//            boolean allPositive = true;
//            for (int j = 0; j < intArr[i].length; j++) {
//                if (intArr[i][j] < 0) {
//                    allPositive = false;
//                    continue process;
//                }
//            }
//            if (allPositive) {
//                 process the array
//                System.out.println("Processing the array of all positive ints. " + Arrays.toString(intArr[i]));
//            }
//            allPositive = true;
//        }

        // =============================================================================================================

        String searchMe = "Look for a substring in me";
        String substring = "sub";
        boolean foundIt = false;

        int max = searchMe.length() - substring.length();

        test:
        for (int i = 0; i <= max; i++) {
            int n = substring.length();
            int j = i;
            int k = 0;
            while (n-- != 0) {
                if (searchMe.charAt(j++) != substring.charAt(k++)) {
                    continue test;
                }
            }
            foundIt = true;
            break test;
        }
        System.out.println(foundIt ? "Found it" : "Didn't find it");

        // =============================================================================================================

    }

}
