package Examples.Multithreading.A1.unsynchronized;

import java.util.Arrays;

/**
 * This program shows data corruption when multiple threads access a data
 * structure.
 *
 * @author Cay Horstmann
 * @version 1.31 2015-06-21
 */
public class UnsynchBankTest {
    public static final int NACCOUNTS = 10;
    public static final double INITIAL_BALANCE = 1000;
    public static final double MAX_AMOUNT = 1000;
    public static final int DELAY = 10;

    public static void main(String[] args) {
        Bank bank = new Bank(NACCOUNTS, INITIAL_BALANCE);
        for (int i = 0; i < NACCOUNTS; i++) {
            int fromAccount = i;
            Runnable r = () -> {
                try {
                    while (true) {
                        int toAccount = (int) (bank.size() * Math.random());
                        double amount = MAX_AMOUNT * Math.random();
                        bank.transfer(fromAccount, toAccount, amount);
                        Thread.sleep((int) (DELAY * Math.random()));
                    }
                } catch (InterruptedException e) {
                }
            };
            Thread t = new Thread(r);
            t.start();
        }
    }
}

/**
 * A bank with a number of bank accounts.
 *
 * @author Cay Horstmann
 * @version 1.30 2004-08-01
 */
class Bank {
    private final double[] accounts;

    /**
     * Constructs the bank.
     *
     * @param n              the number of accounts
     * @param initialBalance the initial balance for each account
     */
    public Bank(int n, double initialBalance) {
        accounts = new double[n];
        Arrays.fill(accounts, initialBalance);
    }

    /**
     * Transfers money from one account to another.
     *
     * @param from   the account to transfer from
     * @param to     the account to transfer to
     * @param amount the amount to transfer
     */
    public void transfer(int from, int to, double amount) {
        if (accounts[from] < amount)
            return;
        System.out.print(Thread.currentThread());
        accounts[from] -= amount;
        System.out.printf(" %10.2f from %d to %d", amount, from, to);
        accounts[to] += amount;
        System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());
    }

    /**
     * Gets the sum of all account balances.
     *
     * @return the total balance
     */
    public double getTotalBalance() {
        double sum = 0;

        for (double a : accounts)
            sum += a;

        return sum;
    }

    /**
     * Gets the number of accounts in the bank.
     *
     * @return the number of accounts
     */
    public int size() {
        return accounts.length;
    }
}
