package YouTube_Channels.Onlain_yroki_po_Java.Generics.example1;

public class MP3Player extends Product implements Portable {
    private String model;
    private int price;

    // @Override
    public boolean subCompare(Product p) {
        if (p instanceof MP3Player) {

            return true;
        }
        return false;
    }
}
