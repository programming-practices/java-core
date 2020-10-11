package Examples.OOP.Others.podschot_Sulok;

public class Composing {
    private static long counter = 0;
    private final long id = counter++;
    private Shared shared;

    public Composing(Shared shared) {
        System.out.println("Sozdaem " + this);
        this.shared = shared;
        this.shared.addRef();
    }

    protected void dispose() throws Throwable {
        System.out.println("disposing " + this);
        shared.dispose();
        shared.finalize();
    }

    public String toString() {
        return "Composing " + id;
    }

    @Override
    protected void finalize() throws Throwable {
        try {
            System.out.println("Obect udalon s id " + id);
        } finally {
            super.finalize();
        }

    }
}
