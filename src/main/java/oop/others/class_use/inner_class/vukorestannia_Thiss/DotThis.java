package Examples.OOP.Others.class_use.inner_class.vukorestannia_Thiss;

public class DotThis {

    public static void main(String[] args) {
        DotThis dt = new DotThis();
        DotThis.Inner dti = dt.inner();
        dti.outer().f();
    }

    void f() {
        System.out.println("DotThis.q()");
    }

    public Inner inner() {
        return new Inner();
    }

    public class Inner {

        public DotThis outer() {
            return DotThis.this;
            // this bez ytochnenia sootvectvyet obekty Inner
        }
    }
}
