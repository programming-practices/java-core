package generics.hranichnie_sityacii;

public class GenericHolder<T> {
    private T obj;

    public static void main(String[] args) {

        GenericHolder<String> holder = new GenericHolder<String>();

        holder.set("Item");

        String s = holder.get();

        System.out.println(s);
    }

    public void set(T obj) {
        this.obj = obj;
    }

    public T get() {
        return obj;
    }
}
