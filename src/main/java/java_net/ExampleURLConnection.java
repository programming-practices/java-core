package java_net;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

// Demonstrate URLConnection.
public class ExampleURLConnection {
    public static void main(String[] args) {
        try {
            int c;
            URL urlInternicNet = new URL("http://www.internic.net");
//            URL urlInternicNet = new URL("http://www.google.com");
//            URL urlInternicNet = new URL("http://www.facebook.com");
            URLConnection urlConnection = urlInternicNet.openConnection();

            // get date
            long valueDouble = urlConnection.getDate();
            if (valueDouble == 0)
                System.out.println("No date information.");
            else
                System.out.println("Date: " + new Date(valueDouble));

            // get content type
            System.out.println("Content-Type: " + urlConnection.getContentType());

            // get expiration date
            valueDouble = urlConnection.getExpiration();
            if (valueDouble == 0)
                System.out.println("No expiration information.");
            else
                System.out.println("Expires: " + new Date(valueDouble));

            // get last-modified date
            valueDouble = urlConnection.getLastModified();
            if (valueDouble == 0)
                System.out.println("No last-modified information.");
            else
                System.out.println("Last-Modified: " + new Date(valueDouble));

            // get content length
            long len = urlConnection.getContentLengthLong();
            if (len == -1)
                System.out.println("Content length unavailable.");
            else
                System.out.println("Content-Length: " + len);

            if (len != 0) {
                System.out.println("=== Content ===");
                InputStream input = urlConnection.getInputStream();

                while (((c = input.read()) != -1)) {
                    System.out.print((char) c);
                }
                input.close();

            } else {
                System.out.println("No content available.");
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
