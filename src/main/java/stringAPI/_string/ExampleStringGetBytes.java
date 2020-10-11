package Examples.String_API._String;

import java.util.Arrays;

public class ExampleStringGetBytes {
    public static void main(String[] args) {
        String s = "This is age demo of the getChars method.";
        int start = 0;
        int end = 8;
        byte[] bytes = new byte[end - start];

        s.getBytes(start, end, bytes, 0);
        System.out.println(Arrays.toString(bytes));

        String str = new String(bytes);
        System.out.println(str);
    }
}
