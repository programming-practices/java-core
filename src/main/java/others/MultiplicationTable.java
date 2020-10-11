package others;


public class MultiplicationTable {
    public static void main(String[] args) {
        int[][] table = new int[10][10];

        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                table[i][j] = i * j;
            }
        }

        printTable(table);
    }

    public static void printTable(int[][] table) {
        System.out.println("  _ " + "1 " + "2 " + "3 " + "4 " + "5 " + "6 " + "7 " + "8 " + "9 _");
        for (int i = 1; i < 10; i++) {
            System.out.print(i + "|  ");
            for (int j = 1; j < 10; j++) {
                System.out.print(table[i][j] + " ");
            }
            System.out.println();
        }
    }
}
