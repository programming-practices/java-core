package stringAPI._string;

class WaterSource {
    private String s;

    WaterSource() {
        System.out.println("WaterSource()");
        s = "Constructed";
    }

    public String toString() {
        return s;
    }
}

public class SprinklerSystem {
    private String valve1, valve2, valve3, valve4;
    private WaterSource source = new WaterSource();
    private int i;
    private float f;

    public static void main(String[] args) {
        SprinklerSystem sprinklers = new SprinklerSystem();
//        System.out.println(sprinklers.toString());
//        System.out.println(sprinklers.toString1());
        System.out.println(sprinklers.toString2());
//        System.out.println(sprinklers.toString3());
//        System.out.println(sprinklers.toString4());
    }

    //    public String toString4() {
//        StringBuilder sb = new StringBuilder();
//        sb.append("valve1 = " + valve1 + " " +
//                "valve2 = " + valve2 + " " +
//                "valve3 = " + valve3 + " " +
//                "valve4 = " + valve4 + "\n" +
//                "i = " + i + "     " + "fArgInt = " + fArgInt + "      " +
//                "source = " + source);
//        return sb.toString();
//    }
//
//
//    public String toString1() {
//        StringBuilder sb = new StringBuilder("valve1 = " + valve1 + " " +
//                "valve2 = " + valve2 + " " +
//                "valve3 = " + valve3 + " " +
//                "valve4 = " + valve4 + "\n" +
//                "i = " + i + "     " + "fArgInt = " + fArgInt + "      " +
//                "source = " + source);
//        return sb.toString();
//    }
//
//    public String toString3() {
//        String ss = "valve1 = " + valve1 + " " +
//                "valve2 = " + valve2 + " " +
//                "valve3 = " + valve3 + " " +
//                "valve4 = " + valve4 + "\n" +
//                "i = " + i + "     " + "fArgInt = " + fArgInt + "      " +
//                "source = " + source;
//
//        return ss;
//    }
//
    public String toString2() {

        return "valve1 = " + valve1 + " " +
                "valve2 = " + valve2 + " " +
                "valve3 = " + valve3 + " " +
                "valve4 = " + valve4 + "\n" +
                "i = " + i + "     " + "fArgInt = " + f + "      " +
                "source = " + source;
    }
}
