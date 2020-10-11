package Examples.OOP.Others.class_use.nested_class_staticheskiiVlozeniiClass.vprava_17_10;

public class Main {

    Outer outer = new Outer();
    Outer.Inner inner = outer.new Inner();
    Outer.Inner.InnerInner innerInner = inner.new InnerInner();

    Outer.Nested.NestedNested nestedNested = new Outer.Nested.NestedNested();

    public static void main(String[] args) {

    }
}
