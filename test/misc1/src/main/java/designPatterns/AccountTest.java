package designPatterns;

public class AccountTest {
    public static void main(String[] args) {
        Account account = new Account();
        account.deposit(10);
        account.withdraw(5);
        account.withdraw(50);
    }
}
