package annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;


public class Pruebas {
    public static void main(String[] args) {

        Class annotation0 = LazyService.class;
        Annotation[] annotations00 = annotation0.getAnnotations();
        System.out.println("-----------------------Annotations for class LazyService-----------------------");
        for (Annotation a : annotations00) {
            System.out.println(a.toString());
        }
        System.out.println("------------------------------------------------------------------------------");
        System.out.println();

        Class annotation1 = SimpleService.class;
        Annotation[] annotations11 = annotation1.getAnnotations();
        System.out.println("-----------------------Annotations for class SimpleService---------------------");
        for (Annotation aa : annotations11) {
            System.out.println(aa.toString());
        }
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println();


        Class methods0 = LazyService.class;
        Method[] methods00 = methods0.getMethods();
        System.out.println("-----------------------Methods for class LazyService-----------------------");
        for (Method m : methods00) {
            System.out.println(m.toString());
        }
        System.out.println("------------------------------------------------------------------------------");
        System.out.println();

        Class methods1 = SimpleService.class;
        Method[] methods11 = methods1.getMethods();
        System.out.println("-----------------------Methods for class SimpleService---------------------");
        for (Method m : methods11) {
            System.out.println(m.toString());
        }
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println();
    }
}
