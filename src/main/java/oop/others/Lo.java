package Examples.OOP.Others;

import java.util.Arrays;
import java.util.List;

public class Lo {
    public static void main(String[] args) {
        List<Integer> theNumbers = Arrays.asList(4, 8, 15, 16, 23, 42);
        int size = theNumbers.size();
        for (Integer number : theNumbers.subList(0, size - 1)) {
            System.out.print(number + ", ");
        }
        System.out.println(theNumbers.get(size - 1));
    }
}
