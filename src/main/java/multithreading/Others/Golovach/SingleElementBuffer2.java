package Examples.Multithreading.Others.Golovach;

public class SingleElementBuffer2 {
    private Integer element = null;

    public synchronized void put(int newElement) throws InterruptedException {
        while (element != null) wait();
        this.element = newElement;
        this.notifyAll();
    }

    public synchronized int get() throws InterruptedException {
        while (element == null) wait();
        Integer result = this.element;
        this.element = null;
        this.notifyAll();
        return result;
    }

}
