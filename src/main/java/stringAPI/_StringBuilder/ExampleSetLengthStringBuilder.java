package Examples.String_API._StringBuilder;

public class ExampleSetLengthStringBuilder {
    public static void main(String[] args) {
//---------------------------------------------------------------------------------------------------------------------

//        StringBuilder sb = new StringBuilder("tutorials");
//        System.out.println("vuvod sb = " + sb);
//
//        // length of stringbuffer
//        System.out.println("length = " + sb.length());
//
//        // set the length of stringbuffer to 5
//        sb.setLength(5);
//
//        // print new stringbuffer value after changing length
//        System.out.println("vuvod sb posle sb.setLength(5) = " + sb);
//
//        // length of stringbuffer after changing length
//        System.out.println("length posle sb.setLength(5) = " + sb.length());

//---------------------------------------------------------------------------------------------------------------------

        StringBuilder sb2 = new StringBuilder("12345");
        System.out.println("sb2 = " + sb2);
        System.out.println("sb2.capacity() = " + sb2.capacity());
        System.out.println("sb2.length() = " + sb2.length());
        sb2.setLength(27);
        System.out.println("sb2 posle sb2.setLength(27) = " + sb2);
        System.out.println("Posle sb2.setLength(20) sb2.capacity() = " + sb2.capacity());
        System.out.println("Posle sb2.setLength(20) sb2.length() = " + sb2.length());

//----------------------------------------------------------------------------------------------------------------------
    }
}







