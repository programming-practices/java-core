package YouTube_Channels.Golovach_Courses.Java_Multithreading.Java_Multithreading_2014_09_09_Lecture_03_Hardware_Mathematics.Zadanie;

public class DekkerLock {
    private volatile boolean wontLockA = false;
    private volatile boolean wontLockB = false;
    private volatile int turn = 0;

    public void lockA() {
        wontLockA = true;
        while (wontLockB) {
            if (turn != 0) {
                wontLockA = false;
                while (turn != 0) {/*busy waiting*/}
                wontLockA = true;
            }
        }
    }


    public void lockB() {
        wontLockB = true;
        while (wontLockA) {
            if (turn != 0) {
                wontLockB = false;
                while (turn != 0) {/*busy waiting*/}
                wontLockB = true;
            }
        }
    }

    public void unLockA() {
        turn = 1;
        wontLockA = false;
    }

    public void unLockB() {
        turn = 0;
        wontLockB = false;
    }


}
