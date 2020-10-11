package operators;

public class TernaryOperator {
    public static void main(String[] args) {
// ---------------------------------------------------------------------------------------------------------------------
        int luck_1 = 10;
        int luck_2 = 10;
//        if ((luck > 10 ? luck++ : luck--) < 10) {
//            System.out.println("Bear");
//        }
//        if (luck < 10){
//            System.out.println("Shark");
//        }

        System.out.println((luck_1 > 10 ? luck_1++ : luck_1--) < 10);
        System.out.println((luck_1 > 10 ? luck_1++ : luck_1--));
        System.out.println("------");
        System.out.println((luck_2 > 10 ? luck_2++ : --luck_2) < 10);
        System.out.println((luck_2 > 10 ? luck_2++ : --luck_2));
// ---------------------------------------------------------------------------------------------------------------------

        //int x = 5;
        //int x = 2;
        int x = 8;
        System.out.println(x > 2 ? x < 4 ? 10 : 8 : 7);

        /*

        x > 2 ?
            (x < 4 ? 10
                      :
                   8
            ):
            7

            link: http://www.java2s.com/Tutorials/Java/OCA_Java_SE_8_Operators_Statements/Q2-2.htm
        */

// ---------------------------------------------------------------------------------------------------------------------
    }
}
