package stringAPI._StringBuffer;

// Demonstrate append().
public class ExampleAppendStringBuffer {
    public static void main(String args[]) {

        String s;
        int age = 42;
        StringBuffer sb = new StringBuffer(40);

        s = sb.append("age = ").append(age).append("!").toString();
        System.out.println(s);

        System.out.println("length() = " + sb.length());
        System.out.println("capacity() = " + sb.capacity());
    }
}

