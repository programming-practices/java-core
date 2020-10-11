package Examples.String_API._StringBuffer;

// Using reverse() to reverse age StringBuffer.
public class ExampleReverseStringBuffer {
    public static void main(String args[]) {

        StringBuffer s = new StringBuffer("abcdef");

        System.out.println(s);
        s.reverse();
        System.out.println(s);
    }
}

