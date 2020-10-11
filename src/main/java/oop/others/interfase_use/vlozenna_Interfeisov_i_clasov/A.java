package OOP.Others.interfase_use.vlozenna_Interfeisov_i_clasov;

public class A {
    private D dRef;

    public D getD() {
        return new DImp2();
    }

    public void receiveD(D d) {
        dRef = d;
        dRef.medodInterfeisaD();
    }

    interface B {
        void metodInterfeisaB();
    }

    public interface C {
        void metodInterfeisaC();
    }

    private interface D {
        void medodInterfeisaD();
    }

    public class BImp implements B {
        @Override
        public void metodInterfeisaB() {
        }
    }

    private class BImp2 implements B {
        @Override
        public void metodInterfeisaB() {
        }
    }

    class CImp implements C {
        @Override
        public void metodInterfeisaC() {
        }
    }

    private class CImp2 implements C {
        @Override
        public void metodInterfeisaC() {
        }
    }

    private class DImp implements D {
        @Override
        public void medodInterfeisaD() {

        }
    }

    public class DImp2 implements D {
        @Override
        public void medodInterfeisaD() {

        }
    }
}
