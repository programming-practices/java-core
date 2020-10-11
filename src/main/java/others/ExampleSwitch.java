package others;

public class ExampleSwitch {
    public static void main(String[] args) {
//----------------------------------------------------------------------------------------------------------------------
//        int count = 0;
//        int x = 3;
//        while(count++ < 3) {
//            int y = (1 + 2 * count) % 3;
//            switch(y) {
//                default:
//                case 0: x -= 1; break;
//                case 1: x += 5;
//            }
//        }
//        System.out.println(x);
//----------------------------------------------------------------------------------------------------------------------
//        switch (5) {
//            default:
//                System.out.print(0);
//            case 1:
//                System.out.print(1);
//                break;
//            case 4:
//                System.out.print(4);
//            case 2:
//                System.out.print(2);
//        }
//        System.out.println();
//        switch (4) {
//            default:
//                System.out.print(0);
//            case 1:
//                System.out.print(1);
//                break;
//            case 4:
//                System.out.print(4);
//            case 2:
//                System.out.print(2);
//        }
//        System.out.println();
//----------------------------------------------------------------------------------------------------------------------
//        switch ("BBBBBB") {
//            case "AaAaAa":
//                System.out.println("AaAaAa");
//                break;
//            case "AaAaBB":
//                System.out.println("AaAaBB");
//                break;
//            case "AaBBAa":
//                System.out.println("AaBBAa");
//                break;
//            case "AaBBBB":
//                System.out.println("AaBBBB");
//                break;
//            case "BBAaAa":
//                System.out.println("BBAaAa");
//                break;
//            case "BBAaBB":
//                System.out.println("BBAaBB");
//                break;
//            case "BBBBAa":
//                System.out.println("BBBBAa");
//                break;
//            case "BBBBBB":
//                System.out.println("BBBBBB");
//                break;
//        }
//----------------------------------------------------------------------------------------------------------------------
//        switch ("BBBBBB_8") {
//            case "AaAaAa_1":
//                System.out.println("AaAaAa_1");
//                break;
//            case "AaAaBB_2":
//                System.out.println("AaAaBB_2");
//                break;
//            case "AaBBAa_3":
//                System.out.println("AaBBAa_3");
//                break;
//            case "AaBBBB_4":
//                System.out.println("AaBBBB_4");
//                break;
//            case "BBAaAa_5":
//                System.out.println("BBAaAa_5");
//                break;
//            case "BBAaBB_6":
//                System.out.println("BBAaBB_6");
//                break;
//            case "BBBBAa_7":
//                System.out.println("BBBBAa_7");
//                break;
//            case "BBBBBB_8":
//                System.out.println("BBBBBB_8");
//                break;
//        }
//----------------------------------------------------------------------------------------------------------------------

        System.out.println(method("B"));

//----------------------------------------------------------------------------------------------------------------------
    }

    public static String method(String value) {

        switch (value) {
            case "A":
                return value.toLowerCase();
            case "B":
                return value.toLowerCase();
            case "C":
                return value.toLowerCase();
            case "D":
                return value.toLowerCase();
            case "E":
                return value.toLowerCase();
            default:
                throw new IllegalArgumentException();
        }

    }

}
