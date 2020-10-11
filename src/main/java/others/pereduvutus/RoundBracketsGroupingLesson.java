package YouTube_Channels.Yroki_Java_YouTube.java_util_regex_Pattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RoundBracketsGroupingLesson {
    public static void main(String[] args) {

//        Pattern p = Pattern.compile("Set(?:Value)?");
//        Pattern p = Pattern.compile("Set(Value)?");
//        Matcher m = p.matcher("Set or SetValue");
//        while (m.find()){
//            System.out.print("(" + m.start() + " - " + m.group() + ")" + "  ");
//        }
//        System.out.println("");


//        Pattern p = Pattern.compile("EditPad (Lite|Pro)");
//        Matcher m = p.matcher("EditPad Lite version");
//        while (m.find()){
//            System.out.print("(" + m.start() + " - " + m.group() + ")" + "  ");
//        }
//        System.out.println("");


//        System.out.println("EditPad Lite".replaceAll("EditPad (Lite|Pro)", "$1 version"));
//        System.out.println("EditPad Lite".replaceAll("EditPad (Lite|Pro)", "$0 version"));
//        System.out.println("EditPad Lite".replaceAll("EditPad (Lite|Pro)", "\\U1 version").toUpperCase());       //   Java nepidtrumye cei sintacsis \\U1
//        System.out.println("EditPad Lite".replaceAll("EditPad (Lite|Pro)", "\\L1 version").toLowerCase());       //   Java nepidtrumye cei sintacsis \\L1
//        System.out.println("EditPad Lite".replaceAll("EditPad (Lite|Pro)", "\\F1 version"));                     //   FirstLetter uppcase.  Java nepidtrumye cei sintacsis \\F1
//        System.out.println("EditPad Lite".replaceAll("EditPad (Lite|Pro)", "\\I1 version"));                     //   Each letter.  Java nepidtrumye cei sintacsis \\I1


//
//        Pattern p = Pattern.compile("<([A-Z][A-Z0-9]*)[^>]*>*?</\\1>");
//        Matcher m = p.matcher("This is a <EM>first</EM> test");
//        while (m.find()){
//            System.out.print("(" + m.start() + " - " + m.group() + ")" + "  ");
//        }
//        System.out.println("");


//        Pattern p = Pattern.compile("([a-c])tamanoPequenio\\1tamanoPequenio\\1");       //   [a-c]tamanoPequenio[a-c]tamanoPequenio[a-c]
//        Matcher m = p.matcher("axaxa");
//        while (m.find()){
//            System.out.print("(" + m.start() + " - " + m.group() + ")" + "  ");
//        }
//        System.out.println("");


//        Pattern p = Pattern.compile("([a-c]\\1)");       //   ERROR !!!!!!!!!!!!!!
//        Matcher m = p.matcher("axaxa");
//        while (m.find()){
//            System.out.print("(" + m.start() + " - " + m.group() + ")" + "  ");
//        }
//        System.out.println("");


//        Pattern p = Pattern.compile("([A-Z][A-Z0-9]*)[^>]*>.*?</\\1>");
//        Matcher m = p.matcher("Testing <B><I>bold italic</I></B> text");
//        while (m.find()){
//            System.out.print("(" + m.start() + " - " + m.group() + ")" + "  ");
//        }
//        System.out.println("");

//
//        Pattern p = Pattern.compile("([abc]+)");       //   cab       esli potom obrawchatsa cherez \\1 to budet  cab
////        Pattern p = Pattern.compile("([abc])+");       //   protectedVariable       esli potom obrawchatsa cherez \\1 to budet  protectedVariable
//        Matcher m = p.matcher("cab");
//        while (m.find()){
//            System.out.print("(" + m.start() + " - " + m.group() + ")" + "  ");
//        }
//        System.out.println("");


////        Pattern p = Pattern.compile("([abc]+)=\\1");
//        Pattern p = Pattern.compile("([abc])+=\\1");
////        Matcher m = p.matcher("cab=cab");
////        Matcher m = p.matcher("cab=protectedVariable");
//        Matcher m = p.matcher("protectedVariable=protectedVariable");
//        while (m.find()){
//            System.out.print("(" + m.start() + " - " + m.group() + ")" + "  ");
//        }
//        System.out.println("");


//        System.out.println("the the".replaceAll("\\protectedVariable(\\w+)\\s+\\1\\protectedVariable", "$1"));


        Pattern p = Pattern.compile("[(a)b\1]");                    // V nytri [] vso prostie simvolu. (a)protectedVariable\1 eto vso prostie simvolu
        Matcher m = p.matcher("abc()\\1");
        while (m.find()) {
            System.out.print("(" + m.start() + " - " + m.group() + ")" + "  ");
        }
        System.out.println("");
    }
}
