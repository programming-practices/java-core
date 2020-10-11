package TypeInformation.ssilka_na_obobwchonnii_class;

// Testing class Class.

public class GenericToyTest {
    public static void main(String[] args) throws Exception {

        Class<FancyToy> ftClass = FancyToy.class;

        // Produces exact type:
        FancyToy fancyToy = ftClass.newInstance();

        Class<? super FancyToy> up = ftClass.getSuperclass();

        // This won't compile:
//         Class<Toy> up2 = ftClass.getSuperclass();

        // Only produces Object:
        Object obj = up.newInstance();
//        Toy obj1 = up.newInstance();
    }
}
