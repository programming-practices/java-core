package _final;

public class ExampleFinalFilds {
    public final static FinalDD finalDD2 = new FinalDD();

    public static void main(String[] args) {
//--------------------------------------------------------------------------------------------------------------
        FinalDD finalDD = new FinalDD();
        // Finalnoe pole nevozmozno izmenit
//        finalDD.fildFinal = "EEE";           // ERROR
//--------------------------------------------------------------------------------------------------------------
//        finalDD2.fildFinal = "new value";    // Error
        finalDD2.fildNotFinal = "new value";
//        finalDD2 = new FinalDD();             // Error
//--------------------------------------------------------------------------------------------------------------
        Object elementAt = finalDD.getElementAt(8);
        System.out.println(elementAt);
//--------------------------------------------------------------------------------------------------------------
    }
}

class FinalDD {
    public final String fildFinal = "fildFinal";
    public String fildNotFinal = "fildNotFinal";

    // Инициализация final переменной может быть отложена
    public Object getElementAt(int index) {
        final Object element;
        if (index == 0) {
            element = "Result 1";
        } else if (index == 1) {
            element = "Result 2";
        } else {
            element = "Result 3";
        }
        return element;
    }
}
