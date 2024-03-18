public class SavingAccount extends Account {
    private double minimumBalance;

    public SavingAccount(double minimumBalance) {
        this.minimumBalance = minimumBalance;
    }

    @Override
    public void willdraw(double amount) {
        // Lógica para validar retiro en cuenta de ahorros
        if (balance - amount >= minimumBalance) {
            balance -= amount;
        } else {
            System.out.println("Retiro no autorizado. Saldo mínimo requerido no cumplido en la cuenta de ahorros " + accountNumber);
        }
    }

    @Override
    public void deposit(double amount) {
        
    }

    @Override
    public void transfer(Account destination, double amount) {
        
    }

   
    
}
