package Examples.String_API._StringBuilder;

// Demonstrate replace()
public class ExampleIndexOfLastIndexOfStringBuffer {
    public static void main(String args[]) {

//        StringBuffer sb = new StringBuffer("one two one");
        StringBuffer sb = new StringBuffer("Jon Kekson");
        int i;

        i = sb.indexOf("one");
        System.out.println("First index: " + i);

//        i = sb.lastIndexOf("one");
        i = sb.lastIndexOf(" ");
        System.out.println("Last index: " + i);

    }
}

