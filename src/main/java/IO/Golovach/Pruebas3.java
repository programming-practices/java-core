package IO.Golovach;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class Pruebas3 {
    public static void main(String[] args) throws UnsupportedEncodingException {

//        String str1 = new String(new char[]{0xFF6E});
//        System.out.println(str1);

        String str = "ｮ";  // 0xFF6E
        System.out.println(str.charAt(0));
        System.out.println(Arrays.toString(str.getBytes("UTF-8")));
        System.out.println(Arrays.toString(str.getBytes("UTF-16BE")));
        System.out.println(Arrays.toString(str.getBytes("UTF-32")));
        System.out.println(Arrays.toString(str.getBytes("KOI8")));
        System.out.println(new String(str.getBytes("KOI8"), "KOI8"));
    }
}
