package YouTube_Channels.Onlain_yroki_po_Java.Generics.example1;

public class Computer extends Product {
    private String model;
    private int price;

    //@Override
    public boolean subCompare(Product p) {
        if (p instanceof Computer) {

            return true;
        }
        return false;
    }
}
