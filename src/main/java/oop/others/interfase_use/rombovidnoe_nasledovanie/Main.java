package Examples.OOP.Others.interfase_use.rombovidnoe_nasledovanie;

import java.lang.reflect.AnnotatedType;

public class Main {
    public static void main(String[] args) {
        AnnotatedType[] s = Proizvodni_3.class.getAnnotatedInterfaces();
        for (int i = 0; i < s.length; i++) {
            System.out.println("Super interfase: " + s[i]);
            AnnotatedType[] r = s[i].getClass().getAnnotatedInterfaces();
            for (int j = 0; j < r.length; j++) {
                System.out.println("Super super interfase: " + r[j]);
            }
        }
    }
}
