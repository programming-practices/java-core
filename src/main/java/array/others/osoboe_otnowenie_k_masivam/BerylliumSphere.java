package array.others.osoboe_otnowenie_k_masivam;

public class BerylliumSphere implements Comparable<BerylliumSphere> {

    private static long counter;
    private final long id = counter++;

    public String toString() {
        return "Sphere " + id;
    }

    @Override
    public int compareTo(BerylliumSphere o) {
        return (id < o.id ? -1 : (id == o.id ? 0 : 1));
    }

//    public int compareTo(CompType rv) {
//        return (i < rv.i ? -1 : (i == rv.i ? 0 : 1));
//    }
}
