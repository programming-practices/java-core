package Examples.OOP.Others.ispolzovanie_classov_Abstract;

import java.util.AbstractList;

public class CountingIntegerList extends AbstractList<Integer> {
    private int size;

    public CountingIntegerList(int size) {
        this.size = size < 0 ? 0 : size;
    }

    public static void main(String[] args) {

        System.out.println(new CountingIntegerList(30));

    }

    public Integer get(int index) {
        return Integer.valueOf(index);
    }

    public int size() {
        return size;
    }
}
