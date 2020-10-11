package IO;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class ExampleInputStreamReader {
    public static void main(String[] args) throws IOException {
//--------------------------------------------------------------------------------------------------------------------
//        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
//--------------------------------------------------------------------------------------------------------------------
        StringBuilder buffer;
        try (InputStreamReader inputStreamReader1 = new InputStreamReader(
                new FileInputStream("/home/dtrl/GitHub/LearnJava/core/src/main/resources/IO/alice30.txt"), StandardCharsets.UTF_8)) {
//                new FileInputStream("src/main/resources/IO/Prueba1.txt"), StandardCharsets.UTF_8);
            buffer = new StringBuilder();
            char tmp = 0;
            while ((tmp = (char) inputStreamReader1.read()) != -1 && tmp != '\uFFFF') {
                // ostorozno s etim simvolom '\uFFFF'(na danui moment ne znay chto eto za simvol)
                //            if (tmp == '\uFFFF'){ break; }
                buffer.append(tmp);
            }
        }
        System.out.println(buffer);
////--------------------------------------------------------------------------------------------------------------------
//        char dd = '\uFFFF';
//        System.out.println("|" + dd + "|");
//
//        char[] dd = "\uFFFF".toCharArray();
//        String s = new String(dd);
//        System.out.println("|" + dd + "|");
//        System.out.println("|" + s + "|");
//--------------------------------------------------------------------------------------------------------------------

//--------------------------------------------------------------------------------------------------------------------
    }
}
