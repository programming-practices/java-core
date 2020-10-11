package Examples.String_API._String;

import java.util.Arrays;

public class ExampleStringGetChars {
    public static void main(String args[]) {
        String s = "This is age demo of the getChars method.";
        int start = 10;
        int end = 14;
        char buf[] = new char[end - start];

        s.getChars(start, end, buf, 0);
        System.out.println(Arrays.toString(buf));

        char[] buf2 = new char[10];
        s.getChars(start, end, buf2, 3);
        System.out.println(Arrays.toString(buf2));

        char[] buf3 = new char[5];
        System.out.println(Arrays.toString(buf3));
    }
}

