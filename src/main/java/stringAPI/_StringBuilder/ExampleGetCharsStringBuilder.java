package Examples.String_API._StringBuilder;

import java.util.Arrays;

public class ExampleGetCharsStringBuilder {
    public static void main(String[] args) {
//----------------------------------------------------------------------------------------------------------------------

        StringBuilder sb = new StringBuilder("123456789");
        System.out.println(sb);
        int start = 1;
        int end = 3;
        char[] chars = new char[3 - 1];
        sb.getChars(1, 3, chars, 0);
        System.out.println(Arrays.toString(chars));

//----------------------------------------------------------------------------------------------------------------------


//----------------------------------------------------------------------------------------------------------------------
    }
}
