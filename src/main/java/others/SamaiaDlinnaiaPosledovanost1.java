package Examples.Others;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SamaiaDlinnaiaPosledovanost1 {
    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> listCouters = new ArrayList<>();
        int cout = 1;
        int couterValue = 0;
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
//        for (int i = 0; i < 10; i++){
//            list.add(Integer.parseInt(reader.readLine()));
//        }

        for (int i = list.size() - 1; i >= 1; i--) {


            if (i > 0) {
                System.out.println(i);
                if (list.get(i) == list.get(i - 1)) {
                    couterValue = list.get(i);
                }

                if (couterValue == list.get(i)) {
                    cout++;
                    System.out.println(couterValue);
                    System.out.println(list.get(i));
                    System.out.println(cout);
                    System.out.println("");
                } else if (couterValue > 0) {
                    listCouters.add(cout);
                    couterValue = 0;
                    cout = 1;
                    System.out.println(couterValue);
                    System.out.println(cout);
                    System.out.println("");
                }
            }
        }

        for (int a : listCouters) {
            System.out.println(a);
        }
    }
}
