package Examples.Reflection_API;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

/**
 * This program uses reflection to print all features of a class.
 *
 * @author Cay Horstmann
 * @version 1.1 2004-02-21
 */
public class ExampleReflectionAllInformationAboutTheClass {
    public static void main(String[] args) {
        // read class name from command line args or user input
        String name;
        if (args.length > 0) name = args[0];
        else {
            Scanner in = new Scanner(System.in);
            System.out.println("Enter class name (e.g. java.util.Date): ");
            name = in.next();
        }

        try {
            // print class name and superclass name (if != Object)
            Class cl = Class.forName(name);
            Class supercl = cl.getSuperclass();
            String modifiers = Modifier.toString(cl.getModifiers());
            if (modifiers.length() > 0) System.out.print(modifiers + " ");
            System.out.print("class " + name);
            if (supercl != null && supercl != Object.class) System.out.print(" extends "
                    + supercl.getName());

            System.out.print("\n{\n");
            ClassReflectionTools.printConstructors(cl);
            System.out.println();
            ClassReflectionTools.printMethods(cl);
            System.out.println();
            ClassReflectionTools.printFields(cl);
            System.out.println();
            ClassReflectionTools.printAnotations(cl);
            System.out.println();
            ClassReflectionTools.printSuperClasses(cl);
            System.out.println("}");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }
}

class ClassReflectionTools {

    /**
     * Prints all constructors of a class
     *
     * @param cl a class
     */
    public static void printConstructors(Class cl) {
        System.out.println("Constructors: ");
        Constructor[] constructors = cl.getDeclaredConstructors();

        for (Constructor c : constructors) {
            String name = c.getName();
            System.out.print("   ");
            String modifiers = Modifier.toString(c.getModifiers());
            if (modifiers.length() > 0) System.out.print(modifiers + " ");
            System.out.print(name + "(");

            // print parameter types
            Class[] paramTypes = c.getParameterTypes();
            for (int j = 0; j < paramTypes.length; j++) {
                if (j > 0) System.out.print(", ");
                System.out.print(paramTypes[j].getName());
            }
            System.out.println(");");
        }
    }

    /**
     * Prints all methods of a class
     *
     * @param cl a class
     */
    public static void printMethods(Class cl) {
        System.out.println("Methods: ");
        Method[] methods = cl.getDeclaredMethods();

        for (Method m : methods) {
            Class retType = m.getReturnType();
            String name = m.getName();

            System.out.print("   ");
            // print modifiers, return type and method name
            String modifiers = Modifier.toString(m.getModifiers());
            if (modifiers.length() > 0) System.out.print(modifiers + " ");
            System.out.print(retType.getName() + " " + name + "(");

            // print parameter types
            Class[] paramTypes = m.getParameterTypes();
            for (int j = 0; j < paramTypes.length; j++) {
                if (j > 0) System.out.print(", ");
                System.out.print(paramTypes[j].getName());
            }
            System.out.println(");");
        }
    }

    /**
     * Prints all fields of a class
     *
     * @param cl a class
     */
    public static void printFields(Class cl) {
        System.out.println("Fields: ");
        Field[] fields = cl.getDeclaredFields();

        for (Field f : fields) {
            Class type = f.getType();
            String name = f.getName();
            System.out.print("   ");
            String modifiers = Modifier.toString(f.getModifiers());
            if (modifiers.length() > 0) System.out.print(modifiers + " ");
            System.out.println(type.getName() + " " + name + ";");
        }
    }

    /**
     * Prints all anotations of a class
     *
     * @param cl a class
     */
    public static void printAnotations(Class cl) {
        System.out.print("Anotatios: ");
        Annotation annos[] = cl.getClass().getAnnotations();
        for (Annotation age : annos) {
            if (!(annos.length == 0)) System.out.print("   for class: ");
            System.out.println(age);
        }
        System.out.println();

        Method[] methods = cl.getClass().getMethods();
        for (Method m : methods) {

            annos = m.getAnnotations();
            if (!(annos.length == 0)) System.out.print("   for method " + m.getName() + " : ");

            for (Annotation age : annos) System.out.println(age);
            annos = new Annotation[0];
        }

    }

    /**
     * Prints all super classes of a class
     *
     * @param cl a class
     */
    public static void printSuperClasses(Class cl) {
        System.out.println("SuperClasses: ");
        Class superclass = cl.getSuperclass();
        System.out.println("   " + superclass.getName());

    }

    /**
     * Prints all interfaces of a class
     *
     * @param cl a class
     */
    public static void printInterfaces(Class cl) {
        System.out.println("Interfaces: ");
        Class[] interfaces = cl.getInterfaces();
        for (Class c : interfaces) System.out.println("   " + c.getName());
    }


}
