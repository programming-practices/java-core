package others;

public class ExampleInfinityNaN {
    public static void main(String[] args) {
// ---------------------------------------------------------------------------------------------------------------------
//        double infin = Double.POSITIVE_INFINITY;
//        double infin = Double.NEGATIVE_INFINITY;
//        double nan = Double.NaN;;

        double infin = 1.0 / 0;
        double nan = 0.0 / 0;

        System.out.println("infin < 0 = " + (infin < 0));
        System.out.println("infin > 0 = " + (infin > 0));
        System.out.println("infin == infin = " + (infin == infin));
        System.out.println("infin < nan = " + (infin < nan));
        System.out.println("infin > nan = " + (infin > nan));
        System.out.println("infin == nan = " + (infin == nan));
        System.out.println("------------");

        System.out.println("nan < 0 = " + (nan < 0));
        System.out.println("nan > 0 = " + (nan > 0));
        System.out.println("nan == nan = " + (nan == nan));
        System.out.println("nan > infin = " + (nan > infin));
        System.out.println("nan < infin = " + (nan < infin));
        System.out.println("nan == infin =" + (nan == infin));

// ---------------------------------------------------------------------------------------------------------------------
    }
}
