package YouTube_Channels.Onlain_yroki_po_Java.Generics.example1;

import java.util.List;

public class Test {

    public static void main(String[] args) {
//        Containe<Product> productContaine;            // ne implementiat interface
        Containe<Mobil> mobilContaine;
//        Containe<Computer> computerContaine;         // ne implementiat interface
//        Containe<String> stringContaine;           //   ERROR
        Containe<MP3Player> mp3PlayerContaine;

        Product product = new Product();
        Product mobil = new Mobil();
        Product computer = new Computer();
        Product mp3Player = new MP3Player();
        System.out.println(mobil.subCompare(new Mobil()));
        System.out.println(mobil.subCompare(new Product()));
        System.out.println(product.subCompare(new Product()));
        System.out.println(product.subCompare(new Mobil()));

    }

    public boolean find(List<? extends Product> list, Product p) {

        for (Product product : list) {
            if (product.isSomeProduct(p)) return true;
        }
        return false;

    }
}
