package Examples.Type_Information.interfaces_i_information_type;

import java.lang.reflect.Field;

class WithPrivateFinalField {
    private final String s = "I'm totally safe";
    private int i = 1;
    private String s2 = "Am I safe?";

    public String toString() {
        return "i = " + i + ", " + s + ", " + s2;
    }
}

public class ModifyingPrivateFields {
    public static void main(String[] args) throws Exception {

        WithPrivateFinalField pf = new WithPrivateFinalField();
        System.out.println(pf);
        System.out.println();

        Field f = pf.getClass().getDeclaredField("i");
        f.setAccessible(true);
        System.out.println("fArgInt.getInt(pf): " + f.getInt(pf));
        System.out.println();

        f.setInt(pf, 47);
        System.out.println(pf);
        System.out.println();

        f = pf.getClass().getDeclaredField("s");
        f.setAccessible(true);
        System.out.println("fArgInt.get(pf): " + f.get(pf));
        System.out.println();

        f.set(pf, "No, you're not!");
        System.out.println(pf);
        System.out.println();

        f = pf.getClass().getDeclaredField("s2");
        f.setAccessible(true);
        System.out.println("fArgInt.get(pf): " + f.get(pf));
        System.out.println();

        f.set(pf, "No, you're not!");
        System.out.println(pf);
    }
}

