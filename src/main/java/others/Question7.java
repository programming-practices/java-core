package others;

public class Question7 {

    public static void doIt(String String) { //1
        int i = 10;
        i:
        for (int k = 0; k < 10; k++) { //2
            System.out.println(String + i); //3
            if (k * k > 10) continue i; //4
        }
    }

    public static void main(String[] args) {
        doIt("Hello");
    }

}


/*
*
    Не скомпилируется из-за строки 1
    Не скомпилируется из-за строки 2
    Не скомпилируется из-за строки 3
    Не скомпилируется из-за строки 4
    Скомпилируется и запустится без проблем
*/



