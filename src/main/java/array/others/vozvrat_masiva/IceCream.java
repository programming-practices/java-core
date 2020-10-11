package array.others.vozvrat_masiva;

import java.util.Arrays;
import java.util.Random;

public class IceCream {
    static final String[] FLAVORS = {
            "Chocolate", "Strawberry", "Vanilla Fudge Swirl",
            "Mint Chip", "Mocha Almond Fudge", "Rum Raisin",
            "Praline Cream", "Mud Pie"
    };
    private static Random rand = new Random(47);

    public static String[] flavorSet(int quantityOfFlavors) {

        if (quantityOfFlavors > FLAVORS.length) throw new IllegalArgumentException("Set too big");

        String[] results = new String[quantityOfFlavors];

        boolean[] picked = new boolean[FLAVORS.length];

        for (int i = 0; i < quantityOfFlavors; i++) {

            int randomFlavorIndex;
            do
                randomFlavorIndex = rand.nextInt(FLAVORS.length);
            while (picked[randomFlavorIndex]);
            results[i] = FLAVORS[randomFlavorIndex];
            picked[randomFlavorIndex] = true;
        }
        return results;
    }

    public static void main(String[] args) {

        for (int i = 0; i < 7; i++) System.out.println(Arrays.toString(flavorSet(3)));
    }
}
