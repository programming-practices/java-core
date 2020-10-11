package others.entities;

public class Coffee implements Comparable {
    private static long counter = 0;
    private final long id = counter++;

    public String toString() {
        return getClass().getSimpleName() + " " + id;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
