package array;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Array_MakerGenerics<T> {

    private Class<T> kind;

    public Array_MakerGenerics(Class<T> kind) {
        this.kind = kind;
    }

    public static void main(String[] args) {

        Array_MakerGenerics<String> stringMaker = new Array_MakerGenerics<>(String.class);

        String[] stringArray = stringMaker.create(9);

        System.out.println(Arrays.toString(stringArray));

    }

    @SuppressWarnings("unchecked")
    T[] create(int size) {

        return (T[]) Array.newInstance(kind, size);
    }
}
