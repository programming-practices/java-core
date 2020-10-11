package advanced;

import java.util.ArrayList;
import java.util.Arrays;

public class ExampleCopier {
    public static void copyObj(Object[] src, Object[] dst) {
        int lenght = Math.min(src.length, dst.length);
        for (int i = 0; i < lenght; i++) {
            dst[i] = src[i];
        }
    }

    public static ArrayList<Object> copyArrayObj(ArrayList<Object> src, ArrayList<Object> dst) {
        int size = Math.min(src.size(), dst.size());
        for (int i = 0; i < size; i++) {
            dst.set(i, src.get(i));
        }
        return dst;
    }

    public static <T> void copyGen(ArrayList<? extends T> src, ArrayList<? super T> dst) {
        int lenght = Math.min(src.size(), dst.size());
        for (int i = 0; i < lenght; i++) {
            dst.set(i, src.get(i));
        }
    }

    public static void testArray() {
        Integer[] integers = new Integer[10];
//        integers[0] = 1;
        String[] strings = new String[10];
        ExampleCopier.copyObj(integers, strings);
        String cast = strings[0];
    }

    public static void testArray2() {
        ArrayList<Integer> integers = new ArrayList<>(Arrays.asList(2, 3, 4));
        ArrayList<String> strings = new ArrayList<>(Arrays.asList("dd", "kk", "rr"));

        ArrayList<Object> ff = ExampleCopier.copyArrayObj(new ArrayList<Object>(integers), new ArrayList<Object>(strings));
        System.out.println(ff);

        ArrayList<Object> i = ExampleCopier.copyArrayObj(new ArrayList<Object>(strings), new ArrayList<Object>(integers));
        System.out.println(i);
    }

    public static void testGenericsB() {
        ArrayList<Integer> integers = new ArrayList<Integer>(10);
        integers.add(1);
        integers.set(0, 7);
        integers.add(new Integer(1));
        ArrayList<Object> objects = new ArrayList<Object>(10);
        objects.add(new Object());
//        objects.add(new String("ee"));
        ExampleCopier.copyGen(integers, objects);
        Object noCast = objects.get(0);
    }

    public static <T> T mock(T t) {
        return null;
    }

    public static void main(String[] args) {
//        testArray();
        testGenericsB();
//        testArray2();
        Integer i = mock(1);
        String s = mock("www");
//        Integer i1 = mock("dfs");       // ERROR
    }
}
