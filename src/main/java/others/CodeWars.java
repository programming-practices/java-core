package others;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class CodeWars {
    /**
     * Map contains in key: character
     * Map contains in value: value of this character
     */
    private static final Map<Character, Integer> map = new HashMap<>();

    public static void main(String[] args) {
// ---------------------------------------------------------------------------------------------------------------------
//        System.out.println(getReverseString("Holla"));
// ---------------------------------------------------------------------------------------------------------------------
        String value = "8 3 -5 42 -1 0 0 -9 4 7 4 -4";
// ---------------------------------------------------------------------------------------------------------------------
//        System.out.println(HighAndLow(value));
// ---------------------------------------------------------------------------------------------------------------------
//        System.out.println(toCamelCase("the_Stealth_Warrior"));
// ---------------------------------------------------------------------------------------------------------------------
//        System.out.println(toJadenCase("How can mirrors be real if our eyes aren't real"));
// ---------------------------------------------------------------------------------------------------------------------
        char a = 'a';
        char b = 'b';
//        System.out.println(0 + a);
//        System.out.println(0 + b);
//        for (int i = 97; i < 123; i++) {
//            System.out.println((char) i);
//        }
//        System.out.println(map);
//        fillMap(map);
//        System.out.println(map);
//        System.out.println(high("what time are we climbing up to the volcano"));
//        System.out.println(high("man i need a taxi up to ubud"));
//        System.out.println(high("take me to semynak"));
        // ---------------------------------------------------------
//        System.out.println(high2("what time are we climbing up to the volcano"));
//        System.out.println(high2("man i need a taxi up to ubud"));
//        System.out.println(high2("take me to semynak"));
// ---------------------------------------------------------------------------------------------------------------------
//        System.out.println(Math.pow(0, 2));
//        System.out.println(squareDigits(9119));
        System.out.println(squareDigits(0));
// ---------------------------------------------------------------------------------------------------------------------
    }

    // ---------------------------------------------------------------------------------------------------------------------
    public static int squareDigits(int n) {
        // TODO Implement me
        String value = String.valueOf(n);
        char[] arrChars = value.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char charValue : arrChars) sb.append((int) Math.pow(Integer.valueOf(charValue + ""), 2));
        return Integer.parseInt(sb.toString());
    }
    // ------------------------------------------------------------

    // ---------------------------------------------------------------------------------------------------------------------
    public static String high2(String s) {
        return Arrays
                .stream(s.split(" "))
                .max(Comparator.comparingInt(a -> a.chars().map(i -> i - 96).sum()))
                .get();
    }

    /**
     * Filling Map with values
     */
    private static void fillMap() {
        int count = 1;
        for (int i = 97; i < 123; i++) {
            map.put(((char) i), count);
            count++;
        }
    }

    public static String high(String str) {
        // Your code here...
        if (str == null || str.isEmpty()) return "";
        fillMap();
        String[] arrStrings = str.split(" ");
        int maxCountForWordsResult = Integer.MIN_VALUE;
        StringBuilder resultValue = new StringBuilder();
        for (int itemStr = 0; itemStr < arrStrings.length; itemStr++) {
            int maxCountForWordsTmp = Integer.MIN_VALUE;
            char[] arrCharTmp = arrStrings[itemStr].trim().toCharArray();
            for (int itemChar = 0; itemChar < arrCharTmp.length; itemChar++) {
                maxCountForWordsTmp += map.get(arrCharTmp[itemChar]);
            }
            if (maxCountForWordsResult < maxCountForWordsTmp) {
                maxCountForWordsResult = maxCountForWordsTmp;
                resultValue.delete(0, resultValue.length());
                resultValue.append(arrStrings[itemStr]);
            }
        }
        return resultValue.toString();
    }

    // ---------------------------------------------------------------------------------------------------------------------
    public static String toJadenCase(String phrase) {
        // TODO put your code below this comment
        if (phrase == null) return "";
        if (phrase.isEmpty()) return "";
        String[] strings = phrase.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String str : strings) {
            if (!str.equals(strings[strings.length - 1])) {
                sb.append(str.substring(0, 1).toUpperCase() + str.substring(1, str.length()) + " ");
            } else {
                sb.append(str.substring(0, 1).toUpperCase() + str.substring(1, str.length()));
            }
        }
        return sb.toString();
    }
// ---------------------------------------------------------------------------------------------------------------------

    /**
     * If @parameter s is null return empty string
     * If @parameter s is isEmpty return empty string
     */
    static String toCamelCase(String s) {
        if (s == null) return "";
        if (s.isEmpty()) return "";
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '-') {
                sb.append(("" + chars[i + 1]).toUpperCase());
                i++;
                continue;
            }
            if (chars[i] == '_') {
                sb.append(("" + chars[i + 1]).toUpperCase());
                i++;
                continue;
            }
            sb.append(chars[i]);
        }
        return sb.toString();
    }

    // ---------------------------------------------------------------------------------------------------------------------
    public static String HighAndLow(String numbers) {
        // Code here or
        String[] argStr = numbers.split(" ");
        int max = Integer.parseInt(argStr[0]);
        int min = Integer.parseInt(argStr[0]);
        for (String str : argStr) {
            max = Math.max(max, Integer.parseInt(str));
            min = Math.min(min, Integer.parseInt(str));
        }
        return max + " " + min;
    }

    // ---------------------------------------------------------------------------------------------------------------------
    public static String getReverseString(String sentence) {
        char[] chars = sentence.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = chars.length - 1; i >= 0; i--) {
            sb.append(chars[i]);
        }
        return sb.toString();
    }
}
