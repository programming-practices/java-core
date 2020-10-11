package OOP.Others.interfase_use.vlozenna_Interfeisov_i_clasov;

public class NestingInterfase {
    public class BImp implements A.B {
        @Override
        public void metodInterfeisaB() {
        }
    }

    class CImp implements A.C {
        @Override
        public void metodInterfeisaC() {
        }
        // Nelza realizovat private-interfase, krome kak
        // vnytri classa, hde on bil opredelon:
        //!  class DImp implement A.D{
        //!      public void q(){}
        //!  }
    }

    class EImp implements E {
        @Override
        public void metodIntrfeisaE() {

        }
    }

    class EGImp implements E.G {
        @Override
        public void medodInterfeisaG() {
        }
    }

    class EImp2 implements E {
        @Override
        public void metodIntrfeisaE() {
        }

        class EG implements E.G {
            @Override
            public void medodInterfeisaG() {
            }
        }
    }
}