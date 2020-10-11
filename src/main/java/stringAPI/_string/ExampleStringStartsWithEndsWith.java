package Examples.String_API._String;

public class ExampleStringStartsWithEndsWith {
    public static void main(String[] args) {
        String str1 = new String("Hello, How are you");
        String str2 = new String("How");
        String str3 = new String("HOW");

        System.out.println(str1.startsWith("Hello"));
        System.out.println(str1.endsWith("you"));
        System.out.println(str1.startsWith("How", 7));
    }
}
