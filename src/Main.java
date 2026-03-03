import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Bank bank = new Bank();
        Scanner sc = new Scanner(System.in);

        int choice;

        do {
            System.out.println("\n===== BANKING SYSTEM =====");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Display Account");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Account Number: ");
                    int accNo = sc.nextInt();
                    sc.nextLine(); // consume newline

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Initial Balance: ");
                    double balance = sc.nextDouble();

                    bank.createAccount(accNo, name, balance);
                    break;

                case 2:
                    System.out.print("Enter Account Number: ");
                    int depAcc = sc.nextInt();

                    System.out.print("Enter Deposit Amount: ");
                    double depAmount = sc.nextDouble();

                    bank.deposit(depAcc, depAmount);
                    break;

                case 3:
                    System.out.print("Enter Account Number: ");
                    int withAcc = sc.nextInt();

                    System.out.print("Enter Withdraw Amount: ");
                    double withAmount = sc.nextDouble();

                    bank.withdraw(withAcc, withAmount);
                    break;

                case 4:
                    System.out.print("Enter Account Number: ");
                    int dispAcc = sc.nextInt();

                    bank.displayAccount(dispAcc);
                    break;

                case 5:
                    System.out.println("Exiting system... Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 5);

        sc.close();
    }
}