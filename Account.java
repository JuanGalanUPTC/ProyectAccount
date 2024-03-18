import java.util.List;

public abstract class Account implements ActionsAccount {

    // Atributos protegidos (accesibles desde las subclases)
    protected String accountNumber;
    protected double balance;
  
    // Constructor vacío
    public Account() {
    }
  
    // Constructor con parámetros
    public Account(String accountNumber, double balance) {
      this.accountNumber = accountNumber;
      this.balance = balance;
    }
  
    // Getters y Setters
    public String getAccountNumber() {
      return accountNumber;
    }
  
    public void setAccountNumber(String accountNumber) {
      this.accountNumber = accountNumber;
    }
  
    public double getBalance() {
      return balance;
    }
  
    public void setBalance(double balance) {
      this.balance = balance;
    }
  
    // Métodos abstractos (implementados en las subclases)
    @Override
    public abstract void deposit(double amount);
  
    @Override
    public abstract void willdraw(double amount);
  
    @Override
    public abstract void transfer(Account destination, double amount);
  
    // Método toString para formatear la información de la cuenta
    @Override
    public String toString() {
      return String.format("| %-15s | %.2f |", accountNumber, balance);
    }

    public List<Transaction> getTransactions() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTransactions'");
    }

    public void addTransaction(Transaction transaction) {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'addTransaction'");
    }
  }
  