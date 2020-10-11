package Examples.java_util;

import java.util.Scanner;

public class ExampleScannerDelimiter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner("12, 42, 78, 99, 42");
        scanner.useDelimiter("\\s*,\\s*");
        while (scanner.hasNextInt())
            System.out.println(scanner.nextInt());
    }
}
