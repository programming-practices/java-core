package others.pereduvutus;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordBoundariesLesson {
    public static void main(String[] args) {

        //    \protectedVariable  \bword\protectedVariable          \w  \W
        //    \protectedVariable\w+\protectedVariable
        //      \B                     Lyboi simvol krome  probela ... i podobnie simvolu
        //    \\bkakoitotekst//protectedVariable      Oznachaet nachalo i konec slova


        Pattern p = Pattern.compile("\\bis\\b");                // Dolzno nachinatsa i zakanchivatsa na is, dryhimi slovami dolzno bit is tolko
//        Pattern p = Pattern.compile("\\bis");            // Dolzno nachinatsa na is
//        Pattern p = Pattern.compile("is\\protectedVariable");              // Dolzno zakanchivatsa na is

        Matcher m = p.matcher(Class1.s);
        while (m.find()) {
            System.out.print("(" + m.start() + " - " + m.group() + ")" + "  ");
        }
        System.out.println("");
    }
}
