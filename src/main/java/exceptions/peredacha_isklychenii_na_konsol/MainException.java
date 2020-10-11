package exceptions.peredacha_isklychenii_na_konsol;

import java.io.FileInputStream;

public class MainException {
    // Pass all exceptions to the console:
    public static void main(String[] args) throws Exception {
        // Open the file:
        FileInputStream file =
                new FileInputStream("MainException.java");
        // Use the file ...
        // Close the file:
        file.close();
    }
}
