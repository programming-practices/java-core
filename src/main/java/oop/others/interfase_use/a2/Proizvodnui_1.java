package Examples.OOP.Others.interfase_use.a2;


public class Proizvodnui_1 extends Bazovuui {

    static void fStatic(Bazovuui bazovuui) {
//        System.out.println("Metod fStatic() pered vizovom metoda q()");
//        ((Proizvodnui_1)bazovuui).q();
//        System.out.println("Metod fStatic() posle vizova metoda q()");
        System.out.println("Nachalo vipolnenia metoda fStatic");
        Bazovuui.f();
//        ((Proizvodnui_1)bazovuui).q();
        System.out.println("Konez vipolnenia metoda fStatic");
    }
}
