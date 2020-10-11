package others.pereduvutus;

public class PerevodSimvolovVCifruINaoborot {
    public static void main(String[] args) {

        char ch = '5';
        int valueIncorrect = ch;
        System.out.println("valueIncorrect = " + valueIncorrect);

        int valueCorrect = ch - '0';
        System.out.println("valueCorrect = " + valueCorrect);

        int value = 5;
        char c = (char) value;
        System.out.println("valueInCorrect char c = " + c);

        c = (char) (value + '0');
        System.out.println("valueCorrect char c = " + c);
    }
}
