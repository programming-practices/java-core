package others.Modefikatoru_dostypa;

import others.Modefikatoru_dostypa.PackageA.ClassA;
import others.Modefikatoru_dostypa.PackageA.ClassV;

public class ClassNaslednikVNePackage extends ClassA {

    public ClassNaslednikVNePackage(int finalProtectedVariable) {
        super(finalProtectedVariable, new ClassV());
    }

//    public void finalMethod(){}   // ERROR  final metod

    public static void main(String[] args) {

        ClassA classA = new ClassA(5, new ClassV());
//        classA.protectedVariable;  // ne dostypne
//        classA.defaultVariable;  // ne dostypne

        ClassNaslednikVNePackage classNaslednikVNePackage = new ClassNaslednikVNePackage(3);
        classNaslednikVNePackage.protectedVariable = 4;
//        classNaslednikVNePackage.defaultVariavle = 4;   // ne dostypne
//        classNaslednikVNePackage.finalProtectedVariable = 5;    //ERROR
//        int a = 5;
//        classNaslednikVNePackage.finalProtectedVariable = a;    // ERROR
//        classNaslednikVNePackage.finalProtectedclassV = new ClassV();   //ERROR
        ClassV classV = new ClassV();
//        classNaslednikVNePackage.finalProtectedclassV = classV;   //ERROR
        classNaslednikVNePackage.finalProtectedclassV.a = 49;    // razreweno
    }

    private void methodPrivate() {
    }     // ce ne pereopredillonnui method super classa, ce novui method etoho classa

}
