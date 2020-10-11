package Examples.OOP.Others.class_use.nested_class_staticheskiiVlozeniiClass.vprava_16_10;

public class Main {
    OuterA outerA = new OuterA();
    OuterA.Inner inner = outerA.new Inner();
    OuterA.Nested nested = new OuterA.Nested();

    public static void main(String[] args) {
        OuterA outerA2 = new OuterA();
        OuterA.Inner inner2 = outerA2.new Inner();
        OuterA.Nested nested2 = new OuterA.Nested();
    }
}
