package stringAPI.Konstryktoru_simvolnux_strok;


public class Pruebas {
    public static void main(String[] args) {

        char[] chars = {'a', 'b', 'c', 'd', 'e', 'f'};
        String str_00 = new String(chars);
        System.out.println(str_00);

        String str_01 = new String(chars, 2, 3);
        System.out.println(str_01);

        String str_02 = new String(str_01);
        System.out.println(str_02);
    }
}
