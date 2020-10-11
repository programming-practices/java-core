package Examples.String_API._String;

public class ExampleStringCompareToIgnoreCase {
    static String arr[] = {
            "Now", "is", "the", "time", "for", "all", "good", "men",
            "to", "come", "to", "the", "aid", "of", "their", "country"
    };

    public static void main(String args[]) {
        for (int barrier = 0; barrier < arr.length; barrier++) {
            for (int index = barrier + 1; index < arr.length; index++) {
                if (arr[index].compareToIgnoreCase(arr[barrier]) < 0) {
                    String tmp = arr[barrier];
                    arr[barrier] = arr[index];
                    arr[index] = tmp;
                }
            }
            System.out.println(arr[barrier]);
        }
    }
}
