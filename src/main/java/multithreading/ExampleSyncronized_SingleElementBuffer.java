package Examples.Multithreading;

public class ExampleSyncronized_SingleElementBuffer {
    private Integer element = null;

    public synchronized void put(int newElement) throws InterruptedException {
        while (this.element != null) {
            this.wait();
        }
        this.element = newElement;
        this.notifyAll();
    }

    public synchronized int get() throws InterruptedException {
        while (this.element == null) {
            this.wait();
        }
        Integer result = this.element;
        this.element = null;
        this.notifyAll();
        return result;
    }
}
