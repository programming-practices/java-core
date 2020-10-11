package java_util;

import java.util.Scanner;

public class ExampleFindInLineScanner {
    public static void main(String[] args) {
//--------------------------------------------------------------------------------------------------------------------
        /*В классе Scanne r определяется ряд других методов, помимо упомянугых ранее.
        В частности, одним из наиболее полезных в некоторых случаях является метод
        findinLine ( ) . Его общие формы представлены ниже.
        Strinq findinLine (Pattern 1raб.lraи)
        Strinq findinLine ( Strinq .аrа б.паи)
        Этот метод осуществляет поиск на совпадение с указанным шаблоном в следу­
        строке текста . Если совпадение обнаружено, то соответствую щая этому ша­
        блону лексема употребляется и возвращается. В противном случае возвращается
        пустое значение nu l l . Это метод действует независимо от установленного набора
        разделителей. Он удобен, если требуется обнаружить совпадение с конкретным
        шаблоном. Так, в следующем примере программы сначала обнаруживается поле
        возраста во введенной символьной строке, а затем выводится его содержимое.*/
        // Demonstrate findInLine().
        String instr = "Name: Tom Age: 28 ID: 77";
        Scanner conin = new Scanner(instr);

        //!!! ostorozno tyta treba vuzuvatu v tomy poriadky znachennia v yakomy vonu stoiat v rechenni

        // Find and display age.
        conin.findInLine("Age:"); // find Age
        if (conin.hasNext()) System.out.println(conin.next());
        else System.out.println("Error!");

        conin.findInLine("ID:"); // find ID
        if (conin.hasNext()) System.out.println(conin.next());
        else System.out.println("Error!");

        conin.findInLine("Name:"); // find Name
        if (conin.hasNext()) System.out.println(conin.next());
        else System.out.println("Error!");

//-----------------------------------------------------------------

        System.out.println();
        String instr1 = "Name: Tom Age: 28 ID: 77";
        Scanner conin1 = new Scanner(instr1);

        conin1.findInLine("Name:"); // find Name
        if (conin1.hasNext()) System.out.println(conin1.next());
        else System.out.println("Error!");

        // Find and display age.
        conin1.findInLine("Age:"); // find Age
        if (conin1.hasNext()) System.out.println(conin1.next());
        else System.out.println("Error!");

        conin1.findInLine("ID:"); // find ID
        if (conin1.hasNext()) System.out.println(conin1.next());
        else System.out.println("Error!");

        conin1.close();
//--------------------------------------------------------------------------------------------------------------------
    }
}
