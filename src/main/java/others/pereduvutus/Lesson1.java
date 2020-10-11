package YouTube_Channels.Olimpiadnoe_prohramirovanie_s_nulia_na_Java._50_Simvolu_i_stroki_v_Java_Chast_1;

import java.util.Scanner;

public class Lesson1 {
    public static void main(String[] args) {
//---------------------------------------------------------------------------------------------------------------------

        int a = 3;
        int b;
        b = a;
        a = 5;
//        System.out.println(b);

//---------------------------------------------------------------------------------------------------------------------

        int[] arrayA = new int[10];
        arrayA[0] = 6;
        int[] arrayB;
        arrayB = arrayA;
        arrayA[1] = 234;
//        System.out.println(Arrays.toString(arrayA));
//        System.out.println(Arrays.toString(arrayB));

//---------------------------------------------------------------------------------------------------------------------

        String str = "aaa";
        String str2;
        str2 = str;
        str = "rrrrrrr";
//        System.out.println(str2);

        // String ssulochnui tip, ale vin zroblenui "not mutable".
        // Wchob String byv poxozui na primitivnui tip (ce luw moia dymka).

//---------------------------------------------------------------------------------------------------------------------

        String s = "";
        String s1 = "a";
        String s2 = "abc";
//        String s3 = 'a';        // ERROR
        String s4 = "" + 'a';   // Not error
        String s5 = " ' \' \\  \n  \t   \b   \"   x";     //  Specialnue simvolu v nytri stroki
        //    "\r\n"  vukorustovvyetsa v sustemax windows
//        String s6 = "abc\rd\nf";
//        System.out.println(s6);

//---------------------------------------------------------------------------------------------------------------------

        Scanner in = new Scanner(System.in);
        in.next();   //  Chitaet sledyewchee "slovo" okryzennoe "probelami" simvolami
        in.nextLine();     //Chitaet sledyewcoy stroky do "perevoda stroki"
        in.hasNext();    // Est li sledyewchie "slovo"
        in.hasNextLine();   // Est li sledyewchaia "stroka"
//        in.useDelimiter(":");     // Zamiwchenie probela etim simvolom :
        in.useDelimiter(":|\\s+");
        String str3 = in.next();
        System.out.println(str3);

//---------------------------------------------------------------------------------------------------------------------
    }
}
