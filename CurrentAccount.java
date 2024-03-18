public class CurrentAccount extends Account {
 
    @Override
    public void willdraw(double amount) {
    
    if (balance >= amount) {
    balance -= amount;
    } else {
    System.out.println("Fondos insuficientes en la cuenta corriente " + accountNumber);
    }
    }

    @Override
    public void deposit(double amount) {
        
    }

    @Override
    public void transfer(Account destination, double amount) {
        
    }

    
}
   