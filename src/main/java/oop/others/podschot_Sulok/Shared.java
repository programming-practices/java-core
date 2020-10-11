package Examples.OOP.Others.podschot_Sulok;

public class Shared {
    private static long couter = 0;
    private final long id = couter++;
    private int refcount = 0;

    public Shared() {
        System.out.println("Sozdaem " + this);
    }

    public void addRef() {
        refcount++;
    }

    protected void dispose() {
        if (--refcount == 0) {
            System.out.println("Disposing " + this);
        }
    }

    public String toString() {
        return "Shared " + id;
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
