package generics.Bazovue_tipu_i_ynasledovanui_kod;

public class PruebasDeCastingIntegerDouble {
    public static void main(String[] args) {
        double d;
        int i = 31;
        d = i;
        System.out.println("d = " + d);
        // OUT 31.0

        Double dd = null;
        Integer ii = new Integer(31);
//        dd = (Double) ii;   // ERROR COMPILATION
        dd = ii.doubleValue();
        System.out.println("dd = " + dd);

        Double ddd = null;
        Integer iii = new Integer(31);
        Object o = iii;
//        dd = (Double) o;   // ERROR RUN TIME
//        dd = (Double) ((Integer) o);   // ERROR COMPILATION
        dd = ((Integer) o).doubleValue();

    }
}
