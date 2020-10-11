package YouTube_Channels.Yroki_Java_YouTube.java_util_regex_Pattern;

public class NameCapturingGroup {
    public static void main(String[] args) {

//        System.out.println("abc".replaceAll("(?<Aletter>a)", "${Aletter}-"));   //  (?Pruebas<neme>group)     (?Pruebas=name)


//        Pattern p = Pattern.compile("<(?<tag>[A-Z][A-Z0-9]*)[^>]*>.*?</\\k<tag>>");                    // V nytri [] vso prostie simvolu. (a)protectedVariable\1 eto vso prostie simvolu
//        Matcher m = p.matcher("Testing <B><I>bold italic</I></B> text");
//        while (m.find()){
//            System.out.print("(" + m.start() + " - " + m.group() + ")" + "  ");
//        }
//        System.out.println("");


        System.out.println("abcd".replaceAll("(a)(?<x>b)(c)(?<y>d)", "$1$2$3$4"));
        System.out.println("abcd".replaceAll("(a)(?<x>b)(c)(?<y>d)", "$1${tamanoPequenio}$3${tamanoMediano}"));
    }
}
