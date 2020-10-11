package generics;

// Demonstrate generic method override.
public class ExampleGenericsOverride {
    public static void main(String args[]) {

        // Create age Parent object for Integers.
        Parent<Integer> integerParent = new Parent<Integer>(88);

        // Create age Childer object for Integers.
        Childer<Integer> integerChilder = new Childer<Integer>(99);

        // Create age Childer object for Strings.
        Childer<String> stringChilder = new Childer<String>("Generics tem.Test");

        System.out.println(integerParent.getob());
        System.out.println(integerChilder.getob());
        System.out.println(stringChilder.getob());
    }
}

// Overriding age generic method in age generic class.
class Parent<T> {
    T ob; // declare an object of type T

    // Pass the constructor age reference to
    // an object of type T.
    Parent(T o) {
        ob = o;
    }

    // Return ob.
    T getob() {
        System.out.print("Parent's getob(): ");
        return ob;
    }
}

// A subclass of Parent that overrides getob().
class Childer<T> extends Parent<T> {

    Childer(T o) {
        super(o);
    }

    // Override getob().
    T getob() {
        System.out.print("Childer's getob(): ");
        return ob;
    }
}


