package generics.privedenie_tipov_predyprezdenia;

import java.util.ArrayList;

class FixedSizeStack<T> {

    private int index = 0;
    //    private Object[] storage;
    private ArrayList<T> storage;

    public FixedSizeStack(int lenght) {
        index = lenght;
        storage = new ArrayList<>(lenght);
    }

    public void push(T item) {
        storage.add(item);
    }

    @SuppressWarnings("unchecked")
    public T pop() {
        return (T) storage.get(index = index - 1);

    }
}

public class GenericCast {
    public static final int SIZE = 10;

    public static void main(String[] args) {

        FixedSizeStack<String> strings = new FixedSizeStack<String>(SIZE);

        for (String s : "A B C D E F G H I J".split(" ")) strings.push(s);

        for (int i = 0; i < SIZE; i++) {
            String s = strings.pop();
            System.out.print(s + " ");
        }
    }
}
