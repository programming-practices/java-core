package YouTube_Channels.Golovach_Courses.Java_Core_December_2013.Core_OOP_2_December_2013;

public class CheckInherited_0x5 {
    public static void main(String[] args) {
        Childer_0x0 childer = new Childer_0x0();
        Parent_0x0 parent = childer;

        childer.field = 1;
        parent.field = 2;

        System.out.println(childer.field);
        System.out.println(parent.field);
    }
}


class Parent_0x0 {
    public int field;
}

class Childer_0x0 extends Parent_0x0 {
    public int field;
}


