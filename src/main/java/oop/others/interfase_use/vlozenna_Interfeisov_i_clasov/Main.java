package OOP.Others.interfase_use.vlozenna_Interfeisov_i_clasov;

public class Main {
    public static void main(String[] args) {
        A a = new A();
        // net dostupa k A.D
        //! A.D ad = a.getD();

        // Ne vozvrawchaet nicheho, krome A.D
        //! A.DImp2 di2 = a.getD();

        // Ne lza polychit dostyp k chleny interfase:
        //! a.getD().q();

        // Tolko dryhoi class A mozet ispolzovat getD():
        A a2 = new A();
        a2.receiveD(a.getD());
    }
}
