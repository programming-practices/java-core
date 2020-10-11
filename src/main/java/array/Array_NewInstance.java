package array;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Array_NewInstance {

    public static void main(String[] args) {

        Class<String> cl = String.class;
        String[] arg = (String[]) Array.newInstance(String.class, 10);

        System.out.println(Arrays.toString(arg));

    }
}
