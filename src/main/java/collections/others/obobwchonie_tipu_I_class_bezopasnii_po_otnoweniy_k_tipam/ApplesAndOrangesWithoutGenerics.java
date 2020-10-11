package collections.others.obobwchonie_tipu_I_class_bezopasnii_po_otnoweniy_k_tipam;

// Prostoii primer ispolzovania Konteinerov (s priduprizdeniem compiliatora).

import java.util.ArrayList;

class Apple {
    private static long counter;
    private final long id = counter++;

    public long id() {
        return id;
    }
}

class Orange {
}

public class ApplesAndOrangesWithoutGenerics {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        ArrayList apples = new ArrayList();
        for (int i = 0; i < 3; i++) {
            apples.add(new Apple());
            // ne mewaet dobavit Orange v apples:
            apples.add(new Orange());
        }

        for (int i = 0; i < apples.size(); i++) {
            ((Apple) apples.get(i)).id();
            // Obiekt Orangee obnaryzevaetsa tolko vo vrema vipolnenia
        }
    }

}
