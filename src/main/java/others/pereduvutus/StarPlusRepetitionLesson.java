package YouTube_Channels.Yroki_Java_YouTube.java_util_regex_Pattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StarPlusRepetitionLesson {
    public static void main(String[] args) {

//        Pattern p = Pattern.compile("<[A-Za-z][A-Za-z0-9]*");
//        Matcher m = p.matcher("<h1>");
//        Matcher m = p.matcher("<a>");
//
//        while (m.find()){
//            System.out.print("(" + m.start() + " - " + m.group() + ")" + "  ");
//        }
//        System.out.println("");


//        Pattern p = Pattern.compile("\\protectedVariable[1-9][0-9]{3}\\protectedVariable");
////        Pattern p = Pattern.compile("\\protectedVariable[1-9][0-9]{2,4}\\protectedVariable");
////        Matcher m = p.matcher("100 99999");
//        Matcher m = p.matcher("1000 9999 33333");
//
//        while (m.find()){
//            System.out.print("(" + m.start() + " - " + m.group() + ")" + "  ");
//        }
//        System.out.println("");


////        Pattern p = Pattern.compile("<.+>");
//        Pattern p = Pattern.compile("<.+?>");
////        Pattern p = Pattern.compile("<[^>]+>");
//        Matcher m = p.matcher("This is a <EM>first</EM> test");
//
//        while (m.find()){
//            System.out.print("(" + m.start() + "-" + m.group() + ")" + "  ");
//        }
//        System.out.println("");
//

//        Pattern p = Pattern.compile("\\Q*\\d+*\\E+?");
        Pattern p = Pattern.compile("\\Q*\\d+\\E*+");
//        Pattern p = Pattern.compile("(?:\\Q*\\d+*\\E)+");
        Matcher m = p.matcher("*\\d+**\\d+*");
        while (m.find()) {
            System.out.print("(" + m.start() + " - " + m.group() + ")" + "  ");
        }
        System.out.println("");


    }


}
