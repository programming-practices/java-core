package oop;

public class ExampleBoolean {
    static Boolean bo1 = new Boolean("true");
    static Boolean bo2 = new Boolean(false);

    public static void main(String[] args) {
//----------------------------------------------------------------------------------------------------------------------
//        Boolean b = new Boolean("true");
//        Boolean b2 = new Boolean("tru");
//        System.out.println(b);
//        System.out.println(b2);   // Esli owibitsa pri napisanii slova pri inicializacii, to stavitsa false
//----------------------------------------------------------------------------------------------------------------------
        // На экране будет надпись false, потому что в классе обертке все что не совпадает с "true" является false: true не равно "/true"
//        Boolean b3 = new Boolean("/true");
//        System.out.println(b3);
//----------------------------------------------------------------------------------------------------------------------
//        Boolean bo3 = new Boolean(bo1);
//        Boolean bo4 = new Boolean("bo2");
//        System.out.println(bo1.equals(bo3));
//        System.out.println(bo2.equals(bo4));
//----------------------------------------------------------------------------------------------------------------------
        boolean b = true || (!false);
        boolean b0 = (!true) && (!false);
        boolean b1 = !(true && false);
        boolean b2 = !(true || (!false));
//----------------------------------------------------------------------------------------------------------------------
    }
}


