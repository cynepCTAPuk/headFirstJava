package patterns.proxy.level07lecture02;

public class SecurityManager {

    public static boolean authorize(User user, BankAccounts.Manager manager) {
        return true;
    }
}
