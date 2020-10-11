package others.pereduvutus.Generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tests1 {
    public static void main(String[] args) {
        List list = new ArrayList();
        List<String> stringList = new ArrayList<>();

//        list = stringList;
//        stringList = list;        //WARNING

        list = stringList;
        list.add(8);           //  WARNING, NO RUNTIMEERROR
        list.add(true);
        Object o = list.get(0);
        Object o2 = list.get(1);
//        String s = list.get(0);
//        System.out.println(o);
//        System.out.println(o2);


//        SomeType someType = new SomeType();
//        List<String> stringList1 = Arrays.asList("value");
//        someType.test(stringList1);

        SomeType<?> someType = new SomeType<>();
        List<String> stringList1 = Arrays.asList("value");
        someType.test(stringList1);

//        SomeType<String> stringSomeType = new SomeType<>();
//        List<String> stringList2 = Arrays.asList("value");
//        stringSomeType.test(stringList2);

    }
}
