package generics.Ohranichenie_metasimvolnux_arhymentov;


public class Pruebas<T extends A> {
    private T t;

    public Pruebas(T t) {
        this.t = t;
    }

    public static void method(Pruebas<?> p) {

    }

    public static void main(String[] args) {

        A a = new A();
        Pruebas<A> prueba0 = new Pruebas(a);
        method(prueba0);

        B b = new B();
        Pruebas<B> prueba1 = new Pruebas(b);
        method(prueba1);

        C c = new C();
        Pruebas<C> prueba2 = new Pruebas<>(c);
        method(prueba2);
    }


}


class A {

}

class B extends A {

}

class C extends B {

}

class AA {

}

