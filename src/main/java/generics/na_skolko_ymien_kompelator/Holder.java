package generics.na_skolko_ymien_kompelator;

import others.entities.Apple;
import others.entities.Fruit;
import others.entities.Orange;

public class Holder<T> {
    private T value;

    public Holder() {
    }

    public Holder(T val) {
        value = val;
    }

    public static void main(String[] args) {

        Holder<Apple> apple = new Holder<Apple>(new Apple());

        Apple d = apple.get();
        apple.set(d);

        // HolderValuesInt<Fruit> Fruit = apple; // Cannot upcast
        Holder<? extends Fruit> fruit = apple; // OK
        Fruit p = fruit.get();
        d = (Apple) fruit.get(); // Returns 'Object'

        try {
            Orange c = (Orange) fruit.get(); // No warning
        } catch (Exception e) {

            System.out.println(e);
        }

//         fruit.set(new Apple()); // Cannot call set()
//         fruit.set(new Fruit()); // Cannot call set()
        System.out.println(fruit.equals(d)); // OK
    }

    public void set(T val) {
        value = val;
    }

    public T get() {
        return value;
    }

    public boolean equals(Object obj) {
        return value.equals(obj);
    }
}
