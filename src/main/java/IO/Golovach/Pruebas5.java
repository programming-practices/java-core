package IO.Golovach;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class Pruebas5 {
    public static void main(String[] args) throws IOException {

//        InputStream src = new URL("https://google.com").openStream();
//        OutputStream dest = new FileOutputStream("/home/dtrl/Datos/GOOGLE.txt");

        InputStream src = new URL("https://www.youtube.com/watch?v=rARIzzCAZUw&list=PLoij6udfBnchhzsjZkAbhW-V1K5dM-_Xf&index=2").openStream();
        OutputStream dest = new FileOutputStream("/home/dtrl/Datos/YOUTUBE.txt");

//        InputStream src = new URL("http://dom2.ru").openStream();
//        OutputStream dest = new FileOutputStream("/home/dtrl/Datos/dom2.txt");
        copy(src, System.out);

    }

    public static void copy(InputStream src, OutputStream dest) throws IOException {
        byte[] byff = new byte[64 * 1024];
        while (true) {
            int data = src.read();
            if (data != -1) {
                dest.write(data);
            } else {
                return;
            }
        }
    }

}
