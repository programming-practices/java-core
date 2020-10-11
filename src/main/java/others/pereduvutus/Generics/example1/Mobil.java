package YouTube_Channels.Onlain_yroki_po_Java.Generics.example1;

public class Mobil extends Product<Mobil> implements Portable {
    private String model;
    private int price;

    @Override
    public boolean subCompare(Mobil p) {

        return true;
    }
}
