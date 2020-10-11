package generics.masivu_obobwchenii;

public class GenericArray<T> {
    private T[] array;

    @SuppressWarnings("unchecked")
    public GenericArray(int sz) {
        array = (T[]) new Object[sz];
    }

    public static void main(String[] args) {

        GenericArray<Integer> gai = new GenericArray<Integer>(10);
        // This causes a ClassCastException:
//        Integer[] ia = gai.rep();
//        Integer[] ia2 = (Integer[]) gai.rep();
        // This is OK:
        Object[] oa = gai.rep();
        gai.put(0, 1);
        gai.put(1, 2);
        gai.put(2, 3);
        System.out.println(gai.get(0));
        System.out.println(gai.get(1));
        System.out.println(gai.get(2));
    }

    public void put(int index, T item) {
        array[index] = item;
    }

    public T get(int index) {
        return array[index];
    }

    // Method that exposes the underlying representation:
    public T[] rep() {
        return array;
    }
}
