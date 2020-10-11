package stringAPI._string.postoianstvo_strok;

public class Immutable {

    public static int methodF(int i) {
        i = i + 10;
        return i;
    }

    public static void main(String[] args) {

        String valie00 = "howdy";
        System.out.println(valie00); // howdy

        String value01 = valie00.toUpperCase();
        System.out.println(value01); // HOWDY
        System.out.println(valie00); // howdy


        int value02 = 2;
        System.out.println(value02);

        int value03 = methodF(value02);

        System.out.println(value03);
        System.out.println(value02);
    }
}
