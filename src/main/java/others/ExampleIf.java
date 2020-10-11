package others;

public class ExampleIf {
    public static void main(String[] args) {
// ---------------------------------------------------------------------------------------------------------------------
        int luck = 10;
        if ((luck > 10 ? luck++ : luck--) < 10) {
            System.out.println("Bear");
        }
//        if (luck < 10){
//            System.out.println("Shark");
//        }

        System.out.println((luck > 10 ? luck++ : luck--) < 10);
        System.out.println((luck > 10 ? luck++ : luck--));
// ---------------------------------------------------------------------------------------------------------------------
    }
}
