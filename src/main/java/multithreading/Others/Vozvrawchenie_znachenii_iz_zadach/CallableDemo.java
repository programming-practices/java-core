package Examples.Multithreading.Vozvrawchenie_znachenii_iz_zadach;

import java.util.ArrayList;
import java.util.concurrent.*;

class TaskWithResult implements Callable<String> {
    private int id;

    public TaskWithResult(int id) {
        this.id = id;
    }

    public String call() {
        return "result of TaskWithResult " + id + " Thread name: " + Thread.currentThread().getName();
    }
}

public class CallableDemo {
    public static void main(String[] args) {

        ExecutorService exec = Executors.newCachedThreadPool();

        ArrayList<Future<String>> results = new ArrayList<Future<String>>();

        for (int i = 0; i < 10; i++) results.add(exec.submit(new TaskWithResult(i)));

        for (Future<String> fs : results) {

            try {
                // get() blocks until completion:
//                System.out.println(fs.get());
                System.out.println(fs.get(1L, TimeUnit.SECONDS));
            } catch (InterruptedException e) {
                System.out.println(e);
                return;
            } catch (ExecutionException e) {
                System.out.println(e);
            } catch (TimeoutException e) {
                e.printStackTrace();
            } finally {
                exec.shutdown();
            }
        }
    }
}
