package Examples.String_API._String.system_out_format;

public class ExampleSimpleFormat {
    public static void main(String[] args) {
        int x = 5;
        double y = 5.332542;
        // The old way:
        System.out.println("Row 1: [" + x + " " + y + "]");
        // The new way:
        System.out.format("Row 1: [%d %fArgInt]\n", x, y);
        // or
        System.out.printf("Row 1: [%d %fArgInt]\n", x, y);
    }
}
