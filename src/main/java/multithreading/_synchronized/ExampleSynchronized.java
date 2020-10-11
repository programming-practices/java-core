package multithreading._synchronized;

public class ExampleSynchronized {

    public static void main(String[] args) throws InterruptedException {

        Account account = new Account(100_000);
        System.out.println("Begin balance" + account.getBalance());

        Thread withdrawThread = new WithdrawThread(account);
        Thread depositThread = new DepositThread(account);

        withdrawThread.start();
        depositThread.start();

        withdrawThread.join();
        depositThread.join();

        System.out.println("End balance " + account.getBalance());
    }

}


class WithdrawThread extends Thread {
    private final Account account;

    public WithdrawThread(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20_000; ++i) {
            account.withdraw(1);
        }
    }
}

class DepositThread extends Thread {
    private final Account account;

    public DepositThread(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20_000; ++i) {
            account.deposit(1);
        }
    }
}

class Account {
    private long balance;

    public Account() {
        this(0L);
    }

    public Account(long balance) {
        this.balance = balance;
    }

    private static void checkAmountNonNegative(long amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("negative amount");
        }
    }

    public long getBalance() {
        return this.balance;
    }

    public void deposit(long amount) {
        checkAmountNonNegative(amount);
        synchronized (this) {
            balance += amount;
        }

    }

    public void withdraw(long amount) {
        checkAmountNonNegative(amount);
        synchronized (this) {
            if (balance < amount) {
                throw new IllegalArgumentException("not enough money");
            }
            balance -= amount;
        }
    }
}
