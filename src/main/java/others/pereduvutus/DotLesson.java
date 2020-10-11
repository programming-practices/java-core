package others.pereduvutus;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DotLesson {
    public static void main(String[] args) {

        //  .  oboznachat lyboi simvol krome perenosa stroki


//        Pattern p = Pattern.compile("\\d\\d.\\d\\d.\\d\\d");               // Zses mezdy ciframi mohyt bit lybie simvolu
//        Pattern p = Pattern.compile("\\d\\d[-./]\\d\\d[-./]\\d\\d");       // Zses mezdy ciframi mohyt bit tolko simvolu -./
//        Pattern p = Pattern.compile("[0-3]\\d[-./][0-1]\\d[-./]\\d\\d");
//        Pattern p = Pattern.compile("\".*\"");                              //  Naxodit kavicki ""  v etom slychai naidot kavichki i  towto v nix naxoditsa   !!!!! zadnii operator
        Pattern p = Pattern.compile("\".*?\"");                              //   !!!!!!!   nezadnii operator    !!!!!!
//        Pattern p = Pattern.compile("\"[^\"\n]*\"");


        Matcher m = p.matcher(Class1.s);
        while (m.find()) {
            System.out.print("(" + m.start() + " - " + m.group() + ")" + "  ");
        }
        System.out.println("");
    }
}
