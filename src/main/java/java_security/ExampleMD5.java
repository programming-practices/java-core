package java_security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

// Sources: https://www.youtube.com/watch?v=epX1k_kCT9s
public class ExampleMD5 {
    public static void main(String[] args) throws NoSuchAlgorithmException {

        String value = "Hello World!!!";
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        StringBuilder sb = new StringBuilder();
        byte[] result = md5.digest(value.getBytes());
        for (byte b : result) sb.append(String.format("%02X ", b));
        System.out.println(sb);

    }
}
