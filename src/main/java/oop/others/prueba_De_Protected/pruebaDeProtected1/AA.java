package oop.others.prueba_De_Protected.pruebaDeProtected1;

public class AA {
    public static void main(String[] args) {
        BB bb = new BB();
        bb.printBBProtected();
        bb.printBBPublic();
    }

    protected void printAAProtected() {
        System.out.println("Metod Preotected AA");
    }

    public void printAAPublic() {
        System.out.println("Metod Public AA");
    }
}
