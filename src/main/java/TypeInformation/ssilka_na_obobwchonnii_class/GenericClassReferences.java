package Examples.Type_Information.ssilka_na_obobwchonnii_class;

public class GenericClassReferences {
    public static void main(String[] args) {
        Class intClass = int.class;
        Class<Integer> genericIntClass = int.class;
        genericIntClass = Integer.class; // Same thing
        intClass = double.class;
//         genericIntClass = double.class; // Illegal
    }
}
