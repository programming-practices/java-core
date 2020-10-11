package _final;

public class ExampleFinalClassInheritance {
    public static void main(String[] args) {
        ChildAA childAA = new ChildAA("VVV");
        childAA.methodFinal();
    }
}

final class ParrentFinal {
    private String name;

    public ParrentFinal(String name) {
        this.name = name;
    }
}

class ParrentAA {
    private String name;

    public ParrentAA(String name) {
        this.name = name;
    }

    public final void methodFinal() {
        System.out.println("Hello from Parent final method!!!");
    }
}

class ChildAA extends ParrentAA/*extends ParrentFinal ERROR ne vozmozno ynasledovatsa ot finalnoho klassa*/ {

    public ChildAA(String name) {
        super(name);
    }

    // ne vozmozno pereopredilat finalnue methodu
//    @Override
//    public final void methodFinal(){
//        System.out.println("Hello from final method");
//    }

    // i sozdat metod s takim ze imenem kak finalnui metod nelza
//    public void methodFinal(){
//        System.out.println("Hello from final method");
//    }
}