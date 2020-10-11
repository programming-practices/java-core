package generics.random_list;

import java.util.ArrayList;
import java.util.Random;

public class RandomList<T> {
    private ArrayList<T> storage = new ArrayList<T>();
    private Random rand = new Random();

    public static void main(String[] args) {
        RandomList<String> rs = new RandomList<String>();
        for (String s : ("The quick brown fox jumped over the lazy brown dog").split(" ")) rs.add(s);

        RandomList<Integer> rs1 = new RandomList<>();
        rs1.add(3);
        rs1.add(9);
        rs1.add(5);
        rs1.add(7);
        rs1.add(1);
        rs1.add(33);
        rs1.add(54);
        rs1.add(12);
        rs1.add(35);
        rs1.add(16);
        rs1.add(61);
        RandomList<Character> rs2 = new RandomList<>();
        rs2.add('w');
        rs2.add('f');
        rs2.add('q');
        rs2.add('!');
        rs2.add('$');
        rs2.add('e');
        rs2.add('r');
        rs2.add('t');
        rs2.add('y');
        rs2.add('u');
        rs2.add('c');

        for (int i = 0; i < 11; i++) System.out.print(rs.select() + " ");
        System.out.println();

        for (int i = 0; i < 11; i++) System.out.print(rs1.select() + " ");
        System.out.println();

        for (int i = 0; i < 11; i++) System.out.print(rs2.select() + " ");
    }

    public void add(T item) {
        storage.add(item);
    }

    public T select() {
        return storage.get(rand.nextInt(storage.size()));
    }
}
