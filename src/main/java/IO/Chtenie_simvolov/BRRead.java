package IO.Chtenie_simvolov;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Use age BufferedReader to read characters from the console.

public class BRRead {
    public static void main(String args[]) throws IOException {

        char c;
//        String s;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter characters, 'q' to quit.");

        // read characters
        do {
            c = (char) br.read();
//            s =  br.readLine();
            System.out.println(c);
//            System.out.println(s);
        } while (c != 'q');
//        } while(!"exit".equals(s));
    }
}
