import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Main {

  public static void main(String[] args) throws Exception {
    HandlingAccount handlingAccount = new HandlingAccount();
    Scanner scanner = new Scanner(System.in);

    int opcion;
    do {
      System.out.println("\nMenu principal");
      System.out.println("1. Crear cuenta");
      System.out.println("2. Realizar transacción");
      System.out.println("3. Consultar una cuenta");
      System.out.println("4. Consultar transacciones de una cuenta");
      System.out.println("5. Visualizar información de las cuentas");
      System.out.println("6. Salir");
      System.out.print("Ingrese su opción: ");
      opcion = scanner.nextInt();

      switch (opcion) {
        case 1:
          crearCuenta(handlingAccount, scanner);
          break;
        case 2:
          realizarTransaccion(handlingAccount, scanner);
          break;
        case 3:
          consultarCuenta(handlingAccount, scanner);
          break;
        case 4:
          consultarTransacciones(handlingAccount, scanner);
          break;
        case 5:
          visualizarCuentas(handlingAccount);
          break;
        case 6:
          System.out.println("Saliendo del sistema...");
          break;
        default:
          System.out.println("Opción inválida.");
      }
    } while (opcion != 6);
  }

  // Métodos para cada opción del menú:

  private static void visualizarCuentas(HandlingAccount handlingAccount) {
      System.out.println("Listado de cuentas:");
      for (Account account : handlingAccount.getAccounts()) {
          System.out.println(account); // Assuming Account class has a toString() method
      }
  }

  private static void consultarTransacciones(HandlingAccount handlingAccount, Scanner scanner) {
    String accountNumber;
    System.out.print("Ingrese el número de cuenta: ");
    accountNumber = scanner.nextLine();

    Account account = handlingAccount.findAccount(accountNumber);
    if (account == null) {
        System.out.println("No se encontró la cuenta con el número " + accountNumber);
        return;
    }

    // Implement logic to display transactions of the account (e.g., loop through transactions list)
    System.out.println("Historial de transacciones de la cuenta " + accountNumber);
    for (Transaction transaction : account.getTransactions()) {
        System.out.println(transaction); // Assuming Transaction class has a toString() method
    }
    }

  private static void crearCuenta(HandlingAccount handlingAccount, Scanner scanner) throws Exception {
    String tipoCuenta;
  System.out.print("Seleccione el tipo de cuenta (Ahorros, Corriente): ");
  tipoCuenta = scanner.nextLine().toUpperCase();

      if (!tipoCuenta.equals("AHORROS") && !tipoCuenta.equals("CORRIENTE")) {
    throw new RuntimeException("Tipo de cuenta no válido");
    }

      String accountNumber = generateAccountNumber(); // Define this method to generate a unique number
      System.out.print("Ingrese el nombre del titular: ");
     String ownerName = scanner.nextLine();
      System.out.print("Ingrese el saldo inicial: ");
      double initialBalance = scanner.nextDouble();
      System.out.print("Ingrese la fecha de creación (formato dd/mm/aaaa): ");
      String creationDateString = scanner.nextLine();
      Date creationDate = new SimpleDateFormat("dd/MM/yyyy").parse(creationDateString);

    switch (tipoCuenta) {
      case "AHORROS":
          handlingAccount.saveAccount(new SavingAccount(initialBalance), accountNumber, initialBalance, creationDate);
          break;
          
    } 
  }

  private static void realizarTransaccion(HandlingAccount handlingAccount, Scanner scanner) {
    String accountNumber;
    System.out.print("Ingrese el número de cuenta: ");
    accountNumber = scanner.nextLine();

    Account account = handlingAccount.findAccount(accountNumber);
    if (account == null) {
      System.out.println("No se encontró la cuenta con el número " + accountNumber);
      return;
    }

    System.out.println("\nOpciones de transacción:");
    System.out.println("1. Depósito");
    System.out.println("2. Retiro");
    System.out.print("Ingrese su opción: ");
    int transactionOption = scanner.nextInt();

    switch (transactionOption) {
      case 1:
        System.out.print("Ingrese la cantidad a depositar: ");
        double depositAmount = scanner.nextDouble();
        handlingAccount.deposit(accountNumber, depositAmount);
        break;
      case 2:
        System.out.print("Ingrese la cantidad a retirar: ");
        double withdrawAmount = scanner.nextDouble();
        handlingAccount.willdraw(accountNumber, withdrawAmount);
        break;
      default:
        System.out.println("Opción inválida.");
    }
  }

  private static void consultarCuenta(HandlingAccount handlingAccount, Scanner scanner) {
    String accountNumber;
    System.out.print("Ingrese el número de cuenta: ");
    accountNumber = scanner.next();
  }

  private static String generateAccountNumber() {
    Random random = new Random();
    return String.format("%010d", random.nextInt(900000000) + 100000000);
}
}