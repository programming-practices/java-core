package Examples.Multithreading;

public class ExampleCacheL1SizeDetectors {
    public static void main(String[] args) {
        byte[] array = new byte[64 * 1024];
        for (int testIndex = 0; testIndex < 10; testIndex++) {
            testFunction(array);
            System.out.println("---------------------------");
        }
    }

    private static void testFunction(byte[] array) {
        for (int len = 8192; len <= array.length; len += 8192) {

            long startTime = System.nanoTime();
            for (int i = 0; i < 100; i++) {
                for (int index = 0; index < len; index += 64) {
                    array[index] = 1;
                }
            }
            long endTime = System.nanoTime();
            long dT = endTime - startTime;

            System.out.println("len: " + len + " , dT " + dT + " , 10*dT/len: " + (10 * dT) / len);


        }
    }
}
