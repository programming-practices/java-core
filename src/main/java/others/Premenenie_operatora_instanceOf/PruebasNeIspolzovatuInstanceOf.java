package others.Premenenie_operatora_instanceOf;

public class PruebasNeIspolzovatuInstanceOf {
    public static void main(String[] args) {
        AInst bInst = new BInst();
        AInst cInst = new CInst();

        method(bInst);
        method(cInst);
    }


//    public static void method1(BInst bInst){
//        System.out.println("BInst: " + bInst);
//    }
//
//    public static void method1(CInst cInst){
//        System.out.println("CInst: " + cInst);
//    }

    public static void method(AInst aInst) {
        System.out.println("AInst: " + aInst);
    }
}

class AInst {
}

class BInst extends AInst {
}

class CInst extends AInst {
}
