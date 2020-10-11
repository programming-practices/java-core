package Examples.Type_Information.ssilka_na_obobwchonnii_class;

public class WildcardClassReferences {
    public static void main(String[] args) {
        Class<?> intClass = int.class;
        intClass = double.class;
    }
}
