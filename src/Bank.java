import java.util.*;
import java.io.*;

public class Bank {

    private ArrayList<Account> accounts;
    private final String FILE_NAME = "src/data.txt";

    public Bank() {
        accounts = new ArrayList<>();
        loadAccountsFromFile();
    }

    // Create account
    public void createAccount(int accNo, String name, double balance) {
        Account newAccount = new Account(accNo, name, balance);
        accounts.add(newAccount);
        saveAccountsToFile();
        System.out.println("Account created successfully.");
    }

    // Find account
    public Account findAccount(int accNo) {
        for (Account acc : accounts) {
            if (acc.getAccountNumber() == accNo) {
                return acc;
            }
        }
        return null;
    }

    // Deposit
    public void deposit(int accNo, double amount) {
        Account acc = findAccount(accNo);
        if (acc != null) {
            acc.deposit(amount);
            saveAccountsToFile();
        } else {
            System.out.println("Account not found.");
        }
    }

    // Withdraw
    public void withdraw(int accNo, double amount) {
        Account acc = findAccount(accNo);
        if (acc != null) {
            acc.withdraw(amount);
            saveAccountsToFile();
        } else {
            System.out.println("Account not found.");
        }
    }

    // Display
    public void displayAccount(int accNo) {
        Account acc = findAccount(accNo);
        if (acc != null) {
            acc.displayDetails();
        } else {
            System.out.println("Account not found.");
        }
    }

    // Save accounts to file
    private void saveAccountsToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Account acc : accounts) {
                writer.write(acc.getAccountNumber() + "," +
                             acc.getName() + "," +
                             acc.getBalance());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    // Load accounts from file
    private void loadAccountsFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                int accNo = Integer.parseInt(data[0]);
                String name = data[1];
                double balance = Double.parseDouble(data[2]);
                accounts.add(new Account(accNo, name, balance));
            }
        } catch (IOException e) {
            System.out.println("Error loading data: " + e.getMessage());
        }
    }
}