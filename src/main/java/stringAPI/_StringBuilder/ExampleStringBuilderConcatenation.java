package Examples.String_API._StringBuilder;

import java.util.Random;

public class ExampleStringBuilderConcatenation {
    public static Random rand = new Random(47);

    public static void main(String[] args) {
        ExampleStringBuilderConcatenation usb = new ExampleStringBuilderConcatenation();
        System.out.println(usb);
    }

    public String toString() {
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < 25; i++) {
            result.append(rand.nextInt(100));
            result.append(", ");
        }
        result.delete(result.length() - 2, result.length());
        result.append("]");
        return result.toString();
    }
}
