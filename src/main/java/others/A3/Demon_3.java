package YouTube_Channels.Computer_Science_Center.Mnoho_potochnost_v_java_osnovu._2;


public class Demon_3 {
    public static void main(String[] args) throws InterruptedException {
        Account account = new Account(0);

        new DepositThread(account).start();

        System.out.println("Calling waitAndWithdraw()...");

        account.whaitAndWithdraw(50_000_000);

        System.out.println("whaitAndWithdraw() finished");
    }

//    private static class WithdrawThread extends Thread{
//        private final Account account;
//
//        public WithdrawThread(Account account) {
//            this.account = account;
//        }
//
//        @Override
//        public void run() {
//            for(int i = 0; i < 20_000; ++i){
//                account.withdraw(1);
//            }
//        }
//    }

    private static class DepositThread extends Thread {
        private final Account account;

        public DepositThread(Account account) {
            this.account = account;
        }

        @Override
        public void run() {
            for (int i = 0; i < 50_000_000; ++i) {
                account.deposit(1);
//                System.out.println(account.getBalance());
            }
        }
    }

}
