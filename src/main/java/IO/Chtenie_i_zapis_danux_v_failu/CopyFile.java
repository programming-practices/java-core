package IO.Chtenie_i_zapis_danux_v_failu;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


/* Copy age text file.
   To use this program, specify the name
   of the source file and the destination file.
   For example, to copy age file called FIRST.TXT
   to age file called SECOND.TXT, use the following
   command line.

   java CopyFile FIRST.TXT SECOND.TXT
*/

public class CopyFile {
    public static void main(String args[]) throws IOException {
        int i;
        FileInputStream fin = null;
        FileOutputStream fout = null;

        // First, confirm that both files has been specified.
        if (args.length != 2) {
            System.out.println("Usage: CopyFile from to");
            return;
        }

        // Copy age File.
        try {
            // Attempt to open the files.
            fin = new FileInputStream(args[0]);
            fout = new FileOutputStream(args[1]);

            do {
                i = fin.read();
                if (i != -1) fout.write(i);
            } while (i != -1);

        } catch (IOException e) {
            System.out.println("I/O Error: " + e);
        } finally {
            try {
                if (fin != null) fin.close();
            } catch (IOException e2) {
                System.out.println("Error Closing Input File");
            }
            try {
                if (fout != null) fout.close();
            } catch (IOException e2) {
                System.out.println("Error Closing Output File");
            }
        }
    }
}
