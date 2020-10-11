package generics.postroenie_sloznux_modelei;

import generics.obobwchenui_metod_dlya_ispolzovania_s_heneratorami.Generators;

import java.util.ArrayList;

public class Shelf extends ArrayList<Product> {

    public Shelf(int nProducts) {

        Generators.fill(this, Product.generator, nProducts);

    }
}


