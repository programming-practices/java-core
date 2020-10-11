package exceptions;

public class ExampleFinallyReturnContinueBreak {
    public static void main(String[] args) {
//---------------------------------------------------------------------------------------------------------------------
//        System.out.println(0);
//        try{
//            System.out.println("1<");
//            if(true)throw new Error();
//            System.out.println("1>");
//        }finally{
//            System.out.println("2<");
//            if(true)return;
////            if(true)throw new RuntimeException();
//            System.out.println("2>");
//        }
//---------------------------------------------------------------------------------------------------------------------
//        for (int i = 0; i < 2; i++) {
//            methodD();
//            System.err.println(3);
//        }
//------------------------------------------Ispolzovanie-finally-pri-return--------------------------------------------
//        for(int i = 1; i <= 4; i++) methodB(i);
//---------------------------------------------------------------------------------------------------------------------
//        System.out.println(fArgInt(2));
//-----------------------------------finally может “съесть” любой эксепшн----------------------------------------------------------------------------------
        try {
            Test.doSomething();
//            System.exit(0);
            System.out.println("yikes! don't program like this!");
        } catch (RuntimeException e) {
            System.out.println("got it.");
        }
        // Победить finally может только System.exit(..)
//---------------------------------------------------------------------------------------------------------------------
    }

    public static void methodD() {
        for (int i = 0; i < 2; i++) {
            System.err.println(0);

            if (true) continue;
//            if(true)break;
//            if(true)return;
//            if(true) throw new Error();
            System.err.println(1);
        }
        System.err.println(2);
    }

    public static void methodB(int i) {
        System.out.println("Initialization that requires cleanup");
        try {
            System.out.println("Point 1");
            if (i == 1) return;
            System.out.println("Point 2");
            if (i == 2) return;
            System.out.println("Point 3");
            if (i == 3) return;
            System.out.println("End");
            return;
        } finally {
            System.out.println("Performing cleanup");
        }
    }

    //---------------------------------------------------------------------------------------------------------------------
    /*ВНИМАНИЕ! Если в блоке fArgInt i n a l l y имеется оператор r e t u r n , результаты его выполнения могут
    быть неожиданными. Допустим, в середине блока t r y происходит возврат из метода с помощью
    оператора r e t u r n . Перед тем как передать управление вызывающей части программы, следует
    выполнить блок fin a l ly . Если и в нем имеется оператор re tu r n , то первоначально возвращае­
    мое значение будет замаскировано. Рассмотрим следующий пример кода:*/
    public static int f(int n) {
        try {
            int r = n * n;
            return r;
        } finally {
            if (n == 2) return 0;
        }
    }
        /*Если сделать вызов fArgInt (2), то в блоке try будет вычислено значение г « 4 и выполнен оператор
        return. Но на самом деле до оператора return будет выполнен код из блока finally. В этом
        блоке из метода принудительно возвращается нулевое значение, игнорируя первоначально вычис­
        ленное значение 4.*/
//--------------------------------------------------------------------------------------------------------------------
}

class Test {
    public static void doSomething() {
        try {
            //Normally you would have code that doesn't explicitly appear
            //to throw exceptions so it would be harder to see the problem.
            if (true) throw new RuntimeException();
            System.exit(0);  // Ne rabotaet
        } finally {
            return;
        }
    }
}
