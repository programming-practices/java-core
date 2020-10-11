package others;

public class SumTable {
    public static void main(String[] args) {
        int[][] table = new int[10][10];

        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                table[i][j] = i + j;
            }
        }

        MultiplicationTable.printTable(table);
    }
}
