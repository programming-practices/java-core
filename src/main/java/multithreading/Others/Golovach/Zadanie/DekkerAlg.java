package YouTube_Channels.Golovach_Courses.Java_Multithreading.Java_Multithreading_2014_09_09_Lecture_03_Hardware_Mathematics.Zadanie;

public class DekkerAlg {
    /* Iterations done by each Thread */
    static final int iterations = 2000000;
    /* Shared variable */
    static volatile int sharedInteger = 0;
    /* P Thread for critical section */
    static volatile boolean wantp = false;
    /* Q Thread for critical section */
    static volatile boolean wantq = false;
    /* Z Thread for critical section */
    static volatile boolean wantz = false;
    /* Thread turn */
    static volatile int turn = 1;

    DekkerAlg() {
        Thread p = new P();
        Thread q = new Q();
        Thread z = new Z();
        p.start();
        q.start();
        z.start();

        try {
            p.join();
            q.join();
            z.join();
            System.out.println("The value of the sharedInteger is " + sharedInteger);
            System.out.println("It should be different from 0.");
        } catch (InterruptedException e) {
        }
    }

    public static void main(String[] args) {
        new DekkerAlg();
    }

    class P extends Thread {
        public void run() {
            for (int i = 0; i < iterations; ++i) {
                /* No critical section */
                wantp = true;
                while (wantq || wantz) {
                    if (turn == 2) {
                        wantp = false;
                        while (turn == 2)
                            Thread.yield();
                        wantp = true;
                    }
                }

                /* Critical section */
                ++sharedInteger;
                /* End critical section */

                turn = 2;
                wantp = false;
            }
        }
    }

    class Q extends Thread {
        public void run() {
            for (int i = 0; i < iterations; ++i) {
                /* No critical section */
                wantq = true;
                while (wantp || wantz) {
                    if (turn == 1) {
                        wantq = false;
                        while (turn == 1)
                            Thread.yield();
                        wantq = true;
                    }
                }

                /* Critical section */
                --sharedInteger;
                /* End critical section */

                turn = 1;
                wantq = false;
            }
        }
    }

    class Z extends Thread {
        public void run() {
            for (int i = 0; i < iterations; ++i) {
                /* No critical section */
                wantz = true;
                while (wantp || wantq) {
                    if (turn == 3) {
                        wantz = false;
                        while (turn == 3)
                            Thread.yield();
                        wantz = true;
                    }
                }

                /* Critical section */
                ++sharedInteger;
                /* End critical section */

                turn = 3;
                wantz = false;
            }
        }
    }
}
