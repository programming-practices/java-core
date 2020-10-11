package others.pereduvutus;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NaboruSimvolov {
    public static void main(String[] args) {

        //  Specialnue simvolu  ]\\^- mezdy skobkami []  ??????????????????????
//        Pattern p = Pattern.compile("[A-Z]");
//        Pattern p = Pattern.compile("[a-c]");
//        Pattern p = Pattern.compile("[0-9]");
//        Pattern p = Pattern.compile("[%&(%£%_+*]");
//        Pattern p = Pattern.compile("gr[ea]tamanoMediano");             // Wozmoznoe napisanie poraznomy slov grey gray
//        Pattern p = Pattern.compile("q[^u]");               // Otrisanie bukv v etom prinmere posle q ne dolzno stoyat u
//        Pattern p = Pattern.compile("[+*]");                // +* Ne yavlayetsa specialnum simvolom v vnutri []
//        Pattern p = Pattern.compile("[^tamanoPequenio]");                // Vse naxodit krome tamanoPequenio
//        Pattern p = Pattern.compile("[x^]");                //  Specialnui simvol ^ yze ne rabotaet, on vosprenimaetsa kak prostoi simvol
//        Pattern p = Pattern.compile("[]]");                 // Etot simvol ] vosprinimaytsa kak prostii simvol v nytri []
//        Pattern p = Pattern.compile("[\\^]");               //  Zdes specialnui simvoll ^ zaekranirovanuii \\^
//        Pattern p = Pattern.compile("[^]");                 //  Tak budet owibka
//        Pattern p = Pattern.compile("[[x[]");               // A etot simvolu nevosprinimaytsa kak prostie [ v nytri []   OWIBKA
//        Pattern p = Pattern.compile("[-x]");                // Etot simvol - vosprinimaytsa kak prostii simvol v nytri []
//        Pattern p1 = Pattern.compile("[x-]");                // Etot simvol - vosprinimaytsa kak prostii simvol v nytri []
//        Pattern p = Pattern.compile("[-]");                 // Etot simvol - vosprinimaytsa kak prostii simvol v nytri []
//        Pattern p = Pattern.compile("[a-x]");               // A v takom kontekste on  vosprinimaetsya kak spec simvol
//        Pattern p = Pattern.compile("[\\\\]");              // Tak mozno za ekranirovat simvol \
//        Pattern p = Pattern.compile("[\\Q[-]=-+^*\\E]");    // Sochetanie \\Q... \\E  ktoroe naxoditsa v skobkax[] ekranirye vse wto nasoditsa vnytri nix
//        Pattern p = Pattern.compile("[\\s]");               // Etot simvol \s iwchit vse probelu i tabulacii
//        Pattern p = Pattern.compile("[ \t]");               //  Ischit vse probelu
//        Pattern p = Pattern.compile("[\\s\\d]");            //  Ischit vse probelu i cifru
//        Pattern p = Pattern.compile("\\s\\d");              //  Ischit vse wto sootvetstvyet probely i cifre vmeste
//        Pattern p = Pattern.compile("\\D\\S");              //  Naidot vse wto yhodno
//        Pattern p = Pattern.compile("[0-9]+");              //  Priklad 222 3 4 5 vivod 222  3  4  5
//        Pattern p = Pattern.compile("[0-9]*");              //  Priklad 222 3 4 5 vivod 222  3  4  5   i vivedet vse probelu
        Pattern p = Pattern.compile("[0-9]");               //  Priklad 222 3 4 5 vivod 2  2  2  3  4  5


        //     \d  sootvetstvyet  [0-9]
        //     \w  sootvetstvyet  [a-zA-Z0-9 ]
        //     \s  sootvetstvyet  [ \t]     \s  \t  Eti simvolu oboznachayt probel ili tabylaciy

        //     \D  sootvetstvyet  [^d]       Vivedet vse znaki krome cifer
        //     \W  sootvetstvyet  [^w]
        //     \S  sootvetstvyet  [^s]


        Matcher m = p.matcher(Class1.s);
        while (m.find()) {
            System.out.print("(" + m.start() + "--" + m.group() + ")" + "  ");
        }
        System.out.println("");

//        Matcher m1 = p1.matcher(Class1.s);
//        while (m1.find()){
//            System.out.print("(" + m1.start() + "--" + m1.group() + ")" + "  ");
//        }
//        System.out.println("");
    }
}
