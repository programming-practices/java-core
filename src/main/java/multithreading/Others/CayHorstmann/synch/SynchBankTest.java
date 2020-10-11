package multithreading.Others.CayHorstmann.synch;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * This program shows how multiple threads can safely access a data structure.
 *
 * @author Cay Horstmann
 * @version 1.31 2015-06-21
 */
public class SynchBankTest {
    public static final int NACCOUNTS = 100;
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
 * A bank with a number of bank accounts that uses locks for serializing access.
 *
 * @author Cay Horstmann
 * @version 1.30 2004-08-01
 */
class Bank {

    private final double[] accounts;
    private Lock bankLock;
    /*С объектом блокировки может быть связан один или несколько объектов условий, которые получены с помощью метода
     * new Condition(). Каждому объекту условия можно присвоить имя, напоминающее об условии, которое он представляет.*/
    private Condition sufficientFunds;

    /**
     * Constructs the bank.
     *
     * @param n              the number of accounts
     * @param initialBalance the initial balance for each account
     */
    public Bank(int n, double initialBalance) {
        accounts = new double[n];
        Arrays.fill(accounts, initialBalance);
        bankLock = new ReentrantLock();
        sufficientFunds = bankLock.newCondition();
    }

    /**
     * Transfers money from one account to another.
     *
     * @param from   the account to transfer from
     * @param to     the account to transfer to
     * @param amount the amount to transfer
     */
    public void transfer(int from, int to, double amount) throws InterruptedException {
        bankLock.lock();
        try {
            while (accounts[from] < amount)
                // Текущий поток исполнения теперь деактивизирован и снимает блокировку.
                sufficientFunds.await();
            System.out.print(Thread.currentThread());
            accounts[from] -= amount;
            System.out.printf(" %10.2f from %d to %d", amount, from, to);
            accounts[to] += amount;
            System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());
            /*Имеется существенное отличие между потоком, ожидающим возможности за­хватить блокировку, и потоком, который
             * вызвал метод await(). Как только в потоке исполнения вызывается метод await(), он входит в набор ожидания,
             * установленный для данного условия. Поток не становится исполняемым, когда оказывается доступ­ной блокировка.
             * Вместо этого он остается деактивизированным до тех пор, пока дру­гой поток не вызовет метод signalАll() по
             * тому же условию.
             *
             * В результате этого вызова активизируются все потоки исполнения, ожидающие данного условия. Когда потоки удаляются
             * из набора ожидания, они опять становятся исполняемыми, и в конечном итоге планировщик потоков активизирует их
             * снова. В этот момент они попытаются повторно захватить объект блокировки. И как толь­ко он окажется доступным,
             * один из этих потоков захватит блокировку и продолжит свое исполнение с того места, где он остановился, получив
             * управление после вызова метода await().
             * В этот момент условие должно быть снова проверено в потоке исполнения. Но нет никаких гарантий, что условие
             * теперь выполнится. Ведь метод signalAll() просто сигнализирует ожидающим потокам о том, что условие теперь
             * может быть удовлет­ ворено и что его стоит проверить заново.
             *
             * Когда же следует вызывать метод signalAll()? Существует эмпирическое пра­вило: вызывать этот метод при таком
             * изменении состояния объекта, которое может быть выгодно ож идающим потокам исполнения. Например, всякий раз,
             * когда из­ меняются остатки на счетах, ожидающим потокам исполнения следует давать оче­редную возможность для
             * проверки остатков на счетах.*/
            sufficientFunds.signalAll();
        } finally {
            bankLock.unlock();
        }
    }

    /**
     * Gets the sum of all account balances.
     *
     * @return the total balance
     */
    public double getTotalBalance() {
        bankLock.lock();
        try {
            double sum = 0;

            for (double a : accounts)
                sum += a;

            return sum;
        } finally {
            bankLock.unlock();
        }
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

/*
--------------------------------------------------------------------------------------------------------------------------
ВНИМАНИЕ! По условию в потоке исполнения может быть вызван только метод await(), signalAll() или signal(), когда этот поток 
владеет блокировкой по данному условию.
--------------------------------------------------------------------------------------------------------------------------
*/
