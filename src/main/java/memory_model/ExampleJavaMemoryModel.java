package memory_model;

// Sources:
// 1.  https://www.youtube.com/watch?v=AxL5LgoQyNs
// 2.  https://www.youtube.com/watch?v=msCqh8Mn37A
// 3.  https://www.youtube.com/watch?v=lrOAFzRZJ60
// 4.  https://www.youtube.com/watch?v=qOYbUS2GUdo
// 5.  https://www.youtube.com/watch?v=ixb297AxV-0
// 6.  https://www.youtube.com/watch?v=805u8oDxyX0
// 7.  https://www.youtube.com/watch?v=6dDguuNKBwE
// 8.  https://www.youtube.com/watch?v=Mv11WDpLupA&t=5s
// 9.  https://www.youtube.com/watch?v=_PN9qzDSd8s
// 10. https://www.youtube.com/watch?v=1XbAr8fZyDo
// 11. https://www.youtube.com/watch?v=ex5IsyYLOmM&t=1s
// 12. https://www.youtube.com/watch?v=Q5zBEer41VM
// 13. https://www.youtube.com/watch?v=Wlf2EYzI5Fk&t=6s
// 14. https://www.youtube.com/watch?v=uj8EtthAq_c

import java.util.Arrays;

public class ExampleJavaMemoryModel {
    public static void main(String[] args) {
// ----------------------------------------- Source: 9, 10 -----------------------------------------------------------------
        // ------------ Prostue tipu peredaytsa po znacheniy
        int field0 = 10;
        int field1 = field0;
        field0 = 30;
        System.out.println(field1);

        // ------------ Ssulochnue tipu peredaytsa po ssilke
        int[] w = {1, 2, 3};
        int[] q = w;
        w[0] = 0;
        System.out.println(Arrays.toString(q));
        // Esli zdelat tak necheho ne izmenitsa
        w = null; // zdes mu prosto onulili ssulky "w" no masiv ostalsa bez izmenenii
        System.out.println(Arrays.toString(q));

//        int[] x = new int[]{10, 20, 30};
//        fVoid(x);
//        System.out.println(Arrays.toString(x));
//        x = fReturnIntArg(x);
//        System.out.println(Arrays.toString(x));

//        HolderValuesInt holderValuesInt = new HolderValuesInt(0, 1);
//        fArgInt(holderValuesInt);
//        System.out.println(holderValuesInt.x + " " + holderValuesInt.y);

        HolderValuesArray hVA = new HolderValuesArray(0, 1);
        hVA = fArgArray(hVA);
//        System.out.println(hVA.field0[0] + " " + hVA.field1[0]);
        System.out.println(Arrays.toString(hVA.field0) + " " + Arrays.toString(hVA.field1));

        System.gc();
// ----------------------------------------- Source: 1, 2, 3, 4, 5, 6, 7, 8 --------------------------------------------
//        long[] arr = new long[Integer.MAX_VALUE];  //  java.lang.OutOfMemoryError
// -------------------------------------------------------
        // Zdes ne bydet java.lang.OutOfMemoryError, potomy chto GarbageCollector tytze ydaliaet eti obektu iz heap
        // potomu chto field1 nix nety ssulki.
//        boolean e = true;
//        while (e){
//            new Object();
//        }
        // --------------------------------------------------------
        // Zdes toze ne bydet owibki potomu chto za kazdui oborot while v suslky risvaevaetsa novui obiekt a starui
        // obiekt mozet bit ydalon v lyboe vremia
//        Object obj;
//        boolean bool = true;
//        while (bool){
//           obj = new Object(); Zdes na kazdom kryhe prisvaevaetsa novui obekt a starui mozet bit ydalon v lyboe vremia GC
//        }
        // --------------------------------------------------------
        // Zdes bydet java.lang.OutOfMemoryError
//        List<Object> list = new ArrayList<>();
//        boolean rr = true;
//        while (rr){
//            list.add(new Object());
//        }
        // -------------------------------------------------------
        // Zdes ne bydet java.lang.OutOfMemoryError,
//        boolean bool = true;
//        while (bool){
//            Object o = new Object(); Zdes na kazdom kryhe sozdaetsa obiekt a starui v lyboe vremia mozet bit ydalon GC
//        }
        // -------------------------------------------------------
//        Object[] ref = new Object[1];
//        boolean bool = true;
//        while (bool){
//            Object[] a = new Object[1];
//            Object[] b = new Object[1];
//            a[0] = b;
//            b[0] = a;
        // Zdes na kazdom kruhe prisvaevaetsa novui obekt "a" kotorui imeet v sebe obekt "b" a strui obekt v
        // luboe vremia mozet bit ydalon GC
//            ref[0] = a;
//        }
        // --------------------------------------------------------
//        Object[] ref = new Object[1];
//        boolean bool = true;
//        while(bool) {
        // Zdes na kazdom kryhe sozdaetsa obiekt kotorui ssulaetsa na prededywchui i v takom sluchai polychaetsa
        // chto zdes polychaetsa sviazanui spisok. Cherez nekotoroe vremia bydet java.lang.OutOfMemoryError
//            ref = new Object[]{ref};
//        }
        // ---------------------------------------------------------
//        Object[] ref = new Object[1];
//        boolean bool = true;
//        while (bool){
//             zdes proisxodit trew )))))))
//            ref[0] = new Object[]{ref};
//            ref = (Object[]) ref[0];
//        }
// ---------------------------------------------------------------------------------------------------------------------

    }

    public static void fVoid(int[] arg) {
        arg[0] = 1000;  // Zdes po ssulke meniaetsa znachenie pervoho elementa
        arg = new int[]{100, 200, 300};  // a zdes v peremennoi arg meniaetsa ssilka na nivui masiv, field1 posle vuxoda z
        // methodda etot masiv teriaetsa
    }

    public static int[] fReturnIntArg(int[] arg) {
        arg[0] = 1000;  // Zdes po ssulke meniaetsa znachenie pervoho elementa
        arg = new int[]{100, 200, 300};
        return arg; // Zdes vuvoditsa masiv sozdanui v methode
    }

    public static void fArgInt(HolderValuesInt h) {
        h.x = 100;
        h = new HolderValuesInt(-1, -2);
    }

    public static HolderValuesArray fArgArray(HolderValuesArray arg) {
        arg.field0 = null;
        arg.field1[0] = 100;
        arg = new HolderValuesArray(-1, -2);
        arg.field0 = new int[]{1, 2, 3};
        arg.field1[0] = 100;
        return arg;
    }
}

class HolderValuesInt {
    int x;
    int y;

    public HolderValuesInt(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class HolderValuesArray {
    int[] field0;
    int[] field1;

    public HolderValuesArray(int x, int y) {
        this.field0 = new int[]{x};
        this.field1 = new int[]{y};
    }
}
