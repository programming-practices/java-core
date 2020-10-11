package memory_model;

/**
 * -verbose:gc
 * Sources: https://www.youtube.com/watch?v=29saH8XR7VY&list=PLoij6udfBncilPJMzXtsOyUutDDULrtEm&index=3
 */
public class GarbageCollector {
    public static void main(String[] args) {
        Object[] ref = new Object[1];
        int count = 0;
        while (true) {
            ref = new Object[]{ref, new byte[1_000]};
            System.out.println(count++);
        }
    }
}
