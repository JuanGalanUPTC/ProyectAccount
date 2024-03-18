public interface ActionsAccount {
    void deposit(double amount);
    void willdraw(double amount);
    void transfer(Account destination, double amount);
}
