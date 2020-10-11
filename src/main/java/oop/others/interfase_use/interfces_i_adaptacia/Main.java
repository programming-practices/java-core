package Examples.OOP.Others.interfase_use.interfces_i_adaptacia;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner c = new Scanner(new RandomWords(10));
        while (c.hasNext()) System.out.println(c.next());
    }
}
