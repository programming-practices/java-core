package Examples.Others.zapolnenie_conteinerov;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class StringAddress {
    private String addres;

    public StringAddress(String addres) {
        this.addres = addres;
    }

    public String toString() {
        return " " + addres;
    }

}

public class FillingLists {

    public static void main(String[] args) {

        List<StringAddress> list = new ArrayList<StringAddress>(Collections.nCopies(4, new StringAddress("Hello")));

        System.out.println(list);

        Collections.fill(list, new StringAddress("World!"));
        System.out.println(list);

//        List<StringAddress> list1= new ArrayList<StringAddress>(5);
//        list1.add(new StringAddress("qqq"));
//        Collections.fill(list1, new StringAddress("World!"));
//
//        System.out.println(list1);

    }
}
