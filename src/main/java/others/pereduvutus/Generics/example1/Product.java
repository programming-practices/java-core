package YouTube_Channels.Onlain_yroki_po_Java.Generics.example1;

public class Product<T> implements Comparable<Product> {
    private String name;
    private int price;

    public boolean isSomeProduct(Product product) {
        if (this.isSomeProduct(product)) {
            return true;
        }
        return false;
    }

    @Override
    public int compareTo(Product o) {
        if (o.price > this.price) {
            return 1;
        }
        return 0;
    }

    public boolean subCompare(T p) {
        if (p instanceof Product) {
            return true;
        }
        return false;
    }
}
