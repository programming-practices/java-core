package _static.staticheskii_vlozenii_class;

public class ClassOuter {
    private static int a = 9;

    static class StaticheskiiClassInner {
        int b = a;

    }

    class NoStaticClassInner {
        int c = a;
    }


}
