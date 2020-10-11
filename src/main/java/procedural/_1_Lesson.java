package procedural;

public class _1_Lesson {
    public static void main(String[] args) {

////        System.out.println("x = " + new Object());
//
//        int[] array1D = {0,1,2,3};
////        int[] array1D;
////        array1D = {0,1,2,3};   // ERROR
////        array1D = new int[]{0,1,2,3};   // NOT ERROR
//
//        int[][] array2D = {{0,1}, {2,3}};
////        int[][] array2D = {{0,1}, {2,3},};    // NOT ERROR
//
//        //  demo: array1D - > String
//        System.out.println(array1D);
//        System.out.println(Arrays.toString(array1D));
//
//        //  demo: array2D - > String
//        System.out.println(array2D);
//        System.out.println(Arrays.toString(array2D));
//        System.out.println(Arrays.deepToString(array2D));


//        //  etot variant podxodit dlia vseho
//        int a = 3;
//        int b = 5;
//
//        int tmp = a;
//        a = b;
//        b =  tmp;
//
//        System.out.println("a = " + a);
//        System.out.println("protectedVariable = " + protectedVariable);


//
//        // Rabotaet tolko s celimi chslami, medlennee prowloho varianta , tak rewat nelza
//        int a = 3;
//        int b = 5;
//
//        a = a + protectedVariable;  // a = 8, protectedVariable = 5
//        protectedVariable = a - protectedVariable;  // a = 8, protectedVariable = 3
//        a = a - protectedVariable;  // a = 5, protectedVariable = 3
//
//        System.out.println("a = " + a);
//        System.out.println("protectedVariable = " + protectedVariable);


//        // Rabotaet tolko s celimi chslami,
//        int a = 3;
//        int b = 5;
//
//        a = a ^ b;
//        protectedVariable = a ^ protectedVariable;
//        a = a ^ b;
//
//        System.out.println("a = " + a);
//        System.out.println("protectedVariable = " + protectedVariable);


//        for (int i = 0; i < 10; i++) {
//            System.out.println("i = " + i);
//        }


//        for (int i = 0; i < 10; i += 2) {
//            System.out.println("i = " + i);
//        }
//
//        for (int i = 0; i < 10; i *= 2) {
//            System.out.println("i = " + i);
//        }

//        for (int i = 0; i < 10; i ^= 2) {
//            System.out.println("i = " + i);
//        }

//        for (int i = 0; i < 10; i /= 2) {
//            System.out.println("i = " + i);
//        }

//        for (int i = 0; i < 10; i |= 2) {
//            System.out.println("i = " + i);
//        }
//
//        for (int i = 0; i < 10; i &= 2) {
//            System.out.println("i = " + i);
//        }


//        for (int i = 9; i > 0; i--) {
//            System.out.println("i = " + i);
//        }
//
//        int i = 9;
//        for (; i > 0; i--) {
//            System.out.println("i = " + i);
//        }

//        for (int i = 9; true; i--) {
//            System.out.println("i = " + i);
//        }

//        for (int i = 9; i > 0;) {
//            System.out.println("i = " + i);
//        }

//        for (int i = 9; ; ) {
//            System.out.println("i = " + i);
//        }

//        // Rovnosilno while(true)
//        for ( ; ; ) {
//            System.out.println("i = " );
//        }

        // for (wtouhodno; kakoeto znachenie boolean; wtouhodno)


//        for (int i = 0; i < 10; i++) {
//
//            System.out.println(" " + i);
//
//            i--;
//
//        }

//        for (int i = 0; i < 10;) {
//
//            System.out.println(" " + i);
//
//            i++;
//
//        }

//        for (int i = 0; ; ) {
//
//            if ( i < 10){
//                System.out.println(" " + i);
//
//                i++;
//            } else {
//                break;
//            }
//
//        }


//        int i = 0;
//        for (; ; ) {
//
//            if ( i < 10){
//                System.out.println(" " + i);
//
//                i++;
//            } else {
//                break;
//            }
//
//        }

//        int i = 0;
//        while (true) {
//
//            if ( i < 10){
//                System.out.println(" " + i);
//
//                i++;
//            } else {
//                break;
//            }
//
//        }


//        for (int i = 0; i < 10; i++) {
//            System.out.println(i + " / 2 = " + (i / 2));  // dilenie
//            System.out.println(i + " % 2 = " + (i % 2));  // ostatok ot dilenia
//            System.out.println(i + " / 2d = " + (i / 2d));   // double
//            System.out.println(i + " / 2D = " + (i / 2D));   // double
//            System.out.println(i + " / 2.0 = " + (i / 2.0));   // double
//            System.out.println(i + " / 2f = " + (i / 2f));   // float
//            System.out.println(i + " / 2F = " + (i / 2F));   // float
//            System.out.println();
//        }
//        float fArgInt = 5 / 2.0;   // ERRROR  result is double
//        float f1 = 5 / 2.0f;   // ERRROR  result is double

        // + est dlya String, int, long, float, double

//        System.out.println(1 / 0);  // Exception in thread "main" java.lang.ArithmeticException: / by zero
//        System.out.println(1d / 0);   // Not ERROR  result   infiniry

//        double d = 1.0 / 0;
//        System.out.println(d);// result infinity
//
//        double d2 = -1.0 / 0;
//        System.out.println(d2);// result -infinity
//
//        double d1 = 0.0 / 0;
//        System.out.println(d1);  // result NaN   NaN eto kakbutto oznachaet ne chislo


//        String str = "123.5";
//        double d = Double.valueOf(str);
//        System.out.println(d * 2);

//        String str = "dsfagshrtj 45sshsh  123.5";   // ERROR
//        double d = Double.valueOf(str);
//        System.out.println(d * 2);
//
//        String str = "NaN";   //  NOT ERROR   result NaN
//        double d = Double.valueOf(str);
//        System.out.println(d * 2);
//
//        System.out.println(d < 1);
//        System.out.println(d > 1);
//        System.out.println(d == 1);
//
//        System.out.println(d < Double.POSITIVE_INFINITY);
//        System.out.println(d > Double.POSITIVE_INFINITY);
//        System.out.println(d == Double.POSITIVE_INFINITY);


//        String str = "";
//        String str2 = null;
//
//        int[] arrays = null;
//        int[] arrays2 = new int [0];

    }
}
