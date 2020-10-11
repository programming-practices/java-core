package Examples.Multithreading.threadLocal;


public class SomeBuilderDemo00 {

    public static void main(String[] args) {
        SomeBuilder00 builder = new SomeBuilder00();

        Thread thread1 = new SomeBuilderThread00(builder);
        Thread thread2 = new SomeBuilderThread00(builder);

        try {
            thread1.start();
            thread2.start();

            thread1.join();
            thread2.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static class SomeBuilder00 {
        private int counter;

        public void build() {

            System.out.println("Thread " + Thread.currentThread().getName() + " Build some structure...");

            counter++;

            try {
                Thread.sleep(100);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public int getCount() {
            return counter;
        }
    }

    public static class SomeBuilderThread00 extends Thread {
        private SomeBuilder00 builder;

        public SomeBuilderThread00(SomeBuilder00 builder) {
            this.builder = builder;
        }

        @Override
        public void run() {

            for (int i = 0; i < Math.random() * 10; i++) {
                builder.build();
            }

            System.out.println("My name is " + getName() + " and I built " + builder.getCount() + " things");
        }
    }
}
