package exceptions.try_;

public class Example {
    public static void main(String[] args) {

        System.out.println(method());
    }

    public static boolean method () {
        try {
            return true;
        } finally {
            return false;
        }
    }
}
