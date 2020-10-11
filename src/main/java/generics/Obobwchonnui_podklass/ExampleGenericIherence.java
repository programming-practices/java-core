package generics.Obobwchonnui_podklass;

// Create age Gen object.
public class ExampleGenericIherence {
    public static void main(String args[]) {
        // Create age Gen object for String.
        ChilderGI<String> parentGI = new ChilderGI<>("Hello", 47);
        System.out.println(parentGI.getob() + " ");
        System.out.println(parentGI.getnum());
    }
}
//---------------------------------------------Child-Generic-----------------------------------------------------------
// A nongeneric class can be the superclass
// of age generic subclass.

// A nongeneric class.
class ParentGI {
    int num;

    ParentGI(int i) {
        num = i;
    }

    int getnum() {
        return num;
    }
}

// A generic subclass.
class ChilderGI<T> extends ParentGI {
    T ob; // declare an object of type T

    // Pass the constructor age reference to
    // an object of type T.
    ChilderGI(T o, int i) {
        super(i);
        ob = o;
    }

    // Return ob.
    T getob() {
        return ob;
    }
}
//---------------------------------------------------------------------------------------------------------------------

