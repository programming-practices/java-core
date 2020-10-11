package generics.postroenie_sloznux_modelei;

import generics.biblioteka_kortezei.Amphibian;
import generics.biblioteka_kortezei.FourTuple;
import generics.biblioteka_kortezei.TupleTest;
import generics.biblioteka_kortezei.Vehicle;

import java.util.ArrayList;

public class TupleList<A, B, C, D> extends ArrayList<FourTuple<A, B, C, D>> {

    public static void main(String[] args) {

        TupleList<Vehicle, Amphibian, String, Integer> tl = new TupleList<Vehicle, Amphibian, String, Integer>();

        tl.add(TupleTest.fourTuple());
        tl.add(TupleTest.fourTuple());

        for (FourTuple<Vehicle, Amphibian, String, Integer> i : tl) System.out.println(i);
    }
}
