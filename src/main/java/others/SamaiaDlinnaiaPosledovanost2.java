package Examples.Others;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class SamaiaDlinnaiaPosledovanost2 {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(4);
        list.add(4);
        list.add(4);
        list.add(8);
        list.add(8);
        list.add(9);
        list.add(12);
        list.add(12);
        list.add(14);

        ArrayList<Integer> listCouters = new ArrayList<>();
        int coutMax = 0;
        Set<Integer> set = new HashSet<>();
        set.addAll(list);
        int cout = 0;
        int couterValue = 0;

//        for (Integer integer:set) {
//            System.out.println(integer);
//        }

        for (Integer i : set) {
            for (int j = 0; j < list.size(); j++) {

                if (i == list.get(j)) {
                    cout++;
                } else {
                    listCouters.add(cout);
                    cout = 0;
                }
            }
        }

        for (Integer s : listCouters) {
            if (s > coutMax) {
                coutMax = s;
            }
        }
        System.out.println(coutMax);
    }
}
