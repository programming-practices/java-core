package oop;

public class ExampleReference {
    public static String name = "Himalaya";

    public static ExampleReference getMountain() {
        System.out.println("Getting Name ");
        return null;
    }

    public static void main(String[] args) {
// ---------------------------------------------------------------------------------------------------------------------
        System.out.println(getMountain().name);

// ---------------------------------------------------------------------------------------------------------------------
        ExampleReference reference = getMountain();
        System.out.println(reference);

// ---------------------------------------------------------------------------------------------------------------------
    }
}
