package additional;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class Example00 {
    public static void main(String[] args) {

        List<String> list = Arrays.asList("Hello?", "Bye!");
//------------------------------------------------------------------------------
//
//        for(int i = 0; i < list.size(); i++){
//            System.out.println(list.get(i));
//        }
//        System.out.println("-----------fori---------");
//
//        for(String s : list){
//            System.out.println(s);
//        }
//        System.out.println("-----------forech---------");
//
//        for(Iterator<String> itr = list.iterator(); itr.hasNext();){
//            System.out.println(itr.next());
//        }
//        System.out.println("-----------for???---------");

//--------------------------------------------------------------------------------

//        list.forEach(System.out::println);

//--------------------------------------------------------------------------------

//        list.forEach(new Consumer<String>() {
//            @Override
//            public void accept(String s) {
//                System.out.println(s);
//            }
//        });

//        list.forEach(s -> System.out.println(s));

        Consumer<? super String> methodRef = System.out::println;
        list.forEach(methodRef);

//        list.forEach(System.out::println);

//-------------------------------------------------------------------------------

//        Itr itr = new Itr();
//        while(itr.hasNext()) System.out.println(itr.next());

//-------------------------------------------------------------------------------


//        asList("Hello?", "Bye!").


// -------------------------------------------------------------------------------
    }
}


// Iterator po vsem parnnum chislam
class Itr implements Iterator<Long> {

    long value = 0;

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public Long next() {
        return value += 2;
    }
}
