package Examples.OOP.Others.podschot_Sulok;

public class ReferenceCouting {
    public static void main(String[] args) throws Throwable {
        Shared shared = new Shared();
        Composing[] composings = {new Composing(shared),
                new Composing(shared), new Composing(shared),
                new Composing(shared), new Composing(shared)
        };
        for (Composing c : composings) {
            c.dispose();
            c.finalize();
        }

//        System.gc();
//        System.runFinalization();


    }
}
