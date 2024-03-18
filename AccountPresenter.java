import java.util.List;

public class AccountPresenter {
    private HandlingAccount handlingAccount;

    public AccountPresenter(HandlingAccount handlingAccount) {
        this.handlingAccount = handlingAccount;
    }

    public String[] findAccount(String accountNumber) {
        Account account = handlingAccount.findAccount(accountNumber);
        if (account != null) {
            return new String[]{"Número de cuenta: " + account.getAccountNumber(), "Saldo: " + account.getBalance()};
        }
        return new String[]{"Cuenta no encontrada"};
    }

    public boolean saveAccount(String accountNumber, double balance) {
        Account account = new Account(accountNumber, balance);
        return handlingAccount.saveAccount(account);
    }

    public Account deleteAccount(String accountNumber) {
        Account account = handlingAccount.findAccount(accountNumber);
        if (account != null) {
            handlingAccount.deleteAccount(account);
            return account;
        }
        return null;
    }

    public double deposit(String accountNumber, double amount) {
        Account account = handlingAccount.findAccount(accountNumber);
        if (account != null) {
            return handlingAccount.deposit(account, amount);
        }
        return 0.0;
    }

    public double willdraw(String accountNumber, double amount) {
        Account account = handlingAccount.findAccount(accountNumber);
        if (account != null) {
            try {
                return handlingAccount.willdraw(account, amount);
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
        return 0.0;
    }

    public boolean transfer(String originAccountNumber, String destinationAccountNumber, double amount) {
        Account originAccount = handlingAccount.findAccount(originAccountNumber);
        Account destinationAccount = handlingAccount.findAccount(destinationAccountNumber);
        if (originAccount != null && destinationAccount != null) {
            return handlingAccount.transfer(originAccount, destinationAccount, amount);
        }
        return false;
    }

    public double payRate(String accountNumber) {
        Account account = handlingAccount.findAccount(accountNumber);
        if (account instanceof SavingAccount) {
            handlingAccount.payRate(account);
            return account.getBalance();
        }
        return 0.0;
    }

    public double averageAccount() {
        List<Account> accounts = handlingAccount.getAccounts();
        double totalBalance = 0.0;
        for (Account account : accounts) {
            totalBalance += account.getBalance();
        }
        if (accounts.size() > 0) {
            return totalBalance / accounts.size();
        }
        return 0.0;
    }
}
