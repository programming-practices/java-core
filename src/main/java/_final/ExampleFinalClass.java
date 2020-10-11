package _final;

public final class ExampleFinalClass {
    public final int valueFinal = 0;
    public int value = 0;
}


// Ot finalnoho classa nevozmozno ynasledovatsa
class Child /*extends ExampleFinalClass*/ {

    public final static ExampleFinalClass cF = new ExampleFinalClass();

    public static void main(String[] args) {

        // Y finalnoho klassa polya po ymolchaniy ne finalnue
        cF.value = 4;
        System.out.println(cF.value);
        cF.value = 100;
        System.out.println(cF.value);


//        cF.valueFinal = 98;   // ERROR
    }
}


