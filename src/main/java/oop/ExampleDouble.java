package oop;

import java.util.Objects;

public class ExampleDouble {
    public static void main(String args[]) {
//--------------------------------------------------------------------------------------------------------------------

        double value = 3.0999999999999996D;
        System.out.println(value);
        System.out.println(Math.round(value));
        System.out.println(Math.floor(value));
        System.out.println(Math.ceil(value));

//======================================================================================================================

//        out.println(Double.parseDouble("5.1 "));
//        out.println(Double.valueOf("5.1 "));
//        out.println(Math.round(3.0999999999999996));

//======================================================================================================================

        Double d1 = Double.MAX_VALUE;
        Double d2 = Double.MAX_VALUE;
//
//        System.out.println(d1.hashCode());
//        d2 = d2 + 100000000000000000000000000.1;
//        System.out.println(d2.hashCode());
//
//        System.out.println(d2.equals(d1));
//        System.out.println(d1.hashCode() == d2.hashCode());
//        System.out.println(d2 + 100000000000000000000000000.1);
//        System.out.println(d2);

//--------------------------------------------------------------------------------------------------------------------
        String s = "123.4";
        double d = Double.valueOf(s);
//        System.out.println(d * 2);

//        String s1 = "gsrhh tw@ 123.4";
//        double d1 = Double.valueOf(s1);
//        System.out.println(d1 * 2);

//        String s2 = "NaN";
//        double d2 = Double.valueOf(s2);
//        System.out.println(d2 * 2);
//--------------------------------------------------------------------------------------------------------------------
        //Расскажите что будет с hashCode ' ом у Double и почему :
        //Будут ли одинаковые hashCode у d1 и d2?
        // Можно ли считать такое решение удачным?
//        Double d1 = Double.MAX_VALUE;
//        Double d2 = Double.MAX_VALUE;
//
//        System.out.println(d1.hashCode());
//        System.out.println(d1);
//        System.out.println();
//        d2 = d2 + 100000000000000000000000000.1;
//        System.out.println(d2.hashCode());
//        System.out.println(d2);
//        System.out.println();
//
//        System.out.println(d2.equals(d1));
//        System.out.println(d1.hashCode() == d2.hashCode());

        /*Ответ в исходном коде получения hashCode в Double и equals
        public int hashCode() {
            long bits = doubleToLongBits(value);
            return (int)(bits ^ (bits >>> 32));
        }

        Результатом является исключающее ИЛИ
        (int)(v^(v>>>32))

        где v определяется по формуле:
        long v = Double.doubleToLongBits(this.doubleValue()); */
//--------------------------------------------------------------------------------------------------------------------
//        Double d11 = new Double(3.14159);
//        Double d21 = new Double("314159E-5");
//        System.out.println(d11 + " = " + d21 + " -> " + d11.equals(d21));
//--------------------------------------------------------------------------------------------------------------------
//        puzz(0D/0D, 0D/0D);
//--------------------------------------------------------------------------------------------------------------------
    }

    public static void puzz(double x, double y) {
        System.out.println(x == y);
        System.out.println(Objects.equals(x, y));
    }
}

/*
----------------------------------------------------------------------------------------------------------------------
Double.compare(), возвращающий от­рицательное числовое значение, если первый его аргумент меньше второго; нулевое
значение, если аргументы равны; а иначе — положительное числовое значение.
В результате вызова Double.compare(х, у) просто возвращается значение -1 , если х < у,илизначение1,еслих> 0.
----------------------------------------------------------------------------------------------------------------------
•static int compare (double x, double y) 1.4
    Возвращает:
    отрицательное целое значение если х < у,
    нулевое значение — х = у,
    а иначе — положительное целое значение.
----------------------------------------------------------------------------------------------------------------------
*/
