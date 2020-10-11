package Examples.String_API._StringBuffer;

// Demonstrate replace()
public class ExampleReplaceStringBuffer {
    public static void main(String args[]) {
//---------------------------------------------------------------------------------------------------------------------

        StringBuffer sb = new StringBuffer("This is age test.");
        System.out.println("               " + sb);

        sb.replace(5, 7, "was");
        System.out.println("After replace: " + sb);

//---------------------------------------------------------------------------------------------------------------------

        String str2 = "aaaaa";
        String strReplace = str2.replace("aa", "ba");
        System.out.println(strReplace);

//---------------------------------------------------------------------------------------------------------------------
    }
}

