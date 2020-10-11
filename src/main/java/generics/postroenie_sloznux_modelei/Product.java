package generics.postroenie_sloznux_modelei;

import others.entities.Generator;

import java.util.Random;

public class Product {

    public static Generator<Product> generator = new Generator<Product>() {
        private Random rand = new Random(47);

        public Product next() {
            return new Product(rand.nextInt(1000), "tem.Test", Math.round(rand.nextDouble() * 1000.0) + 0.99);
        }
    };
    private final int id;
    private String description;
    private double price;

    public Product(int IDnumber, String descr, double price) {
        id = IDnumber;
        description = descr;
        this.price = price;
        System.out.println(toString());
    }

    public String toString() {
        return id + ": " + description + ", price: $" + price;
    }

    public void priceChange(double change) {
        price += change;
    }
}
