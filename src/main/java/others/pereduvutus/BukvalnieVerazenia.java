package others.pereduvutus;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BukvalnieVerazenia {
    public static void main(String[] args) {

        Pattern p = Pattern.compile("cat");
//        Pattern p = Pattern.compile("1\\+1=2");            //  znak \\ ekranirye znak +
//        Pattern p = Pattern.compile("\\Q1+1=2\\E");         //  \\Q.....\\E  ekraniryetsya vse wto vnytri nix


        Matcher m = p.matcher(Class1.s);
        while (m.find()) {
            System.out.print("(" + m.start() + "-" + m.group() + ")" + "  ");
        }
        System.out.println("");
    }
}
