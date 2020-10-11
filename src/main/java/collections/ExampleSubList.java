package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExampleSubList {
    public static void main(String[] args) {
//---------------------------------------------------------------------------------------------------------------------

        List<String> color_list = new ArrayList<>(Arrays.asList("White", "Black", "Red", "Green", "Yellow"));

        System.out.println("List of the colors :" + color_list);

        //Return portion of the list : fromindex(inclusive)->1,  toindex(exclusive)->3
        ArrayList<String> new_color_list1 = new ArrayList<>(color_list.subList(1, 3));
        System.out.println("Portion of the list: " + new_color_list1);

        //Return empty list as fromindex and toindex are equal
        ArrayList<String> new_color_list2 = new ArrayList<String>(color_list.subList(3, 3));
        System.out.println("Portion of the list: " + new_color_list2);

//---------------------------------------------------------------------------------------------------------------------
    }
}
