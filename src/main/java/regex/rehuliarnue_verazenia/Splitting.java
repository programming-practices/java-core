package regex.rehuliarnue_verazenia;

import java.util.Arrays;

public class Splitting {
    public static String knights =
            "Then, when you have found the shrubbery, you must " +
                    "cut down the mightiest tree in the forest ... " +
                    "with... a herring!";

    public static void split(String regex) {
        System.out.println(Arrays.toString(knights.split(regex)));
    }

    public static void main(String[] args) {
        System.out.println(Splitting.knights);
        System.out.println();
        split(" "); // Doesn't have to contain regex chars
        System.out.println();
        split("\\W+"); // Non-word characters
        System.out.println();
        split("n\\W+"); // 'n' followed by non-word characters
    }
}
