package Problem1;
import java.util.Scanner;

public class CommandLineInterface {
    public static void main(String[] args) {
        FinancialSystem financialSystem = new FinancialSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter a command: ");
            String command = scanner.nextLine();
            String[] parts = command.split(" ");

            if (parts[0].equals("add_transaction")) {
                if (parts.length == 2) {
                    String[] transactionInfo = parts[1].split(",");
                    if (transactionInfo.length == 3) {
                        String debtor = transactionInfo[0];
                        String creditor = transactionInfo[1];
                        int amount = Integer.parseInt(transactionInfo[2]);
                        financialSystem.addTransaction(debtor, creditor, amount);
                    } else {
                        System.out.println("Invalid add_transaction command. Please use the format: add_transaction A,B,X");
                    }
                } else {
                    System.out.println("Invalid add_transaction command. Please use the format: add_transaction A,B,X");
                }
            } else if (parts[0].equals("query_debt")) {
                if (parts.length == 2) {
                    String person = parts[1];
                    int debt = financialSystem.queryDebt(person);
                    System.out.println(person + " owes a total of " + debt + " money.");
                } else {
                    System.out.println("Invalid query_debt command. Please use the format: query_debt A");
                }
            } else if (parts[0].equals("query_money_owed")) {
                if (parts.length == 2) {
                    String person = parts[1];
                    int moneyOwed = financialSystem.queryMoneyOwed(person);
                    System.out.println(person + " is owed a total of " + moneyOwed + " money.");
                } else {
                    System.out.println("Invalid query_money_owed command. Please use the format: query_money_owed B");
                }
            } else if (parts[0].equals("query_most_money_owed")) {
                String person = financialSystem.queryPersonWithMostMoneyOwed();
                System.out.println(person + " is owed the most money.");
            } else if (parts[0].equals("query_most_debt")) {
                String person = financialSystem.queryPersonWithMostDebt();
                System.out.println(person + " owes the most money.");
            } else {
                System.out.println("Invalid command. Please try again.");
            }
        }
    }
}
