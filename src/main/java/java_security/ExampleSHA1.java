package java_security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

// Sources: https://www.youtube.com/watch?v=epX1k_kCT9s
public class ExampleSHA1 {
    public static void main(String[] args) throws NoSuchAlgorithmException {

        String value = "Hello World!!!";
        MessageDigest sha1 = MessageDigest.getInstance("SHA-1");
        StringBuilder sb = new StringBuilder();
        byte[] result = sha1.digest(value.getBytes());
        for (byte b : result) sb.append(String.format("%02X ", b));
        System.out.println(sb);
    }
}
