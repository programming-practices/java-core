package exceptions.LomaemProbroskyChekedException;

import java.rmi.RemoteException;

// This class can not be modified.
public class EvilClass {
    protected void throwTest() {
        System.out.println("Don't touch me!");
    }
}

class ThrowDemo extends EvilClass {
    public static void main(String[] args) {
        new ThrowDemo().throwTest();
    }

    // nam nuzno prederzuvatsa yslovia chto nelzia izmeniat clas ot kotoroho nasleduemsa
    // i sootvetstvenno metod toze ne vza izmeniat
    @Override
    protected void throwTest() {
        EvilThrower.throwAnyway(new RemoteException("I want to throw it!"));
    }

    static class EvilThrower {
        private static <T extends Exception> void doWork(Exception e) throws T {
            throw (T) e;
        }

        public static void throwAnyway(Exception e) {
            doWork(e);
        }
    }
}

// Thank you to the creator of this video: https://www.youtube.com/watch?v=EpRqEE2eTEw