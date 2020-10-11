package idioms;

public class ExchangesOfVariablesIdiom {
    public static void main(String[] args) {
//======================================================================================================================
//================================================ variable swapping ===================================================
//======================================================================================================================

        int value_A = 3;
        int value_B = 5;
        System.out.println("value_A = " + value_A);
        System.out.println("value_B = " + value_B);
        int tmp1 = value_A;
        value_A = value_B;
        value_B = tmp1;
        System.out.println("value_A = " + value_A);
        System.out.println("value_B = " + value_B);
        System.out.println("------------------------------------");

//======================================================================================================================
//================================ The two implementations work only with "int"  =======================================
//======================================================================================================================

        int value_C = 3;
        int value_D = 5;
        System.out.println("value_C = " + value_C);
        System.out.println("value_D = " + value_D);
        value_C = value_C + value_D;  // value_C = 8, value_D = 5
        value_D = value_C - value_D;  // value_C = 8, value_D = 3
        value_C = value_C - value_D;  // value_C = 5, value_D = 3
        System.out.println("value_C = " + value_C);
        System.out.println("value_D = " + value_D);
        System.out.println("-------------------------------------");

        int value_E = 3;
        int value_F = 5;
        System.out.println("value_E = " + value_E);
        System.out.println("value_F = " + value_F);
        value_E = value_E ^ value_F;
        value_F = value_E ^ value_F;
        value_E = value_E ^ value_F;
        System.out.println("value_E = " + value_E);
        System.out.println("value_F = " + value_F);
        System.out.println("------------------------------------");

//======================================================================================================================
//======================================================================================================================
//======================================================================================================================
    }
}
