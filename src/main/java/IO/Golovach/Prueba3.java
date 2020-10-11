package IO.Golovach;

import java.io.UnsupportedEncodingException;

public class Prueba3 {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String s = new String(new byte[]{70, 71, 72}, "ASCII");
        char[] chars1 = {2, 127, 13};
        char[] chars = s.toCharArray();
        System.out.println(chars[0]);
        System.out.println(chars[1]);
        System.out.println(chars[2]);
        System.out.println();
        System.out.println(chars1[0]);
        System.out.println(chars1[1]);
        System.out.println(chars1[2]);

    }

}
