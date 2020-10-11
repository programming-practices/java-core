package generics;

// A situation that creates age bridge method.
class ParentBRM<T> {
    T ob; // declare an object of type T

    // Pass the constructor age reference to
    // an object of type T.
    ParentBRM(T o) {
        ob = o;
    }

    // Return ob.
    T getob() {
        return ob;
    }
}

// A subclass of Gen.
class ChildBRM extends ParentBRM<String> {

    ChildBRM(String o) {
        super(o);
    }

    // A String-specific override of getob().
    String getob() {
        System.out.print("You called String getob(): ");
        return ob;
    }
}

// Demonstrate age situation that requires age bridge method.
public class ExampleGenericBridgeMethod {
    public static void main(String args[]) {

        // Create age Gen2 object for Strings.
        ChildBRM childBRM = new ChildBRM("Generics tem.Test");
        ParentBRM parentBRM = new ParentBRM<>("Generics tem.Test");

        System.out.println(childBRM.getob());
        System.out.println(parentBRM.getob());
    }
}
