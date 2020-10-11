package oop;

/**
 * This program demonstrates the use of static inner classes.
 *
 * @author Cay Horstmann
 * @version 1.02 2015-05-12
 */
public class ExampleStaticInnerClass {
    public static void main(String[] args) {
        double[] d = new double[20];
        for (int i = 0; i < d.length; i++)
            d[i] = 100 * Math.random();
        ClassAlg.Pair p = ClassAlg.minmax(d);
        System.out.println("min = " + p.getFirst());
        System.out.println("max = " + p.getSecond());
    }
}

class ClassAlg {
    /**
     * Computes both the minimum and the maximum of an array
     *
     * @param values an array of floating-point numbers
     * @return a pair whose first element is the minimum and whose second element
     * is the maximum
     */
    public static Pair minmax(double[] values) {
        double min = Double.POSITIVE_INFINITY;
        double max = Double.NEGATIVE_INFINITY;
        for (double v : values) {
            if (min > v) min = v;
            if (max < v) max = v;
        }
        return new Pair(min, max);
    }

    /**
     * A pair of floating-point numbers
     */
    public static class Pair {
        private double first;
        private double second;

        /**
         * Constructs a pair from two floating-point numbers
         *
         * @param f the first number
         * @param s the second number
         */
        public Pair(double f, double s) {
            first = f;
            second = s;
        }

        /**
         * Returns the first number of the pair
         *
         * @return the first number
         */
        public double getFirst() {
            return first;
        }

        /**
         * Returns the second number of the pair
         *
         * @return the second number
         */
        public double getSecond() {
            return second;
        }
    }
}

/*
-----------------------------------------------------------------------------------------------------------------------
НА ЗАМЕТКУ! Статический внутренний класс применяется в тех случаях, когда доступ к объекту внутреннего класса не требуется.
Некоторые программисты для обозначения статических внутренних классов пользуютсятермином вложенные классы.
-----------------------------------------------------------------------------------------------------------------------
НА ЗАМЕТКУ! Внутренние классы, определенные в интерфейсах, автоматически считаются статическими и открытыми (т.е. static и public).
-----------------------------------------------------------------------------------------------------------------------
*/
