package YouTube_Channels.Golovach_Courses.Java_Core_Serialization;

public class ShallowCopy {
    public static void main(String[] args) {

        Person hus0 = new Person();
        hus0.name = "Mike";

        Person wife = new Person();
        wife.name = "Ellen";

        hus0.coumple = wife;
        wife.coumple = hus0;

        Person hus1 = new Person(hus0);

    }
}

class Person {
    public String name;
    public Person coumple;

    public Person() {
    }

    // takoi konstryktor nazuvaetsa konstryktor kopirovania
    public Person(Person source) {
        this.name = source.name;
        this.coumple = source.coumple;
    }
}
