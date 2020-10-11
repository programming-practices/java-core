package Examples.OOP.Others.interfase_use.interfces_i_adaptacia;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Random;

public class RandomWords implements Readable {

    private static final char[] capitals = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private static final char[] lowers = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    private static final char[] vowels = "aeiou".toCharArray();
    private static Random random = new Random(47);
    private int count;

    public RandomWords(int count) {
        this.count = count;
    }

    @Override
    public int read(CharBuffer cb) throws IOException {
        if (count-- == 0) return -1;
        cb.append(capitals[random.nextInt(capitals.length)]);
        for (int i = 0; i < 4; i++) {
            cb.append(vowels[random.nextInt(vowels.length)]);
            cb.append(lowers[random.nextInt(lowers.length)]);
        }
        cb.append(" ");
        return 10;
    }
}
