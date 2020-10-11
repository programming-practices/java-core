package memory_model;


/*
 * Sources:
 *      1. https://www.youtube.com/watch?v=inBUNUOrFVI&list=PLoij6udfBncilPJMzXtsOyUutDDULrtEm     Golovach
 *
 * */
public class ExampleHeap {
    public static void main(String[] args) {
// ---------------------------------------------------------------------------------------------------------------------
//        Object ref = new long[Integer.MAX_VALUE];
//        Object ref = new long[Integer.MAX_VALUE / 4];
//        Object ref = new long[Integer.MAX_VALUE / 5];

// ---------------------------------------------------------------------------------------------------------------------
//        for (int i = 0; i < Integer.MAX_VALUE; i++) {
//            System.out.println(i);
//            Object ref = new byte[1_000_000];
//        }

// ---------------------------------------------------------------------------------------------------------------------
//        Object ref = null;
//        for (int i = 0; i < Integer.MAX_VALUE; i++) {
//            System.out.println(i);
//            ref = new Object[]{ref, new Object[]{}};
//        }

// ---------------------------------------------------------------------------------------------------------------------
    }
}

/*
------------------------------------------------------------------------------------------------------------------------
Heap xranit v sebe: vse sozdanue obektu i vse polya kotuorue naxodiatsa v etix obektax. Krome staticheskix polei oni
soxraniaytsav Permanent Generation
------------------------------------------------------------------------------------------------------------------------
Garbage Collector rabotaet v Heap
------------------------------------------------------------------------------------------------------------------------
*/
