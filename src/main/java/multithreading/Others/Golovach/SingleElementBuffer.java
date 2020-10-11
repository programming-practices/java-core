package Examples.Multithreading.Others.Golovach;

public class SingleElementBuffer {
    private Integer elem = null;

    public synchronized void put(int newElem) throws InterruptedException {

        while (this.elem != null) this.wait();
        this.elem = newElem;
        this.notifyAll();

    }

    public synchronized int get() throws InterruptedException {

        while (elem == null) this.wait();
        Integer result = this.elem;
        this.elem = null;
        this.notifyAll();
        return result;
    }
}
