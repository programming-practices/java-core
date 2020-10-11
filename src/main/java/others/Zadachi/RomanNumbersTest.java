package others.Zadachi;


enum Numbers {
    M(1000), D(500), C(100), L(50), X(10), V(5), I(1);
    private int value;

    Numbers(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

public class RomanNumbersTest {
    public static void main(String[] args) {
//		String value = "LXI";
        String value = "XIV";
        RomanNumbers.decryption(value);
        System.out.println();
        RomanNumbers.cryption(14);
    }
}

class RomanNumbers {
    public static void decryption(String value) {
        String[] valueArray = value.split("");
        int valueDecimal = 0;
        for (int i = 0; i < valueArray.length; i++) {
            if (valueArray[i].equalsIgnoreCase("M")) valueDecimal = valueDecimal + 1000;
            if (valueArray[i].equalsIgnoreCase("D")) valueDecimal = valueDecimal + 500;
            if (valueArray[i].equalsIgnoreCase("C")) valueDecimal = valueDecimal + 100;
//			if(v.equalsIgnoreCase("XC")) valueDecimal = valueDecimal + 90;
//			if(v.equalsIgnoreCase("LX")) valueDecimal = valueDecimal + 60;
            if (valueArray[i].equalsIgnoreCase("L")) valueDecimal = valueDecimal + 50;
//			if(v.equalsIgnoreCase("XL")) valueDecimal = valueDecimal + 40;
            if (valueArray[i].equalsIgnoreCase("X")) valueDecimal = valueDecimal + 10;
//			if(v.equalsIgnoreCase("IX")) valueDecimal = valueDecimal + 9;
//			if(v.equalsIgnoreCase("VIII")) valueDecimal = valueDecimal + 8;
//			if(v.equalsIgnoreCase("VII")) valueDecimal = valueDecimal + 7;
//			if(v.equalsIgnoreCase("VI")) valueDecimal = valueDecimal + 6;
            if (valueArray[i].equalsIgnoreCase("V")) valueDecimal = valueDecimal + 5;
//			if(v.equalsIgnoreCase("IV")) valueDecimal = valueDecimal + 4;
//			if(v.equalsIgnoreCase("III")) valueDecimal = valueDecimal + 3;
//			if(v.equalsIgnoreCase("II")) valueDecimal = valueDecimal + 2;
            if (valueArray[i].equalsIgnoreCase("I")) valueDecimal = valueDecimal + 1;
        }
        System.out.println(valueDecimal);
    }

    public static String split(String v1, String v2) {
        return null;
    }

    public static void cryption(int value) {
        int tmp = value;
        StringBuilder s = new StringBuilder();
        do {
            while (1000 <= tmp) {
                tmp = tmp - 1000;
                s.append("M");
            }
            while (500 <= tmp) {
                tmp = tmp - 500;
                s.append("D");
            }
            while (100 <= tmp) {
                tmp = tmp - 100;
                s.append("C");
            }
            while (50 <= tmp) {
                tmp = tmp - 50;
                s.append("L");
            }
            while (10 <= tmp) {
                tmp = tmp - 10;
                s.append("X");
            }
            while (5 <= tmp) {
                tmp = tmp - 5;
                s.append("V");
            }
            while (1 <= tmp) {
                tmp = tmp - 1;
                s.append("I");
            }
        } while (tmp > 0);
        System.out.println(s.toString());
    }
}
