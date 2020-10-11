package generics.masivu_obobwchenii;

public class GenericArray2<T> {
    private Object[] array;

    public GenericArray2(int sz) {
        array = new Object[sz];
    }

    public static void main(String[] args) {

        GenericArray2<Integer> gai = new GenericArray2<Integer>(10);

        for (int i = 0; i < 10; i++) gai.put(i, i + 2);

        for (int i = 0; i < 10; i++) System.out.print(gai.get(i) + " ");

        System.out.println();

        try {
            Object[] io = gai.rep();
            for (int i = 0; i < io.length; i++) {
                System.out.print(io[i] + ", ");
            }
            System.out.println();
//            Integer[] ia = gai.rep();
//            System.out.println(ia);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void put(int index, T item) {
        array[index] = item;
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        return (T) array[index];
    }

    @SuppressWarnings("unchecked")
    public T[] rep() {
        return (T[]) array; // Warning: unchecked cast
    }
}
