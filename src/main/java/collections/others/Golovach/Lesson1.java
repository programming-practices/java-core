package collections.others.Golovach;

import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Lesson1 {

    public static void main(String[] args) {

        /*List<String> list = new ArrayList<>(asList("V", "A", "Q", "BB", "CCC", "A"));
        System.out.println(list);
        System.out.println();

        List<String> list1 = new ArrayList<>(new HashSet<>(list));
        System.out.println(list1);
        System.out.println();

        Collections.sort(list1);
        System.out.println(list1);
*/

//        List<String> list3 = /*new ArrayList<>(*/asList("V", "A", "Q", "BB", "CCC", "A")/*)*/;   //  aslist vozvrawchaet ne mutiryewchii list
//        list3.remove(0); // ERROR    etot list ne mytiryewchii
//        list3.add("E"); // ERROR    etot list ne mytiryewchii

//
//        fArgInt("w");
//        fArgInt("w",1);
//        fArgInt("w",1,6,3);
//        fArgInt("w",9,4,1,4,0);


//        f2(9,4,1,4,0);
//        f2(9,4,1);
//        f2(9,4);
////        f2(9);        //ERROR
////        f2();           //ERROR

        List<String> list3 = new ArrayList<>(asList("V", "A", "Q", "BB", "CCC", "A"));

//        Iterator<String> iterator = list3.iterator();

//        while(iterator.hasNext()){
//            System.out.println(iterator.next());
//        }


        for (Iterator<String> iterator = list3.iterator(); iterator.hasNext(); ) {
            System.out.println(iterator.next());
        }
    }


//    public static void fArgInt(String s, int... arg){
//
//        String s1 = s;
//        for(int i : arg){
//            System.out.print(i + ", ");
//        }
//
//    }


    public static void f2(int fst, int snd, int... others) {

    }

    public static void f3(Children ch1, Children... others) {

    }

    class Children {
    }
}
