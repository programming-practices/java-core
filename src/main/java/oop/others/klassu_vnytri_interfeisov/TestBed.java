package Examples.OOP.Others.klassu_vnytri_interfeisov;

public class TestBed {

    public void f() {
        System.out.println("q()");
    }

    public static class Tester {
        public static void main(String[] args) {
            TestBed t = new TestBed();
            t.f();
        }
    }
}
