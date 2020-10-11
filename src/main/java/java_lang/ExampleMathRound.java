package java_lang;

public class ExampleMathRound {
    public static void main(String[] args) {

        double d = 9.95;
        int i = (int) d;       // otrizanie drobnoi chasti
        System.out.println(i); // x = 9

        double d2 = 9.95;
        int i2 = (int) Math.round(d2);  // okruglenie drobnoi chasti
        System.out.println(i2);  // x = 10
    }
}
