package oop.others;

public class BitwiseOperations {
    public static void main(String[] args) {
        int x = 5, y = 7;

        x = x ^ y; // стало 2
        System.out.println(x);
        y = x ^ y; // стало 5
        System.out.println(y);
        x = x ^ y; //стало 7
        System.out.println(x);
    }
}
