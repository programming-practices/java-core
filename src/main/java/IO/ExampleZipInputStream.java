package IO;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ExampleZipInputStream {
    public static void main(String[] args) throws FileNotFoundException {
        InputStream inputStream = new BufferedInputStream(new FileInputStream(new File("src/main/resources/IO/alice30.txt")));
        File fileDestination = new File("src/main/resources/IO/fileDestination.txt");
        File fileDestination2 = new File("");
        unzip(inputStream, fileDestination, false);
    }

    private static void unzip(InputStream inputStream, File destination, boolean overwrite) {
        try {
            byte[] buf = new byte[1024];
            ZipInputStream zipInputStream = null;
            ZipEntry zipEntry;
            zipInputStream = new ZipInputStream(inputStream);

            zipEntry = zipInputStream.getNextEntry();
            while (zipEntry != null) {
                int n;
                FileOutputStream fileoutputstream;
                File newFile = new File(destination, zipEntry.getName());
                if (zipEntry.isDirectory()) {
                    newFile.mkdirs();
                    zipEntry = zipInputStream.getNextEntry();
                    continue;
                }

//                if (newFile.exists() && overwrite) {
//                    log.info("Overwriting " + newFile);
//                    newFile.delete();
//                }

                fileoutputstream = new FileOutputStream(newFile);

                while ((n = zipInputStream.read(buf, 0, 1024)) > -1) {
                    fileoutputstream.write(buf, 0, n);
                }

                fileoutputstream.close();
                zipInputStream.closeEntry();
                zipEntry = zipInputStream.getNextEntry();

            }

            zipInputStream.close();
        } catch (Exception e) {
            throw new IllegalStateException("Can't unzip input stream", e);
        }
    }
}
