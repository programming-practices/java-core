package YouTube_Channels.Onlain_yroki_po_Java.Generics.example1;

public class Containe<T extends Product & Portable> {
    T t;

    public T getT() {
        return this.t;
    }

    public void setT(T t) {
        this.t = t;
    }
}
