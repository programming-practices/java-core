package IO;

import java.io.*;

public class Pruebas {
    public static void main(String[] args) throws IOException {

        String nameFileSourse = "src/main/resources/ExampleSourse.txt";
        String nameFileDestination = "src/main/resources/ExampleDestination.txt";

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             FileWriter fw = new FileWriter(nameFileSourse)) {

            String read = br.readLine();
            fw.write(read);
        }

        try (FileReader fr = new FileReader(nameFileSourse);
             FileWriter fw = new FileWriter(nameFileDestination)) {

            char[] data;
            while (true) {
                int read1 = fr.read();
                if (read1 == -1) return;
                fw.write((char) read1);
            }
        }


    }
}
