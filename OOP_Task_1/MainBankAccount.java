
import java.util.Scanner;

public class MainBankAccount {
    public static void main(String[] args) {
        // Account account = new Account(0.0);
        // Account account = new DepositAccount(0.0);
        Account account = new CreditAccount(0.0);

        for (; ; ) {
            System.out.println("\nSpecify your operation:\n\ncheck - check balance \nadd - put new money to the account \ntake - take your money from \nexit - end of operation");
            Scanner scanner = new Scanner(System.in);
            String cmd = scanner.nextLine();
            
            if (cmd.equals("check")) {
                System.out.println("Balance your account is: " + account.getAmount() );
            } 
            else if (cmd.equals("add")) {
                System.out.println("Input Sum ");
                double inp = scanner.nextDouble();
                account.add(inp);
                System.out.println("deposited sum " + inp);
                System.out.println("Balance your account is: " + account.getAmount());
            } 
            else if (cmd.equals("take")) {
                System.out.println("Input desired sum ");
                double ou = scanner.nextDouble();
                account.take(ou);
                System.out.println("debited from your account: " + ou);
                System.out.println("Balance your account is: " + account.getAmount());
                scanner.close();
            } 
            else if (cmd.equals("exit")) {
                System.out.println("Goodbye!");
                break;
            } 
            else {
                System.out.println("Here is mistake in entered data ");
            }
        
        }
    }
}