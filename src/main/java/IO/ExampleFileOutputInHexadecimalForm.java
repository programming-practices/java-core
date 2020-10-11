package IO;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExampleFileOutputInHexadecimalForm {
    public static void main(String[] args) throws Exception {
        if (args.length == 0)
            // tem.Test by displaying this class file:
            System.out.println(
                    format(BinaryFile.read("target/classes/IO/ExampleFileOutputInHexadecimalForm.class")));
        else
            System.out.println(
                    format(BinaryFile.read(new File(args[0]))));
    }

    public static String format(byte[] data) {
        StringBuilder result = new StringBuilder();
        int n = 0;
        for (byte b : data) {
            if (n % 16 == 0)
                result.append(String.format("%05X: ", n));
            result.append(String.format("%02X ", b));
            n++;
            if (n % 16 == 0) result.append("\n");
        }
        result.append("\n");
        return result.toString();
    }
}

class BinaryFile {

    public static byte[] read(File bFile) throws IOException {
        BufferedInputStream bf = new BufferedInputStream(new FileInputStream(bFile));

        try {
            byte[] data = new byte[bf.available()];
            bf.read(data);
            return data;
        } finally {
            bf.close();
        }
    }

    public static byte[] read(String bFile) throws IOException {
        return read(new File(bFile).getAbsoluteFile());
    }
}