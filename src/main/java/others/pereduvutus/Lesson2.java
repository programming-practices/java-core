package YouTube_Channels.Olimpiadnoe_prohramirovanie_s_nulia_na_Java._51_Simvolu_i_stroki_v_Java_Chast_2;

import java.util.Arrays;

public class Lesson2 {
    public static void main(String[] args) {
//----------------------------------------------------------------------------------------------------------------------

        String s = "abc";
        System.out.println("s = " + s);
        String t = s;
        System.out.println("s = " + s + "  t = " + t);
        s += "qqqq";   // Toze ne presvaevaet v ty ze samyy ssulky, prisvaivaet v drygyiy ssulky
        System.out.println("s = " + s);
        s = "ccc";
        System.out.println("s = " + s);
        System.out.println("s = " + s + "  t = " + t);

//----------------------------------------------------------------------------------------------------------------------

        System.out.println();
        StringBuilder sbA = new StringBuilder("www");
        StringBuilder sbB = sbA;
        System.out.println("sbA = " + sbA + "     sbB = " + sbB);
        sbA.append(123);
        System.out.println("sbA = " + sbA + "     sbB = " + sbB);
        sbB.append("9999");
        System.out.println("sbA = " + sbA + "     sbB = " + sbB);

//----------------------------------------------------------------------------------------------------------------------

        String[] arrayStr = new String[5];
        String str = "Hola";
        int lengthArray = arrayStr.length;
        int lengthStr = str.length();


//----------------------------------------------------------------------------------------------------------------------

        String str2 = "aaaaa";
        String strReplace = str2.replace("aa", "ba");
        System.out.println(strReplace);

//----------------------------------------------------------------------------------------------------------------------

        String str3 = "abc";
        String str4 = "ac";
        String str5 = "ab";
        String str6 = "abc";
        System.out.println("\"abc\".compareTo(\"ac\") -->  " + str3.compareTo(str4));
        System.out.println("\"abc\".compareTo(\"ab\") -->   " + str3.compareTo(str5));
        System.out.println("\"abc\".compareTo(\"abc\") -->  " + str3.compareTo(str6));
        // S chislami nado bit ostoroznim. Nado snachalo provirat a dlinu stroki esli stroki
        // ravnue po dline to sravnivat ix s compareTo(). A esli odna s strok menwe po dline
        // to srazy ee vevodit kak menwyy.
        System.out.println();
        System.out.println("\"1230\".compareTo(\"523\") -->  " + "1230".compareTo("523"));
        System.out.println("\"1230\".compareTo(\"5231\") -->  " + "1230".compareTo("5231"));

//----------------------------------------------------------------------------------------------------------------------

        String[] arrayStr2 = {"aa", "ab", "lk", "nne", "ae", "bee", "ze", "cae", "aaaaze"};
        Arrays.sort(arrayStr2);
        System.out.println(Arrays.toString(arrayStr2));

//----------------------------------------------------------------------------------------------------------------------

    }
}
