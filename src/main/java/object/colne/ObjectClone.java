package object.colne;

// Demonstrate the clone() method.
public class ObjectClone {
    public static void main(String[] args) {
//---------------------------------------------------------------------------------------------------------------------

        TestCloneOne tco1 = new TestCloneOne();
        TestCloneOne tco2;

        tco1.person = new Person("Natalia original");
        tco1.age = 10;
        tco1.b = 20.98;

        tco2 = tco1.cloneTest(); // clone x1

        System.out.println("tco1: " + tco1.age + " " + tco1.b + " " + tco1.person.toString());
        System.out.println("tco2: " + tco2.age + " " + tco2.b + " " + tco2.person.toString());

        tco2.person = new Person("Natalia tco2 cambio");
        tco2.age = 100;
        tco2.b = 200.98;

        System.out.println("\nPosle izmenenia tco2.age  tco2.b  tco2.person");
        System.out.println("tco1: " + tco1.age + " " + tco1.b + " " + tco1.person.toString());
        System.out.println("tco2: " + tco2.age + " " + tco2.b + " " + tco2.person.toString());

        tco1.person = new Person("Natalia tco1 cambio");
        tco1.age = 1009;
        tco1.b = 2009.98;

        System.out.println("\nPosle izmenenia tco1.age  tco1.b  tco1.person");
        System.out.println("tco1: " + tco1.age + " " + tco1.b + " " + tco1.person.toString());
        System.out.println("tco2: " + tco2.age + " " + tco2.b + " " + tco2.person.toString());

//---------------------------------------------------------------------------------------------------------------------

        TestCloneTwo tct1 = new TestCloneTwo();
        TestCloneTwo tct2;

        tct1.person = new Person("Carlos original");
        tct1.age = 10;
        tct1.b = 20.98;

//         here, clone() is called directly.
        tct2 = (TestCloneTwo) tct1.clone();

        System.out.println("-----------------------\n");
        System.out.println("tct1: " + tct1.age + " " + tct1.b + " " + tct1.person.toString());
        System.out.println("tct2: " + tct2.age + " " + tct2.b + " " + tct2.person.toString());

        tct2.person = new Person("Carlos tct2 cambio");
        tct2.age = 110;
        tct2.b = 220.98;

        System.out.println("\nPosle izmenenia tct2.age  tct2.b  tct2.person");
        System.out.println("tct1: " + tct1.age + " " + tct1.b + " " + tct1.person.toString());
        System.out.println("tct2: " + tct2.age + " " + tct2.b + " " + tct2.person.toString());

        tct1.person = new Person("Carlos tct1 cambio");
        tct1.age = 1107;
        tct1.b = 2207.98;

        System.out.println("\nPosle izmenenia tct1.age  tct1.b  tct1.person");
        System.out.println("tct1: " + tct1.age + " " + tct1.b + " " + tct1.person.toString());
        System.out.println("tct2: " + tct2.age + " " + tct2.b + " " + tct2.person.toString());

//---------------------------------------------------------------------------------------------------------------------
    }
}

class TestCloneOne implements Cloneable {
    Person person;
    int age;
    double b;

    // This method calls Object's clone().
    TestCloneOne cloneTest() {
        try {
            // call clone in Object.
            return (TestCloneOne) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("Cloning not allowed.");
            return this;
        }
    }
}

// Override the clone() method.

class TestCloneTwo implements Cloneable {
    Person person;
    int age;
    double b;

    // clone() is now overridden and is public.
    public Object clone() {
        try {
            // call clone in Object.
            return super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("Cloning not allowed.");
            return this;
        }
    }
}

class Person {
    String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}



