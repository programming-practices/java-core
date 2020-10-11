package array.multidimensional_arrays;

import array.others.osoboe_otnowenie_k_masivam.BerylliumSphere;

import java.util.Arrays;

public class MultidimensionalObjectArrays {

    public static void main(String[] args) {

        BerylliumSphere[][] spheres = {
                {new BerylliumSphere(), new BerylliumSphere()}, {new BerylliumSphere(), new BerylliumSphere(), new BerylliumSphere(), new BerylliumSphere()},
                {new BerylliumSphere(), new BerylliumSphere(), new BerylliumSphere(), new BerylliumSphere(), new BerylliumSphere(), new BerylliumSphere(), new BerylliumSphere(), new BerylliumSphere()},};

        System.out.println(Arrays.deepToString(spheres));
    }
}
