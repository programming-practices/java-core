package Examples.OOP.Others.klassu_vnytri_interfeisov;

public interface ClassInterfase {

    void howdy();

    class Test implements ClassInterfase {

        public static void main(String[] args) {
            new Test().howdy();
        }

        @Override
        public void howdy() {
            System.out.println("Hola!");
        }
    }
}
