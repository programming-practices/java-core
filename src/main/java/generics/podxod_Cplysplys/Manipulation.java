package generics.podxod_Cplysplys;


class Manipulator<T> {

    private T obj;

    public Manipulator(T x) {
        obj = x;
    }

    // Error: cannot find symbol: method fArgInt():
//    public void manipulate() { obj.fArgInt(); }
}

public class Manipulation {

    public static void main(String[] args) {

        HasF hf = new HasF();

        Manipulator<HasF> manipulator = new Manipulator<HasF>(hf);

//        manipulator.manipulate();
    }
}
