package stringAPI.Konstryktoru_simvolnux_strok;

// Construct one String from another.
public class MakeString {
    public static void main(String args[]) {

        char chars[] = {'J', 'a', 'v', 'a'};
        String str01 = new String(chars);
        String str02 = new String(str01);

        System.out.println(str01);
        System.out.println(str02);

    }
}
