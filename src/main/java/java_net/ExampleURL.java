package java_net;

import java.net.MalformedURLException;
import java.net.URL;

// Demonstrate URL.
public class ExampleURL {
    public static void main(String args[]) {
//------------------------------------------------------------------------------------------------------------
        URL utlHerbertSchild = null;
        try {
            utlHerbertSchild = new URL("http://www.HerbSchildt.com/WhatsNew");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        System.out.println("Protocol: " + utlHerbertSchild.getProtocol());
        System.out.println("Port: " + utlHerbertSchild.getPort());
        System.out.println("Host: " + utlHerbertSchild.getHost());
        System.out.println("File: " + utlHerbertSchild.getFile());
        System.out.println("Ext:" + utlHerbertSchild.toExternalForm());
//--------------------------------------------------------------------------------------------------------------
        try {
            URL urlDens = new URL("http://www.yahoo.com");
            URL urlIP = new URL("http://209.191.93.52");
            System.out.println(urlDens.getRef());
            System.out.println(urlIP.getRef());
            // dolzen vozvrawchat true
            System.out.println(urlDens.equals(urlIP)); // nado posmotret pochemy ne vozvrawchaet true
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
//--------------------------------------------------------------------------------------------------------------
    }
}
