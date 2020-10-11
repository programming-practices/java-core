package others;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class ggg {
    public static void main(String[] arg) {

        String[] names = {"Elena", "Thomas", "Hamilton", "Suzie", "Phil", "Matt", "Alex", "Emma", "John", "James", "Jane", "Emily", "Daniel", "Neda", "Aaron", "Kate"};

        int[] times = {341, 273, 278, 329, 445, 402, 388, 275, 243, 334, 412, 393, 299, 343, 317, 265};

        TreeMap<Integer, String> map = new TreeMap(Comparator.naturalOrder());

        for (int i = 0; i < names.length; i++) {
            map.put(times[i], names[i]);
        }

        for (Map.Entry<Integer, String> f : map.entrySet()) {
            System.out.println("Time: " + f.getKey() + " , Name: " + f.getValue());
        }
    }
}
