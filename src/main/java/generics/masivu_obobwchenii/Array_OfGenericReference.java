package generics.masivu_obobwchenii;


import java.util.Arrays;

public class Array_OfGenericReference {
    static Generic<Integer>[] gia;

    public static void main(String[] args) {

        gia = new Generic[10];

//        gia[0] = (Integer)1;
        gia[0] = new Generic<>(1);

        System.out.println(Arrays.toString(gia));

    }
}


class Generic<T> {

    public final T value;

    public Generic(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
