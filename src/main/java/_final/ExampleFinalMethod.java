package _final;

public class ExampleFinalMethod {

    public final void publicFinalMethod() {
    }

    // Final methods dozvolayetsa overload
    public final void publicFinalMethod(int i) {
    }

    public final void publicFinalMethod(String s) {
    }

    public void publicNotFinalMethod() {
    }
}

class Childer extends ExampleFinalMethod {

    @Override
    public void publicNotFinalMethod() {
    }

    //Attention   Overlload metod form Parent
    public final void publicFinalMethod(double d) {
    }

    // Final methods nedozvolaetsa override
    // ERROR
//    @Override
//    public final void publicFinalMethod() {
//        super.publicNotFinalMethod();
//    }
}
