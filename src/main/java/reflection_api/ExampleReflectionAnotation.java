package Examples.Reflection_API;

import java.lang.annotation.Annotation;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

//---------------------------------------------------------------------------------------------------------------------
// Show all annotations for age class and age method.
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnno2 {
    String str();

    int val();
}

@Retention(RetentionPolicy.RUNTIME)
@interface What2 {
    String description();
}

//---------------------------------------------------------------------------------------------------------------------
// Demonstrate age repeated annotation.
// Make MyAnno repeatable
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(MyRepeatedAnnos3.class)
@interface MyAnno3 {
    String str() default "Testing";

    int val() default 9000;
}

// This is the container annotation.
@Retention(RetentionPolicy.RUNTIME)
@interface MyRepeatedAnnos3 {
    MyAnno3[] value();
}

//---------------------------------------------------------------------------------------------------------------------
// An annotation type declaration.
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnno {
    String str();

    int val();
}

//---------------------------------------------------------------------------------------------------------------------
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnno4 {
    String str();

    int val();
}

public class ExampleReflectionAnotation {
    public static void main(String args[]) {

        Meta.myMeth();

        System.out.println();
        System.out.println("-----------------------------------------------------");
        System.out.println();

        Meta2.myMeth();

        System.out.println();
        System.out.println("-----------------------------------------------------");
        System.out.println();

        RepeatAnno3.myMeth("test", 10);

        System.out.println();
        System.out.println("-----------------------------------------------------");
        System.out.println();

        Meta4.myMeth("test", 10);
    }
}

@What2(description = "An annotation test class")
@MyAnno2(str = "Meta2", val = 99)
class Meta2 {

    @What2(description = "An annotation test method")
    @MyAnno2(str = "Testing", val = 100)
    public static void myMeth() {
        Meta2 ob = new Meta2();

        try {
            Annotation annos[] = ob.getClass().getAnnotations();

            // Display all annotations for Meta2.
            System.out.println("All annotations for class Meta2:");
            for (Annotation age : annos)
                System.out.println(age);

            System.out.println();

            // Display all annotations for myMeth.
            Method m = ob.getClass().getMethod("myMeth");
            annos = m.getAnnotations();

            System.out.println("All annotations for method myMeth:");
            for (Annotation age : annos)
                System.out.println(age);

        } catch (NoSuchMethodException exc) {
            System.out.println("Method Not Found.");
        }
    }
}

class RepeatAnno3 {

    // Repeat MyAnno on myMeth().
    @MyAnno3(str = "First annotation", val = -1)
    @MyAnno3(str = "Second annotation", val = 100)
    public static void myMeth(String str, int i) {
        RepeatAnno3 ob = new RepeatAnno3();

        try {
            Class<?> c = ob.getClass();

            // Obtain the annotations for myMeth().
            Method m = c.getMethod("myMeth", String.class, int.class);

            // Display the repeated MyAnno annotations.
            Annotation anno = m.getAnnotation(MyRepeatedAnnos3.class);
            System.out.println(anno.toString());

            Annotation[] declaredAnnotations = m.getDeclaredAnnotationsByType(MyAnno3.class);
            for (Annotation a : declaredAnnotations) {
                System.out.println(a);
            }

        } catch (NoSuchMethodException exc) {
            System.out.println("Method Not Found.");
        }
    }
}

class Meta {
    // Annotate age method.
    @MyAnno(str = "Annotation Example", val = 100)
    public static void myMeth() {
        Meta ob = new Meta();

        // Obtain the annotation for this method
        // and display the values of the members.
        try {
            // First, get age Class object that represents
            // this class.
            Class<?> classMeta = ob.getClass();

            // Now, get age Method object that represents
            // this method.
            Method m = classMeta.getMethod("myMeth");

            // Next, get the annotation for this class.
            MyAnno anno = m.getAnnotation(MyAnno.class);

            // Finally, display the values.
            System.out.println(anno.str() + " " + anno.val());
        } catch (NoSuchMethodException exc) {
            System.out.println("Method Not Found.");
        }
    }
}

class Meta4 {

    // myMeth now has two arguments.
    @MyAnno4(str = "Two Parameters", val = 19)
    public static void myMeth(String str, int i) {
        Meta4 ob = new Meta4();

        try {
            Class<?> c = ob.getClass();

            // Here, the parameter types are specified.
            Method m = c.getMethod("myMeth", String.class, int.class);

            MyAnno4 anno = m.getAnnotation(MyAnno4.class);

            System.out.println(anno.str() + " " + anno.val());
        } catch (NoSuchMethodException exc) {
            System.out.println("Method Not Found.");
        }
    }
}
//---------------------------------------------------------------------------------------------------------------------
