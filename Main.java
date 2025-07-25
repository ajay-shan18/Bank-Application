import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<String> ministatement = new ArrayList<>();

    public static void main(String[] args) {
        boolean isrun = true;
        double balance = 0;
        int choice;

        while (isrun) {
            System.out.println();
           // System.out.println("*************************");
            System.out.println("Welcome to bank with SBI");
            System.out.println("*************************");
            System.out.println("1. Show Balance");
            System.out.println("2. Money Deposit");
            System.out.println("3. Money Withdrawal");
            System.out.println("4. Ministatement");
            System.out.println("5. Exit");
            System.out.println("*************************");
            System.out.println("Enter Your Choice (1-5): ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> showBalance(balance);
                case 2 -> {
                    double amt = deposit();
                    if (amt > 0) {
                        balance += amt;
                        ministatement.add("Credited: $" + String.format("%.2f", amt));
                    }
                }
                case 3 -> {
                    double amt = withdraw(balance);
                    if (amt > 0) {
                        balance -= amt;
                        ministatement.add("Debited: $" + String.format("%.2f", amt));
                    }
                }
                case 4 -> showMinistatement();
                case 5 -> isrun = false;
                default -> System.out.println("1001-Error****Enter Valid Choice***** ");
            }
        }
        System.out.println("******************************************************************");
        System.out.println("!!!Thank You For Using The SBI Banking Services Have a Nice Day!!!");
        System.out.println("******************************************************************");

    }

    public static void showBalance(double balance) {
        System.out.printf("Balance: $%.2f\n", balance);
    }

    public static double deposit() {
        double amount;
        System.out.println("Enter Amount To Deposit:");
        amount = sc.nextDouble();
        if (amount <= 0) {
            System.out.println("Deposit Amount must be greater than 0");
            return 0;
        } else {
            System.out.println("Money Deposited successfully");
            return amount;
        }
    }

    public static double withdraw(double balance) {
        double amount;
        System.out.println("Enter Amount to Withdraw: ");
        amount = sc.nextDouble();
        if (amount <= 0) {
            System.out.println("Enter positive amount to withdraw");
            return 0;
        } else if (balance < amount) {
            System.out.println("Insufficient Balance");
            return 0;
        } else {
            System.out.println("**************Amount Withdrawn Successfully*************");
            return amount;
        }
    }

    public static void showMinistatement() {
        System.out.println("************* Ministatement *************");
        if (ministatement.isEmpty()) {
            System.out.println("No transactions Found");
        } else {
            for (String entry : ministatement) {
                System.out.println(entry);
            }
        }
        System.out.println("************* Ministatement *************");
    }
}
