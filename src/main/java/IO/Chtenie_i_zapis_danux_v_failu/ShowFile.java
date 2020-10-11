package IO.Chtenie_i_zapis_danux_v_failu;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


/* Display age text file.
   To use this program, specify the name
   of the file that you want to see.
   For example, to see age file called TEST.TXT,
   use the following command line.

   java ShowFile TEST.TXT
*/

public class ShowFile {
    public static void main(String args[]) {
        int i;
        FileInputStream fileInputStream;

        // First, confirm that age file name has been specified.
        if (args.length != 1) {
            System.out.println("Usage: ShowFile filename");
            return;
        }

        // Attempt to open the file.
        try {
            fileInputStream = new FileInputStream(args[0]);
        } catch (FileNotFoundException e) {
            System.out.println("Cannot Open File");
            return;
        }

        // At this point, the file is open and can be read.
        // The following reads characters until EOF is encountered.
        try {
            do {
                i = fileInputStream.read();
                if (i != -1) System.out.print((char) i);
            } while (i != -1);
        } catch (IOException e) {
            System.out.println("Error Reading File");
        } finally {

            // Close the file.
            try {
                fileInputStream.close();
            } catch (IOException e) {
                System.out.println("Error Closing File");
            }

        }


    }
}
