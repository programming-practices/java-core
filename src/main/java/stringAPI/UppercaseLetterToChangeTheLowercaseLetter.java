package stringAPI;

public class UppercaseLetterToChangeTheLowercaseLetter {
    public static void main(String[] args) {

        char x = 'x';
        char X = 'A' + ('x' - 'a');
        System.out.println("x = " + x + " X = " + X);

        char M = 'M';
        char m = (char) ((M - 'A') + 'a');
        System.out.println();
        System.out.println("M = " + M + " m = " + m);

        // Robet toze
        char a = 'a';
        char A = 'A' + ('a' - 'a');
        System.out.println();
        System.out.println("a = " + a + " A = " + A);


    }
}
