package Examples.Type_Information.novui_sintaksis_privedenia_tipov.Class_asSubclass;

public class ClassDemo {

    public static void main(String[] args) {

        try {
            ClassDemo cls = new ClassDemo();
            ClassDemo subcls = new SubClass1();

            // class ClassDemo
            Class c = cls.getClass();
            System.out.println(c);

            // sub class SubClass1
            Class c1 = subcls.getClass();
            System.out.println(c1);

            // represent a subclass of the specified class object
            Class retval = c1.asSubclass(c);

            System.out.println(retval);
        } catch (ClassCastException e) {
            System.out.println(e.toString());
        }
    }
}

class SubClass1 extends ClassDemo {
    // sub class
}
