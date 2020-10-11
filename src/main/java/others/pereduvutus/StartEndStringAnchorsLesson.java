package YouTube_Channels.Yroki_Java_YouTube.java_util_regex_Pattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StartEndStringAnchorsLesson {
    public static void main(String[] args) {


//        Pattern p = Pattern.compile("^a");               // Simvol nachala stroki
//        Pattern p = Pattern.compile("^b");
//        Pattern p = Pattern.compile("^c");
//        Pattern p = Pattern.compile("a$");               // Simvol konca stroki
//        Pattern p = Pattern.compile("b$");
//        Pattern p = Pattern.compile("c$");

//
//        Matcher m = p.matcher(Class1.s);
//        while (m.find()){
//            System.out.print("(" + m.start() + " - " + m.group() + ")" + "  ");
//        }
//        System.out.println("");


//        Pattern p1 = Pattern.compile("\\d+");
//        Pattern p1 = Pattern.compile("^\\d+$");                    // Pri pustoi strochki nevudast It's a number   !!!!!!!!!!!
//        Pattern p1 = Pattern.compile("^\\d*$");                     //  Pri pustoi strochki vudast It's a number     !!!!!!!!!!!

//        Matcher m1 = p1.matcher("1234567890");
//        Matcher m1 = p1.matcher(Class1.emptuLine);
//        while (m1.find()){
//            System.out.print("It's a number!!!");
//        }
//        System.out.println("");


//        Matcher m2 = p1.matcher("");
//        while (m2.find()){
////            System.out.print(m2.start());                      // Vidast wto est eta pozicea    OSTOROZNO
//            System.out.print("".charAt(m2.start()));            // Vuidet exception
//        }
//        System.out.println("");

        //  \A    ^             Nachalo stroki
        //  \Z    $             Konez stroki

//        Pattern p = Pattern.compile("ne$");
//        Pattern p = Pattern.compile("ne$",Pattern.MULTILINE);
//        Pattern p = Pattern.compile("\\Ane\\Z",Pattern.MULTILINE);
//        Pattern p = Pattern.compile("ne\\Z",Pattern.MULTILINE);                    //  ????????????????????
//        Pattern p = Pattern.compile("ne\\z",Pattern.MULTILINE);             //   ????????????????????
//
//        Matcher m = p.matcher("First line\n" +
//                "second line\n");
//        while (m.find()){
//            System.out.print("(" + m.start() + " - " + m.group() + ")" + "  ");
//        }
//        System.out.println("");


        Pattern p = Pattern.compile("^4$", Pattern.MULTILINE);             //   ????????????????????

//        Matcher m = p.matcher("749\n486\n4");
        Matcher m = p.matcher("4");
        while (m.find()) {
            System.out.println(m.matches());
        }

//        System.out.println("749\n486\n4".matches("^4$"));

    }
}
