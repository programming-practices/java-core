package reflection_api;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class ExampleReflectionModifier {
    public static void main(String[] args) {
//---------------------------------------------------------------------------------------------------------------------
//        // Исследование модификаторa класса
        MyClassForTests myClass00 = new MyClassForTests();
        Class c = myClass00.getClass();
        int mods = c.getModifiers();
        if (Modifier.isPublic(mods)) {
            System.out.println("Class is public");
        }
        if (Modifier.isAbstract(mods)) {
            System.out.println("Class is abstract");
        }
        if (Modifier.isFinal(mods)) {
            System.out.println("Class is final");
        }
        if (Modifier.isProtected(mods)) {
            System.out.println("Class is protected");
        }
        if (Modifier.isStatic(mods)) {
            System.out.println("Class is static");
        }
        if (Modifier.isInterface(mods)) {
            System.out.println("Class is Interface");
        }
//---------------------------------------------------------------------------------------------------------------------
        // Исследование, получение и установка значений полей класса.
        MyClassForTests myClass01 = new MyClassForTests();
        Class class03 = myClass01.getClass();
        Field[] fields = class03.getDeclaredFields();
        System.out.println("\nClass have fields:");
        for (Field field : fields) {
            Class fieldType = field.getType();
            int modifier = field.getModifiers();
            StringBuilder modiferValue = new StringBuilder();
            if (Modifier.isPublic(modifier)) {
                modiferValue.append("public");
                modiferValue.append(", ");
            }
            if (Modifier.isProtected(mods)) {
                modiferValue.append("protected");
                modiferValue.append(", ");
            }
            if (Modifier.isFinal(mods)) {
                modiferValue.append("final");
                modiferValue.append(", ");
            }
            if (Modifier.isStatic(mods)) {
                modiferValue.append("static");
            }
            System.out.println("     FIELD NAME IS: " + field.getName() +
                    ", FIELD TYPE IS: " + fieldType.getSimpleName() +
                    " , FIELD MODIFERS IS: " + modiferValue);
        }
//---------------------------------------------------------------------------------------------------------------------
    }
}

/*
----------------------------------------------------------------------------------------------------------------------
•static String toString(int modifiers)
    Возвращает символьную строку с модификаторами, соответствующими битам, установленным в це­
    лочисленном значении параметра modifiers.

•static boolean isAbstract (int modifiers)
•static boolean isFinal(int modifiers)
•static boolean isInterface (int modifiers)
•static boolean isNative(int modifiers)
•static boolean isPrivate (int modifiers)
•static boolean isProtected(int modifiers)
•static boolean isPublic(int modifiers)
•static boolean isStatic(int modifiers)
•static boolean isStrict(int modifiers)
•static boolean isSynchronized(int modifiers)
•static boolean isVolatile (int modifiers)
    Проверяют разряды целого значения параметра modifiers, которые соответствуют модификато­
    рам доступа, указываемым при объявлении методов.
----------------------------------------------------------------------------------------------------------------------
*/
