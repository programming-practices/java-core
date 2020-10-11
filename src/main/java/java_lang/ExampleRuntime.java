package java_lang;

// Demonstrate exec().
public class ExampleRuntime {
    public static void main(String args[]) {
//---------------------------------------------------------------------------------------------------------------------
//        Runtime runtime00 = Runtime.getRuntime();
//        Process p = null;
//
//        try {
//            p = runtime00.exec("zenmap");
//        } catch (Exception e) {
//            System.out.println("Error executing notepad.");
//        }
//---------------------------------------------------------------------------------------------------------------------
//        // Demonstrate totalMemory(), freeMemory() and gc().
//        Runtime runtime01 = Runtime.getRuntime();
//        long mem1, mem2;
////        int capacity = 1000;
//        int capacity = 500_000;
//        Integer someints[] = new Integer[capacity];
//
//        System.out.println("Total memory is: " + runtime01.totalMemory());
//
//        mem1 = runtime01.freeMemory();
//        System.out.println("Initial free memory: " + mem1);
//        runtime01.gc();
//        mem1 = runtime01.freeMemory();
//        System.out.println("Free memory after garbage collection: " + mem1);
//
//        for(int i=0; i<capacity; i++) someints[i] = new Integer(i); // allocate integers
//
//        mem2 = runtime01.freeMemory();
//        System.out.println("Free memory after allocation: " + mem2);
//        System.out.println("Memory used by allocation: " + (mem1-mem2));
//
//        // discard Integers
//        for(int i=0; i<capacity; i++) someints[i] = null;
//
//        runtime01.gc(); // request garbage collection
//
//        mem2 = runtime01.freeMemory();
//        System.out.println("Free memory after collecting discarded Integers: " + mem2);
//---------------------------------------------------------------------------------------------------------------------
//        Runtime runtime03 = Runtime.getRuntime();
//
//        int processors = runtime03.availableProcessors();
//        long freeMemory = runtime03.freeMemory();
//        long maxMemory = runtime03.maxMemory();
//        long totalMemory = runtime03.totalMemory();
//
//        System.out.println("Processors = " + processors);
//        System.out.println("Free Memory =  " + freeMemory);
//        System.out.println("Max Memory =   " + maxMemory);
//        System.out.println("Total Memory = " + totalMemory);
//---------------------------------------------------------------------------------------------------------------------

    }
}

