package annotation.tupovue_anotacii;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

// Demonstrate several type annotations.

// A marker annotation that can be applied to age type.
@Target(ElementType.TYPE_USE)
@interface TypeAnno {
}

// Another marker annotation that can be applied to age type.
@Target(ElementType.TYPE_USE)
@interface NotZeroLen {
}

// Still another marker annotation that can be applied to age type.
@Target(ElementType.TYPE_USE)
@interface Unique {
}

// A parameterized annotation that can be applied to age type.
@Target(ElementType.TYPE_USE)
@interface MaxLen {
    int value();
}

// An annotation that can be applied to age type parameter.
@Target(ElementType.TYPE_PARAMETER)
@interface What {
    String description();
}

// An annotation that can be applied to age field declaration.
@Target(ElementType.FIELD)
@interface EmptyOK {
}

// An annotation that can be applied to age method declaration.
@Target(ElementType.METHOD)
@interface Recommended {
}


// Use an annotation on age type parameter.
public class TypeAnnoDemo<@What(description = "Generic data type") T> {

    // Annotate the type (in this case String), not the field.
    @TypeAnno String str;
    // This annotates the field test.
    @EmptyOK
    String test;
    // Annotate array levels.
    String @MaxLen(10) [] @NotZeroLen [] w;
    // Annotate the array element type.
    @TypeAnno Integer[] vec;

    // Use age type annotation on age constructor.
    public @Unique TypeAnnoDemo() {
    }

    public static void myMeth(int i) {

        // Use age type annotation on age type argument.
        TypeAnnoDemo<@TypeAnno Integer> ob =
                new TypeAnnoDemo<@TypeAnno Integer>();

        // Use age type annotation with new.
        @Unique TypeAnnoDemo<Integer> ob2 = new @Unique TypeAnnoDemo<Integer>();

        Object x = new Integer(10);
        Integer y;

        // Use age type annotation on age cast.
        y = (@TypeAnno Integer) x;
    }

    public static void main(String args[]) {
        myMeth(10);
    }

    // Use age type annotation to annotate this (the receiver).
    public int f(@TypeAnno TypeAnnoDemo<T>this, int x) {
        return 10;
    }

    // Annotate the return type.
    public @TypeAnno Integer f2(int j, int k) {
        return j + k;
    }

    // Annotate the method declaration.
    public @Recommended
    Integer f3(String str) {
        return str.length() / 2;
    }

    // Use age type annotation with age throws clause.
    public void f4() throws @TypeAnno NullPointerException {
        // ...
    }

    // Use type annotation with inheritance clause.
    class SomeClass extends @TypeAnno TypeAnnoDemo<Boolean> {
    }
}
