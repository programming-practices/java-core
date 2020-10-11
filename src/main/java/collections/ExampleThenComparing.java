package collections;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class ExampleThenComparing {
    public static void main(String[] args) {
//--------------------------------------------------------------------------------------------------------------------
        // Use thenComparing() to create age comparator that compares
        // last names, then compares entire name when last names match.
        CompLastNames compLN = new CompLastNames();
        Comparator<String> compLastThenFirst = compLN.thenComparing(new CompThenByFirstName());

        // Create age tree map.
//        TreeMap<String, Double> treeMap = new TreeMap<String, Double>(compLastThenFirst);
        TreeMap<String, Double> treeMap = new TreeMap<String, Double>((aStr, bStr) -> {
//            if (== 0)
//                return aStr.compareTo(bStr);
            int exitValueOfCompareLN =
                    aStr.substring(aStr.lastIndexOf(' ')).
                            compareToIgnoreCase(bStr.substring(bStr.lastIndexOf(' ')));
            if (exitValueOfCompareLN == 0) {
                return aStr.compareTo(bStr);
            } else {
                return exitValueOfCompareLN;
            }
        });

        // Put elements to the map.
        treeMap.put("John Doe", new Double(3434.34));
        treeMap.put("Tom Smith", new Double(123.22));
        treeMap.put("Jane Baker", new Double(1378.00));
        treeMap.put("Tod Hall", new Double(99.22));
        treeMap.put("Ralph Smith", new Double(-19.08));

        // Get age set of the entries.
        Set<Map.Entry<String, Double>> set = treeMap.entrySet();

        // Display the elements.
        for (Map.Entry<String, Double> me : set) {
            System.out.print(me.getKey() + ": ");
            System.out.println(me.getValue());
        }
        System.out.println();

        // Deposit 1000 into John Doe's account.
        double balance = treeMap.get("John Doe");
        treeMap.put("John Doe", balance + 1000);

        System.out.println("John Doe's new balance: " +
                treeMap.get("John Doe"));
//--------------------------------------------------------------------------------------------------------------------
    }
}

// Use thenComparing() to sort by last, then first name.
// A comparator that compares last names.
class CompLastNames implements Comparator<String> {
    public int compare(String aStr, String bStr) {
        int i, j;

        // Find index of beginning of last name.
        i = aStr.lastIndexOf(' ');
        j = bStr.lastIndexOf(' ');

        return aStr.substring(i).compareToIgnoreCase(bStr.substring(j));
    }
}

// Sort by entire name when last names are equal.
class CompThenByFirstName implements Comparator<String> {
    public int compare(String aStr, String bStr) {
        return aStr.compareToIgnoreCase(bStr);
    }
}

/*
---------------------------------------------------------------------------------------------------------------------
Напомним, что метод thenComp a r i n g ( ) позволяет указать второй компаратор, который используется
в том случае, если вызывающий компаратор возвращает признак равенства сравниваемых объектов.
---------------------------------------------------------------------------------------------------------------------

*/
