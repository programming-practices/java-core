package Examples.OOP.Others.class_use.inner_class.vukorrestannia_New;

public class DotNew {

    public static void main(String[] args) {
        DotNew dn = new DotNew();
        DotNew.Inner dni = dn.new Inner();
        System.out.println(dni.getClass().getSimpleName());
    }

    public class Inner {
    }
}
