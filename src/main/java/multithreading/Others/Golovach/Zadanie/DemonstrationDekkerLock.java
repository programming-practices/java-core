package YouTube_Channels.Golovach_Courses.Java_Multithreading.Java_Multithreading_2014_09_09_Lecture_03_Hardware_Mathematics.Zadanie;

public class DemonstrationDekkerLock {
    public static void main(String[] args) {

        final DekkerLock lock = new DekkerLock();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    lock.lockA();
                    try {
                        System.out.println("A");
                    } finally {
                        lock.unLockA();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    lock.lockB();
                    try {
                        System.out.println("    B");
                    } finally {
                        lock.unLockB();
                    }
                }
            }
        }).start();
    }
}
