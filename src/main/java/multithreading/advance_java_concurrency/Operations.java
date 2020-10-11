package multithreading.advance_java_concurrency;

public class Operations {
    public static void main(String[] args) throws InterruptedException {

        final Account account_1 = new Account(1000);
        final Account account_2 = new Account(2000);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    transfer(account_1, account_2, 500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();

        thread.join();

        transfer(account_2, account_1, 500);


        System.out.println("account_1 = " + account_1.getBalance());
        System.out.println("account_2 = " + account_2.getBalance());
    }

    static /*synchronized*/ void transfer(Account accWithdraw, Account accDeposit, int amount) throws InterruptedException {

        if (accWithdraw.getBalance() < amount) {
            throw new InsufficientFoundsException();
        }

        accWithdraw.withdraw(amount);
        accDeposit.deposit(amount);

//        if(accWithdraw.getLock().tryLock(1, TimeUnit.SECONDS)){
//            try{
//                if(accDeposit.getLock().tryLock(1, TimeUnit.SECONDS)){
//                    try{
//                        accWithdraw.withdraw(amount);
//                    }catch(Exception e){
//
//                    }finally{ }
//                }
//            }catch(Exception e){
//
//            }finally{
//                accWithdraw.getLock().unlock();
//                accDeposit.getLock().unlock();
//            }
//        }else {
//            System.out.println("Error if !!!");
//        }
//
//        if(accWithdraw.getLock().tryLock(1, TimeUnit.SECONDS)){
//            try{
//                if(accDeposit.getLock().tryLock(1, TimeUnit.SECONDS)){
//                    try{
//                        accDeposit.deposit(amount);
//                    }catch(Exception e){
//
//                    }finally{ }
//                }
//            }catch(Exception e){
//
//            }finally{
//                accDeposit.getLock().unlock();
//                accWithdraw.getLock().unlock();
//            }
//        }else {
//            System.out.println("Error if !!!");
//        }


//        accDeposit.getLock().lock();
//        try{
//            accDeposit.deposit(amount);
//        }catch(Exception e){
//            e.printStackTrace();
//        }finally{
//            accDeposit.getLock().unlock();
//        }
//
//        accWithdraw.getLock().lock();
//        try{
//            accWithdraw.deposit(amount);
//        }catch(Exception e){
//            e.printStackTrace();
//        }finally{
//            accWithdraw.getLock().unlock();
//        }


//        synchronized(accWithdraw){
//            Thread.sleep(1000);
//            synchronized(accDeposit){
//
//                accDeposit.deposit(amount);
//                accWithdraw.withdraw(amount);
//            }
//        }
    }
}
