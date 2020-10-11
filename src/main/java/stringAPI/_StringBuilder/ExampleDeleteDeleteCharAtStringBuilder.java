package Examples.String_API._StringBuilder;

// Demonstrate delete() and deleteCharAt()
public class ExampleDeleteDeleteCharAtStringBuilder {
    public static void main(String args[]) {
//---------------------------------------------------------------------------------------------------------------------

        StringBuffer sb = new StringBuffer("This is age test.");
        System.out.println("              " + sb);

        sb.delete(4, 7);
        System.out.println("After delete: " + sb);

        sb.deleteCharAt(0);
        System.out.println("After deleteCharAt: " + sb);

//---------------------------------------------------------------------------------------------------------------------


//---------------------------------------------------------------------------------------------------------------------

    }
}

