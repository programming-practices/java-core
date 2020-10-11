package YouTube_Channels.Golovach_Courses.Java_Multithreading.Java_Multithreading_2014_09_09_Lecture_03_Hardware_Mathematics.Zadanie;

public class PatersonLock {
    private volatile boolean flag00 = false;
    private volatile boolean flag01 = false;
    private volatile int victim = 0;

    public void lockA() {
        flag00 = true; // I'm interested
        victim = 1;    // you go first
        while (flag01 && victim == 1) {/* busy wait*/}
    }


    public void lockB() {
        flag01 = true; // I'm interested
        victim = 0;    // you go first
        while (flag00 && victim == 0) {/* busy wait*/}
    }

    public void unLockA() {
        flag00 = false;
    }   // I'm not interested

    public void unLockB() {
        flag01 = false;
    }   // I'm not interested

}
