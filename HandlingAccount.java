import java.util.*;

public class HandlingAccount<CheckingAccount> {

    private List<Account> accounts = new ArrayList<>();

    public void saveAccount(Account account, String accountNumber, double initialBalance, Date creationDate) throws InvalidDateException {
        if (creationDate.after(new Date())) {
            throw new InvalidDateException("La fecha de creación no puede ser posterior a la fecha actual");
        }
        account.setAccountNumber(accountNumber);
        account.setBalance(initialBalance);
        account.addTransaction(new Transaction(1, accountNumber, initialBalance, "Creación", (java.sql.Date) creationDate));
        accounts.add(account);
        System.out.println("Nueva cuenta creada: " + account.getClass().getSimpleName() + ", Número de cuenta: " + accountNumber + ", Saldo inicial: " + initialBalance);
    }

    public void deposit(String accountNumber, double amount) {
        Account account = findAccount(accountNumber);
        if (account != null) {
            account.deposit(amount);
            account.addTransaction(new Transaction(getLastTransactionId(accountNumber) + 1, accountNumber, amount, "Depósito", (java.sql.Date) new Date()));
            System.out.println("Depósito de " + amount + " a la cuenta " + accountNumber + " realizado exitosamente");
        } else {
            System.out.println("No se encontró la cuenta con el número " + accountNumber);
        }
    }

    public void willdraw(String account2, double amount) {
        Account account = findAccount(account2);
        if (account != null) {
            account.willdraw(amount);
            account.addTransaction(new Transaction(getLastTransactionId(account2) + 1, account2, -amount, "Retiro", (java.sql.Date) new Date()));
        } else {
            System.out.println("No se encontró la cuenta con el número " + account2);
        } 
    }

    public void transfer(String originAccountNumber, String destinationAccountNumber, double amount) {
        Account origin = findAccount(originAccountNumber);
        Account destination = findAccount(destinationAccountNumber);
        if (origin != null && destination != null) {
            origin.transfer(destination, amount);
            origin.addTransaction(new Transaction(getLastTransactionId(originAccountNumber) + 1, originAccountNumber, -amount, "Transferencia", (java.sql.Date) new Date()));
            destination.addTransaction(new Transaction(getLastTransactionId(destinationAccountNumber) + 1, destinationAccountNumber, amount, "Transferencia", (java.sql.Date) new Date()));
        } else {
            System.out.println("Una de las cuentas especificadas no existe");
        }
    }

    public double averageAccount() {
        double totalBalance = 0.0;
        for (Account account : accounts) {
            totalBalance += account.getBalance();
        }
        return totalBalance / accounts.size();
    }

    public List<Account> getAccounts() {
        return new ArrayList<>(accounts);
    }

    public Account findAccount(String accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }

    private int getLastTransactionId(String accountNumber) {
        Account account = findAccount(accountNumber);
        List<Transaction> transactions = account.getTransactions();
        if (transactions.isEmpty()) {
            return 0;
        } else {
            return transactions.get(transactions.size() - 1).getId();
        }
    }


    public boolean saveAccount(Account account) {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'saveAccount'");
    }

    public void deleteAccount(Account account) {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'deleteAccount'");
    }

    public double deposit(Account account, double amount) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deposit'");
    }

    public double willdraw(Account account, double amount) {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'willdraw'");
    }

    public boolean transfer(Account originAccount, Account destinationAccount, double amount) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'transfer'");
    }

    public void payRate(Account account) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'payRate'");
    }

    public void getAccounts(Account account){
      
    }

    
}

class InvalidDateException extends Exception {
    public InvalidDateException(String message) {
        super(message);
    }
}



