package stringAPI._string;

public class ExampleStringConcatenation {
    public static void main(String[] args) {
//--------------------------------------------------------------------------------------------------------------------

        String str = "Fourth(concatenation): " + 2 + 2;
        String str01 = "Fourth(dodavanie): " + (2 + 2);
        String str02 = "Fourth(mnozenie): " + 2 * 2;
        String str03 = "Fourth(dilenie): " + 2 / 2;
//        String str04 = "Fourth: " + 2 - 2;    //  ERROR
        String str05 = "Fourth(otnimanie): " + (2 - 2);

        System.out.println(str);
        System.out.println(str01);
        System.out.println(str02);
        System.out.println(str03);
        System.out.println(str05);

//--------------------------------------------------------------------------------------------------------------------
        String mango = "mango";
        String s = "abc" + mango + "def" + 47;
        System.out.println(s);

//---------------------------------------------------------------------------------------------------------------------
    }
}
