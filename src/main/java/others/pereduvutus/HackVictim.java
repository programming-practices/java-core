package others.pereduvutus;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class HackVictim {

    public static void main(String[] args) {

        try {
            HackVictim.doHack();
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public static void doHack() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {

        Victim victim = new Victim();
        System.out.println("Current secure code: " + victim.getSecureCode());

        Method method = Victim.class.getDeclaredMethod("setSecureCode", int.class);
        method.setAccessible(true);
        method.invoke(victim, 32);
        System.out.println("Current secure code: " + victim.getSecureCode());

        Field field = Victim.class.getDeclaredField("secureCode");
        field.setAccessible(true);
        field.set(victim, 11);
        System.out.println("Current secure code: " + victim.getSecureCode());
    }
}
