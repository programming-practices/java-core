package oop;

public class ExampleIncrementDecrement {
    public static void main(String[] args) {
//--------------------------------------------------------------------------------------------------------------------
        int vlaue1 = 5;
        vlaue1 = vlaue1++;
        System.out.println(vlaue1);

        int value2 = 5;
        value2 = value2++ + value2++;
        System.out.println(value2);

        int value3 = 5;
        value3 = value3++ + ++value3;
        System.out.println(value3);

        int value4 = 5;
        value4 = ++value4 + ++value4;
        System.out.println(value4);
//---------------------------------------------------------------------------------------------------------------------
        int a = 1;
        int b = 2;
        int c;
        int d;
        c = ++b;
        d = a++;
        c++;
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("c = " + c);
        System.out.println("d = " + d);

//        int x = 1;
//        int y = x++;
//        // out x = 2;
//        // out y = 1;
//
//        int a = 1;
//        int b = ++a;
//        // out a = 2;
//        // out b = 2;
//
//        System.out.println(a);
//        System.out.println(b);
//---------------------------------------------------------------------------------------------------------------------
    }
}

/*
В первом случае, k = 5 +1, затем k = 5; Пост инкремент не передает значение сразу. Ответ 5.

В втором случае, сначала инкременты, второй инкремент получает уже инкрементное значение. Т.к. это
пост-инкременты конечно выражение i = 5 +6; Ответ 11.

В третьем, похоже на второй, только конечное выражение будет таким i = 5 + 7; Ответ 12.

В четвертом, аналагично, только конечное выражение i = 6 +7; Ответ 13.
*/