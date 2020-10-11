package others;

public class DifferentTestsCode {
    public static void main(String[] args) {

        char[] arg = "Hello World!".toCharArray();
        char[] tmp = new char[arg.length];

        for (int i = 0; i < arg.length; i++) {
            tmp[i] = arg[arg.length - 1 - i];
        }
        System.out.println(tmp);
    }
}
