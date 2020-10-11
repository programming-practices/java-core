package IO;

public class ExamplePrintFPrintStream {
    public static void main(String[] args) {
//--------------------------------------------------------------------------------------------------------------------
        // Demonstrate printf().
        System.out.println("Here are some numeric values " + "in different formats.\n");

        System.out.printf("Various integer formats: ");
        System.out.printf("%d %(d %+d %05d\n", 3, -3, 3, 3);

        System.out.println();
        System.out.printf("Default floating-point format: %fArgInt\n", 1234567.123);
        System.out.printf("Floating-point with commas: %,fArgInt\n", 1234567.123);
        System.out.printf("Negative floating-point default: %,fArgInt\n", -1234567.123);
        System.out.printf("Negative floating-point option: %,(fArgInt\n", -1234567.123);

        System.out.println();

        System.out.printf("Line up positive and negative values:\n");
        System.out.printf("% ,.2f\n% ,.2f\n", 1234567.123, -1234567.123);
//--------------------------------------------------------------------------------------------------------------------
    }
}
/*
----------------------------------------------------------------------------------------------------------------------

----------------------------------------------------------------------------------------------------------------------
*/