package array;

import java.util.Iterator;

public class Array_Iterator<T> implements Iterator {
    T[] items;
    int position = 0;

    public Array_Iterator(T[] items) {
        this.items = items;
    }

    public Object next() {
        T item = items[position];
        position = position + 1;
        return item;
    }

    public boolean hasNext() {
        if (position >= items.length || items[position] == null) {
            return false;
        } else {
            return true;
        }
    }
}
