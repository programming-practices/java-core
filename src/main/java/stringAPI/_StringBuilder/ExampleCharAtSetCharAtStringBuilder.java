package Examples.String_API._StringBuilder;

// Demonstrate charAt() and setCharAt().
public class ExampleCharAtSetCharAtStringBuilder {
    public static void main(String args[]) {
//---------------------------------------------------------------------------------------------------------------------

//        StringBuilder sb = new StringBuilder("Hello");
//        System.out.println("buffer before = " + sb);
//
//        System.out.println("charAt(1) before = " + sb.charAt(1));
//        System.out.println("sb1 = " + sb);
//
//        sb.setCharAt(1, 'i');
//        System.out.println("sb2 = " + sb);
//
//        sb.setLength(2);
//        System.out.println("sb3 = " + sb);
//
//        System.out.println("buffer after = " + sb);
//        System.out.println("charAt(1) after = " + sb.charAt(1));

//---------------------------------------------------------------------------------------------------------------------

        StringBuilder sb2 = new StringBuilder("12345");
        System.out.println(sb2.charAt(1));
        System.out.println("vmestimost sb2 = " + sb2.capacity());
        System.out.println("dovzina zanimaimoho strokoi mesta sb2 = " + sb2.length());
//        System.out.println(sb2.charAt(8));     // ERROR pod etim indexsom nety necheho
        sb2.setCharAt(8, 'e'); // ERROR pod etim indexsom netu necheho, i po etomu ne vozmozno sdelat zameny

//---------------------------------------------------------------------------------------------------------------------
    }
}

