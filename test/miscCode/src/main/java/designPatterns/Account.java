package designPatterns;

public class Account {
    private float balance;

    public Account() {
        System.out.println("Start balance: " + balance);
        System.out.println("-".repeat(10));
    }

    public Account(float balance) {
        this.balance = balance;
        System.out.println("Start balance: " + balance);
        System.out.println("-".repeat(10));
    }

    public void deposit(float amount) {
        if (amount > 0) balance += amount;
        System.out.println("deposit: " + amount);
        System.out.println("balance: " + balance);
        System.out.println("-".repeat(10));
    }

    public void withdraw(float amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println("withdraw: " + amount);
            System.out.println("balance: " + balance);
            System.out.println("-".repeat(10));
        } else {
            System.out.println("withdraw: " + 0);
            System.out.println("balance: " + balance);
            System.out.println("-".repeat(10));
        }
    }

/*
    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        if (balance > 0) this.balance = balance;
    }
*/
}
