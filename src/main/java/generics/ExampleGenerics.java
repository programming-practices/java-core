package generics;

import java.util.ArrayList;
import java.util.List;

public class ExampleGenerics {

    public static <E extends CharSequence> List<? super E> doIt(List<E> nums) {
        return null;
    }

    public static void main(String[] args) {

//        List<String> in = new ArrayList<>();
//        List<Object> result = doIt(in);

//        List<Object> in = new ArrayList<>();
//        List<CharSequence> result = doIt(in);

//        List<String> in = new ArrayList<>();
//        List<CharSequence> result = doIt(in);

        List<String> in = new ArrayList<>();
        List result = doIt(in);

//        List<CharSequence> in1 = new ArrayList<>();
//        List<CharSequence> result1 = doIt(in);


    }

}

/*
* Какого типа должны быть result и in?
*
    ArrayList<String> in; List<CharSequence> result;
    List<String> in; List<Object> result;
    ArrayList<String> in; List result;
    List<CharSequence> in; List<CharSequence> result;
    ArrayList<Object> in; List<CharSequence> result;
*/
