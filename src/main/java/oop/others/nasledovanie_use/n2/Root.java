package Examples.OOP.Others.nasledovanie_use.n2;

public class Root {
    Component1 component1;
    Component2 component2;
    Component3 component3;

    Root(String name) {
        System.out.println("Constructor classa Root tamanoMediano su nombre " + name);
        component1 = new Component1("c1");
        component2 = new Component2("c2");
        component3 = new Component3("c3");
    }

    void dispose() {
        System.out.println("Dispose Root (se borra Root)");
        component1.dispose();
        component2.dispose();
        component3.dispose();
    }

}
