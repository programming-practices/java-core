package generics.postroenie_sloznux_modelei;

import java.util.ArrayList;

public class Aisle extends ArrayList<Shelf> {

    public Aisle(int nShelves, int nProducts) {

        for (int i = 0; i < nShelves; i++) add(new Shelf(nProducts));

    }
}
