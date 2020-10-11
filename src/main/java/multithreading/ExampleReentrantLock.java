package multithreading;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ExampleReentrantLock {
    public static void main(String[] args) throws InterruptedException {
        Account account = new Account(0);

        new DepositThread(account).start();

        System.out.println("Entering waitAndWithdraw");

        account.waitAndWithdraw(50_000_000);

        System.out.println("waitAndWithdraw finished, end balance = " + account.getBalance());
    }

    private static class DepositThread extends Thread {
        private final Account account;

        public DepositThread(Account account) {
            this.account = account;
        }

        @Override
        public void run() {
            for (int i = 0; i < 50_000_000; ++i) {
                account.deposit(1);
            }
        }
    }
}

class Account {

    private final Lock lock = new ReentrantLock();
    private final Condition balanceIncreased = lock.newCondition();

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
        lock.lock();
        try {
            return balance;
        } finally {
            lock.unlock();
        }
    }

    public void deposit(long amount) {
        checkAmountNonNegative(amount);
        lock.lock();
        try {
            balance += amount;
            balanceIncreased.signalAll();
        } finally {
            lock.unlock();
        }

    }

    public void withdraw(long amount) {
        checkAmountNonNegative(amount);
        lock.lock();
        try {
            if (balance < amount) {
                throw new IllegalArgumentException("not enough money");
            }
            balance -= amount;
        } finally {
            lock.unlock();
        }
    }

    public void waitAndWithdraw(long amount) throws InterruptedException {
        checkAmountNonNegative(amount);
        lock.lock();
        try {
            while (balance < amount) {
                balanceIncreased.await();
                //                System.out.println("awake");
            }
            balance -= amount;
        } finally {
            lock.unlock();
        }
    }
}
