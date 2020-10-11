package YouTube_Channels.Yroki_Java_YouTube.java_util_regex_Pattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OptionItemsLesson {
    public static void main(String[] args) {
//        Pattern p = Pattern.compile("colou?r");
//        Matcher m = p.matcher("value colour");
//
//        while (m.find()){
//            System.out.print("(" + m.start() + " - " + m.group() + ")" + "  ");
//        }
//        System.out.println("");
//
//        Pattern p = Pattern.compile("Nov(ember)?");
//        Matcher m = p.matcher("November Nov");
//
//        while (m.find()){
//            System.out.print("(" + m.start() + " - " + m.group() + ")" + "  ");
//        }
//        System.out.println("");


        Pattern p = Pattern.compile("Feb(ruary)? 23(rd)?");
        Matcher m = p.matcher("February 23rd, February 23, Feb 23rd, Feb 23");

        while (m.find()) {
            System.out.print("(" + m.start() + " - " + m.group() + ")" + "  ");
        }
        System.out.println("");
    }
}
