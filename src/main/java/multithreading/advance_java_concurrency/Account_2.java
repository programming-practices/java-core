package multithreading.advance_java_concurrency;

import java.util.concurrent.atomic.AtomicInteger;

public class Account_2 {
    //    private int failCounter;
    private AtomicInteger failCounter = new AtomicInteger(0);

    public void incFailedTransferCounter() {
//        failCounter++;
        failCounter.incrementAndGet();
    }
}
