package Examples.OOP.Others.vnutrennii_class_i_sestema_ypravlenia;

//Obche dlya vdeho ypravliaiwchoho sobitia metodu

public abstract class Event {

    protected final long delayTime;
    private long eventTime;

    public Event(long delayTime) {
        this.delayTime = delayTime;
        start();
    }

    public void start() {  //S vozmoznosty perehryzki
        eventTime = System.nanoTime() + delayTime;
    }

    public boolean ready() {
        return System.nanoTime() >= eventTime;
    }

    public abstract void action();
}
