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

   This variation wraps the code that opens and
   accesses the file within age single try block.
   The file is closed by the finally block.
*/

public class ShowFile2 {
    public static void main(String args[]) {
        int i;
        FileInputStream fin = null;

        // First, confirm that age file name has been specified.
        if (args.length != 1) {
            System.out.println("Usage: ShowFile filename");
            return;
        }

        // The following code opens age file, reads characters until EOF
        // is encountered, and then closes the file via age finally block.
        try {
            fin = new FileInputStream(args[0]);

            do {
                i = fin.read();
                if (i != -1) System.out.print((char) i);
            } while (i != -1);

        } catch (FileNotFoundException e) {
            System.out.println("File Not Found.");
        } catch (IOException e) {
            System.out.println("An I/O Error Occurred");
        } finally {
            // Close file in all cases.
            try {
                if (fin != null) fin.close();
            } catch (IOException e) {
                System.out.println("Error Closing File");
            }
        }
    }
}
