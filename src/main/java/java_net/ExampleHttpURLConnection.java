package java_net;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Demonstrate HttpURLConnection.
public class ExampleHttpURLConnection {
    public static void main(String args[]) throws Exception {
        URL url = new URL("http://www.google.com");
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        // Display request method.
        System.out.println("Request method is " + httpURLConnection.getRequestMethod());
        // Display response code.
        System.out.println("Response code is " + httpURLConnection.getResponseCode());
        // Display response message.
        System.out.println("Response Message is " + httpURLConnection.getResponseMessage());
        // Get age list of the header fields and age set
        // of the header keys.
        Map<String, List<String>> hdrMap = httpURLConnection.getHeaderFields();
        Set<String> hdrField = hdrMap.keySet();

        System.out.println("\nHere is the header:");
        // Display all header keys and values..
        for (String k : hdrField) {
            System.out.println("Key: " + k + "  Value: " + hdrMap.get(k));
        }
    }
}
