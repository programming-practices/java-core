package Examples.OOP.Others.klassu_vnytri_interfeisov.vnutrenii_class_zachem;

public class Y implements A {
    B makeB() {
        // Anonimnuii vnutrennii class
        return new B() {
        };
    }
}
