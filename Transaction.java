import java.sql.Date;

public class Transaction {

    // Atributos
    private int id;
    private String accountNumber;
    private double amount;
    private String type; // Depósito, Retiro, Transferencia
    private Date date;
  
    // Constructor
    public Transaction(int id, String accountNumber, double amount, String type, Date date) {
      this.id = id;
      this.accountNumber = accountNumber;
      this.amount = amount;
      this.type = type;
      this.date = date;
    }
  
    // Getters y Setters
    public int getId() {
      return id;
    }
  
    public void setId(int id) {
      this.id = id;
    }
  
    public String getAccountNumber() {
      return accountNumber;
    }
  
    public void setAccountNumber(String accountNumber) {
      this.accountNumber = accountNumber;
    }
  
    public double getAmount() {
      return amount;
    }
  
    public void setAmount(double amount) {
      this.amount = amount;
    }
  
    public String getType() {
      return type;
    }
  
    public void setType(String type) {
      this.type = type;
    }
  
    public Date getDate() {
      return date;
    }
  
    public void setDate(Date date) {
      this.date = date;
    }
  
    // Método toString para formatear la información de la transacción
    @Override
    public String toString() {
      return String.format("| %d | %-15s | %.2f | %-10s | %s |", id, accountNumber, amount, type, date.toString());
    }
  }
  