package Examples.Type_Information.ssilka_na_obobwchonnii_class;

import java.util.ArrayList;
import java.util.List;

class CountedInteger {

    private static long counter;
    private final long id = counter++;

    public String toString() {
        return Long.toString(id);
    }
}

public class FilledList<T> {

    private Class<T> type;

    public FilledList(Class<T> type) {
        this.type = type;
    }

    public static void main(String[] args) {
        FilledList<CountedInteger> fl = new FilledList<CountedInteger>(CountedInteger.class);
        System.out.println(fl.create(15));
//        System.out.println();
    }
//    FilledList<CountedInteger> fl1 = new FilledList<CountedInteger>(CountedInteger.class);
//   List<CountedInteger> ee = fl1.create(15);

    public List<T> create(int nElements) {

        List<T> result = new ArrayList<T>();

        try {
            for (int i = 0; i < nElements; i++) result.add(type.newInstance());

        } catch (Exception e) {

            throw new RuntimeException(e);
        }
        return result;
    }
}
