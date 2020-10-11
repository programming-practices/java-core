package collections.others.vivod_konteinerov;

//Konteineru rozpechativaytsa avtomaticheski.

import java.util.*;

public class PrintingContainers {
    static Collection fill(Collection<String> collection) {
        collection.add("krusa");
        collection.add("kowka");
        collection.add("sobaka");
        collection.add("sobaka");
        return collection;
    }

    static Map fill(Map<String, String> map) {
        map.put("krusa", "Anfisfa");
        map.put("kowka", "Myrka");
        map.put("sobaka", "Warik");
        map.put("sobaka", "Bobik");
        map.put("Warik", "sobaka");
        map.put("Bobik", "sobaka");
        return map;
    }

    public static void main(String[] args) {
        System.out.println(fill(new ArrayList<String>()));
        System.out.println(fill(new LinkedList<String>()));
        System.out.println(fill(new HashSet<String>()));
        System.out.println(fill(new TreeSet<String>()));
        System.out.println(fill(new LinkedHashSet<String>()));
        System.out.println(fill(new HashMap<String, String>()));
        System.out.println(fill(new TreeMap<String, String>()));
        System.out.println(fill(new LinkedHashMap<String, String>()));


    }
}
