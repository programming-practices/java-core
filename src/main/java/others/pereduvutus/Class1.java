package others.pereduvutus;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Class1 {
    static String s = "abc This island is beautiful 40.50.99 2222 + Then, when  10w03%90 grey 7 you qu ! % & ( ) _ + } 10403490  { [ ] ' @ # ~ ; : ? / . > , < " +
            " £ $ cathave - \\ abc ^ found the 10.08.48 [] shrubbery 1+1=2 cats 6 _ pacific4@mail.com," +
            " * you tamanoPequenio 10-03-90  must 0 cut down cat the \"strig one\" mightie8st 10/03/90  q tree in gray the forest..9.with... a herring!" +
            "Q W E R T Y U I O Pruebas A S D F G H J K L Z X C V B N ClassNaslednikVNePackage q \"strig two\"  w e r t tamanoMediano u i " +
            "o p a s d fArgInt threeTuple fourTuple j fiveTuple l tamanoGrande tamanoPequenio c v protectedVariable n m 1 2 3 4 5 6 7 8 9 0    c";


    public static void main(String[] args) {


//        System.out.println("dlake4da@mail.com".matches("\\protectedVariable[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-tamanoGrande]{2,4}\\protectedVariable"));
        Pattern p = Pattern.compile("\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}\\b");
//        Matcher m = p.matcher("Jack is a boy");
        Matcher m = p.matcher(s);

        while (m.find()) {
            System.out.print("(" + m.start() + "-" + m.group() + ")" + "  ");
        }
        System.out.println("");
    }


}
