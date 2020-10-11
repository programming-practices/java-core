package others;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExampleValidatorEmail {
    public static String checkEmail1(String email) {
        Pattern p = Pattern.compile("^[A-Za-z0-9.\\-_]+@[a-z]{1,}\\.[a-z]{2,7}$");
        Matcher m = p.matcher(email);
        if (m.matches()) {
            return "Email addres \"" + email + "\" is good!!!";
        } else {
            return "Email addres \"" + email + "\" is bed!!!";
        }
    }

    public static void main(String[] args) {
        System.out.println(ExampleValidatorEmail.checkEmail1("em.1-a_il@gmail.com"));
    }

    public boolean checkEmail2(String email) {
        Pattern p = Pattern.compile("^[A-Za-z0-9.\\-_]+@[a-z]{1,}\\.[a-z]{2,7}$");
        Matcher m = p.matcher(email);
        if (m.matches()) {
            return true;
        } else {
            return false;
        }
    }
}
