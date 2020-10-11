package stringAPI;

public class String_Pool {
    public static void main(String[] args) {

        String s1 = "Hello";
        String s2 = "Hello";
        String s4 = "He";
        String s5 = "llo";
        String s6 = s4 + s5;

        String s3 = new String("Hello");

        System.out.println("s1.equals(s2) --> " + s1.equals(s2));
        System.out.println("s1.equals(s6) --> " + s1.equals(s6));
        System.out.println("(s1 == s2) --> " + (s1 == s2));
        System.out.println("(s6 == s2) --> " + (s6 == s2));
        System.out.println("(s1 == s6) --> " + (s1 == s6));

        System.out.println();
        System.out.println("s3.equals(s1) --> " + s3.equals(s1));
        System.out.println("s3.equals(s2) --> " + s3.equals(s2));
        System.out.println("s3.equals(s6) --> " + s3.equals(s6));

        System.out.println();
        System.out.println("(s3.intern() == s1) --> " + (s3.intern() == s1));
        System.out.println("(s3 == s1) --> " + (s3 == s1));
        System.out.println("(s3 == s2) --> " + (s3 == s2));
        System.out.println("(s3 == s6) --> " + (s3 == s6));
    }
}

/*
В чём разница при использовании new Srtring("") и простого присваивания.?

Когда используется new(), строка сразу добавляется в heap и НЕ добавляется в string pool.

String pool -- пул, в котором хранятся все определённые строки. и если создаётся новая, компилятор проверяет,
есть ли её значение в пуле, если есть, то вновь созданной присваивается ссылка на уже существующую, таким образом
экономится память. Это безопасно, что разные String-и могут ссылаться на один объект, потому что String -- immutable.

Чтобы добавить строку в пул, используется метод String.intern();
Строки созданные, как String s = "s"; добавляются в пул автоматически.

*/
