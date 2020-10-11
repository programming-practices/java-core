package multithreading;

public class ExampleThreadWait {
    public static void main(String[] args) {

    }
}


/*

    Kohda Thread.wait() zasupaet to on otpyskaet monitor

    Kakimi sposobami mozno vuiti iz  wait() (no potok srazy iz wait ne nachinait roboty a perenositsa v blocked set:
    1) notify(), notifyAll,
    2) Vuzovom iterrupetd(), prosupaimsa s IterruptedException
    3) Wait() mozet istech taimayt(esli wait() bez taimayta to on vechnui, a esli ne to vuxod po taimayty)
    4) (spurious wakeups)I est takoe chto potok mozet rozbuditsa sam spontanno, eto staroe iavlenie.

*/