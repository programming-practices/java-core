package stringAPI._string;

public class ExampleStringConcat {
    public static void main(String[] args) {
//--------------------------------------------------------------------------------------------------------------------

//        String str = new String("Hola");
//        String dest = str.concat(". Como estas!!!");
//        System.out.println(dest);
//
//        //  EQUALS
//        String str2 = new String("Hola");
//        String dest2 = str2 + ". Como estas!!!";
//        System.out.println(dest2);

//--------------------------------------------------------------------------------------------------------------------

        String str01 = new String();
        String dest01 = str01.concat("Holla");
        System.out.println(dest01);

        String source = null;
//        String dest02 = str01.concat(source); // Exception NullPointException
//        System.out.println(dest02);

        // A esli zdelat tak to ne bydet Exception NullPointException

        String dest03 = str01 + source;
        System.out.println(dest03);

//--------------------------------------------------------------------------------------------------------------------
    }
}
