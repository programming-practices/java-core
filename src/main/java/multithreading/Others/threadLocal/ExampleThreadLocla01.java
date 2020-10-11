package Examples.Multithreading.Others.threadLocal;

public class ExampleThreadLocla01 {
    public static void main(String[] args) {
        SomeBuilder builder = new SomeBuilder();
        Thread thread1 = new SomeBuilderThread(builder);
        Thread thread2 = new SomeBuilderThread(builder);
        try {
            thread1.start();
            thread2.start();

            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static class SomeBuilder {
        private ThreadLocal<Integer> counter = new ThreadLocal<Integer>() {
            @Override
            protected /*synchronized*/ Integer initialValue() {
                return 0;
            }
        };

        public void build() {
            System.out.println("Thread " + Thread.currentThread().getName() + " Build some structure...");
            counter.set(counter.get() + 1);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public int getCount() {
            return counter.get();
        }
    }

    public static class SomeBuilderThread extends Thread {
        private SomeBuilder builder;

        public SomeBuilderThread(SomeBuilder builder) {
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
