package stringAPI._string;

public class ExampleStringToCharArray {
    public static void main(String[] args) {
        String s = "1+(5-2*(13/6))";
        char[] chars = s.toCharArray();
        for (char value : chars) {
            System.out.println("--" + value + "--");
        }
    }
}
