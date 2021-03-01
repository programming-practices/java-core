package memory_model;

/*
 * Sources:
 *      1. https://www.youtube.com/watch?v=inBUNUOrFVI&list=PLoij6udfBncilPJMzXtsOyUutDDULrtEm     Golovach
 *      2.  https://www.youtube.com/watch?v=AxL5LgoQyNs
 *      3.  https://www.youtube.com/watch?v=msCqh8Mn37A
 *
 * */
public class ExampleStake {
    private static int counter_0 = 0;
    private static int counter_10 = 0;

    public static void main(String[] args) {
// ---------------------------------------------------------------------------------------------------------------------
//        try {
//            test_0();
//        } catch (StackOverflowError ignore){
//            System.out.println(counter_0);
//            System.out.println("Error in test_0()");
//        }
//        try {
//            test_10();
//        }catch (StackOverflowError ignore){
//            System.out.println(counter_10);
//            System.out.println("Error in test_10()");
//        }
// ---------------------------------------------------------------------------------------------------------------------
//        main(args);
//
// ---------------------------------------------------------------------------------------------------------------------
    }

    private static void test_0() {
        counter_0++;
        test_0();
    }

    private static void test_10() {
        long L0 = 0;
        long L1 = 0;
        long L2 = 0;
        long L3 = 0;
        long L4 = 0;
        long L5 = 0;
        long L6 = 0;
        long L7 = 0;
        long L8 = 0;
        counter_10++;
        test_10();
    }
}

/*

========================================================================================================================
Stekov mozet bit mnoho, na kazdui potok zavoditsa svoi stek
------------------------------------------------------------------------------------------------------------------------
Stake xranit v sebe: prostue tipu, ssulki na obektu, localnue peremennue
------------------------------------------------------------------------------------------------------------------------
Gerbage Collecor ne rabotaet v Stake
------------------------------------------------------------------------------------------------------------------------
*/
