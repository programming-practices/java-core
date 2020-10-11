package Examples.Multithreading;

import java.util.Arrays;
import java.util.concurrent.*;

public class ExampleExecutorService {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
//---------------------------------------------------------------------------------------------------------------------

        ExecutorService executorService = Executors.newCachedThreadPool();
        Callable<Integer> task00 = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return 42;
            }
        };
//        Future<Integer> furure00 = executorService.submit(task00);

        // Future eto vewch v kotoryiy zapisyetsa rezyltat roboru, esli rezyltat robotu hotov to
        // on stavitsa v future a esli resultat ne hotov to future
        // mozno oprawevat i delat ewcho vewchi kororuie sviazanue s rezyltatom
        Callable<Integer> task01 = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                while (true) {/*Infinity loop*/
                    if (Thread.interrupted()) {
                        throw new InterruptedException();
                    }
                }
//                throw new RuntimeException();
            }
        };
//        Future<Integer> furure01 = executorService.submit(task01);

//--------------------------------------------------------------------------------------------------------------------

//        Thread.sleep(1000);
//        // method future.isDone() vozvrawchaet true esli zadacha okonchena, a
//        // esli zadacha ne okonchena to vozvrawchaet false
//        System.out.println("future00.isDone(): " + furure00.isDone());
//        System.out.println("future01.isDone(): " + furure01.isDone());
//
//        System.out.print("future00.get(): ");
//        System.out.println(furure00.get());
//
//        System.out.print("future01.get(): ");
//        System.out.println(furure01.get());      // block here!
////        if (furure01.isDone()) { System.out.println(furure01.get()); }
//
//        System.out.println("FINISH!!!");

//--------------------------------------------------------------------------------------------------------------------

//        Future<Integer> f0 = executorService.submit((Callable<Integer>) null);
//        Future<Integer> f1 = executorService.submit((Callable<Integer>) null);
//        Future<Integer> f2 = executorService.submit((Callable<Integer>) null);
//
//        //---------------
//        int k = 0;
//        while (k < 3){
//            f0.get(1, TimeUnit.SECONDS);
//            f1.get(1, TimeUnit.SECONDS);
//            f2.get(1, TimeUnit.SECONDS);
//            k++;
//        }

//--------------------------------------------------------------------------------------------------------------------

//        List<Future<Integer>> futures = executorService.invokeAll(new ArrayList<Callable<Integer>>());

//        List<Future<Integer>> result = executorService.invokeAll(Arrays.asList(task00, task01));
//        System.out.println(result);

        Integer result = executorService.invokeAny(Arrays.asList(task00, task01));
        System.out.println(result);
        System.out.println("FINISH!!!");

//        Future<Integer> integerFuture0 = result.get(0);
//        Future<Integer> integerFuture1 = result.get(1);

//        Integer integer0 = integerFuture0.get();
//        Integer integer1 = integerFuture1.get();
//        System.out.println(integer0);
//        System.out.println(integer1);

        // executorService.shutdown() zdet dozaverwenia robotu  potokaov a potom vse potoki zakrivaet
//        executorService.shutdown(); // rabotaet i ne rabotaet

        // Callable ne dolzen ihnorirovat Thread.interruped() chtobu rabotal executorService.shutdownNow(),
        // toest v Callable dolzno bit kakoeto deistvie kotoroe chtoto delaet s Tread.interruped() i
        // tohda executorService.shutdownNow() zarabotaet.
        executorService.shutdownNow();
        // executorService.shutdownNow() pribivaet vse potoki  te chto zdyt v ocheridi
        // i daze te chto v danui moment vupolniaytsa
//--------------------------------------------------------------------------------------------------------------------
    }
}
