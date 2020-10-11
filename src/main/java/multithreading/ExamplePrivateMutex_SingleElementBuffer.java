package Examples.Multithreading;

public class ExamplePrivateMutex_SingleElementBuffer {
    private final Object lock = new Object();
    private Integer element = null;

    public void put(int newElement) throws InterruptedException {
        synchronized (lock) {
            while (this.element != null) {
                this.wait();
            }
        }
        this.element = newElement;
        lock.notifyAll();
    }

    public int get() throws InterruptedException {
        synchronized (lock) {
            while (this.element == null) {
                this.wait();
            }
        }
        Integer result = this.element;
        this.element = null;
        lock.notifyAll();
        return result;
    }
}
