package Examples.Multithreading.Others.Golovach;

public class ILP_3_1 {
    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        double value00 = 0;
        double value01 = 0;
        double value02 = 0;
        double value03 = 0;
        double value04 = 0;
        double value05 = 0;
        double value06 = 0;
        double value07 = 0;
        double value08 = 0;
        double value09 = 0;
        double value10 = 0;
        double value11 = 0;
        for (int i = 0; i < 1_000_000_000; i++) {
            value00 = value00 * value00;
            value01 = value01 * value01;
            value02 = value02 * value02;
            value03 = value03 * value03;
            value04 = value04 * value04;
            value05 = value05 * value05;
            // 6 cepochok vupovniaetsia odnovremenno
//            value06 = value06 * value06;
//            value07 = value07 * value07;
//            value08 = value08 * value08;
//            value09 = value09 * value09;
//            value10 = value10 * value10;
//            value11 = value11 * value11;
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        System.out.println(value02 - value01);

    }
}
