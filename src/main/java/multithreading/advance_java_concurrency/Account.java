package multithreading.advance_java_concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {

    private final Lock lock;
    private /*volatile*/ int balance;

    public Account(int balance) {
        this.balance = balance;
        lock = new ReentrantLock();
    }

    public /*synchronized*/ void withdraw(int amount) {
        balance -= amount;
    }

    public /*synchronized*/ void deposit(int amount) {
        balance += amount;
    }

    public int getBalance() {
        return this.balance;
    }

    public Lock getLock() {
        return this.lock;
    }
}
