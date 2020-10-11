package oop;

import java.util.LinkedList;
import java.util.List;

/*
Source:
    https://habr.com/post/332578/
*/

public class ExampleInterfaceBasedProgramming {
    public static void main(String[] args) {
        ListClientExample lce = new ListClientExample();
        @SuppressWarnings("rawtypes")
        List list = lce.getList();
        System.out.println(list);
    }
}

class ListClientExample {
    @SuppressWarnings("rawtypes")
    private List list;

    @SuppressWarnings("rawtypes")
    public ListClientExample() {
        list = new LinkedList();
    }

    @SuppressWarnings("rawtypes")
    public List getList() {
        return list;
    }
}