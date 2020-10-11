package Examples.OOP.Others.polimorfizm.polimorfizm_Rabota_S_Poliami;

public class Main {
    public static void main(String[] args) {
        Super s = new Sub();
        System.out.println("s.file = " + s.fild + ", " +
                "s.getField = " + s.getFild() + ", ");

        Sub s1 = new Sub();
        System.out.println("s1.file = " + s1.fild + ", " +
                "s.getField = " + s1.getFild() + ", " +
                "s.getFiledSuper = " + s1.getFildSuper());
    }
}
