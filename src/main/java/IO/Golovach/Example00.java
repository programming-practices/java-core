package IO.Golovach;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class Example00 {
    public static void main(String[] args) throws IOException {

        URL url = new URL("https://google.com");
        InputStream inURL = url.openStream();

        URL url2 = new URL("http://schema.org/WebPage");
        InputStream inURL2 = url.openStream();

        InputStream inFile = new FileInputStream("/root/Datos/Programacion/studies_a_programing/src/main/resources/Example.txt");
        InputStream inFile2 = new FileInputStream("/var/log/auth.log");

        System.out.println("------------inFile---------------");
        copyToConsole(inFile);
        System.out.println("------------inFile2---------------");
        copyToConsole(inFile2);
        System.out.println("------------inURL-----------------");
        copyToConsole(inURL);
        System.out.println("------------inURL2-----------------");
        copyToConsole(inURL2);
    }


    public static void copyToConsole(InputStream inputStream) {
        try {

//            for (int i = inputStream.read(); i != -1;) { }
            int read;
            while ((read = inputStream.read()) != -1) {
                System.out.print((char) read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
