package YouTube_Channels.Computer_Science_Center.Mnoho_potochnost_v_java_osnovu._2;

public class Account {
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

    public synchronized void deposit(long amount) {
        checkAmountNonNegative(amount);
        balance += amount;
        this.notifyAll();

    }

    public synchronized void withdraw(long amount) {
        checkAmountNonNegative(amount);
        if (balance < amount) {
            throw new IllegalArgumentException("not enough money");
        }
        balance -= amount;
    }

    public synchronized void whaitAndWithdraw(long amount) throws InterruptedException {
        checkAmountNonNegative(amount);
        while (balance < amount) {
            this.wait();
        }
        balance -= amount;
    }
}
