package Devendra;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by devendra on 3/4/2016.
 */
public class AtmList {

    private ArrayList<Account> accounts = new ArrayList();

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        AtmList api = new AtmList();
        int option = 0;
        do {
            System.out.println("Please choose from the following options....");
            System.out.println("1.Create Account");
            System.out.println("2.Account balance");
            System.out.println("3.Delete Account");
            System.out.println("4.Deposit");
            System.out.println("5.Withdraw");
            System.out.println("6.Create folder");
            System.out.println("7.Exit");
            option = s.nextInt();
            switch (option) {
                case 1:
                    api.createAccount();
                    break;
                case 2:
                    api.findAccountBalance();
                    break;
                case 3:
                    api.deleteAccount();
                    break;
                case 4:
                    api.deposit();
                    break;
                case 5:
                    api.withdraw();
                    break;
                case 6:
                    System.out.println("Please enter folder name ");
                    String fodlerName = s.next();
                    File folder = new File(fodlerName);
                    boolean created = folder.mkdirs();
                    System.out.println("folder created? " + created);
                    folder.isDirectory();

                case 7:
                    System.out.println("Thank you for using our ATM simulator");
                    System.exit(1);
                default:
                    System.err.println("invalid option selected");
            }
        } while (option != 7);

    }

    public void createAccount() {
        //read account number
        //read name
        //read balance
        Scanner scanner = new Scanner(System.in);
        Account acc = new Account();
        System.out.println("Please enter the account number");
        int accountNumber = scanner.nextInt();
        System.out.println("Please enter the first name");
        String firstName = scanner.next();
        System.out.println("Please enter the last name");
        String lastName = scanner.next();
       /* System.out.println("Please enter the account name");
        String name = scanner.next(); */
        System.out.println("Please enter the account balance");
        int accountBalance = scanner.nextInt();
        acc = new Account();
        acc.setAccNum(accountNumber);
       // acc.setFirstName(name);
        acc.setBalance(accountBalance);
        accounts.add(acc);
        System.out.println("Account has been successfully Created");
    }

    public void findAccountBalance() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the account number");
        int accountNumber = scanner.nextInt();
        for (Account account : accounts) {
            if (account.getAccNum() == accountNumber) {
                System.out.println("The account balance is " + account.getBalance());
            } else {
                System.out.println("The account number you entered is invalid");
            }
        }
    }

    public void deleteAccount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the account number");
        final int accountNumber = scanner.nextInt();
        for (Account account : accounts) {
            if (account.getAccNum() == accountNumber) {
                accounts.remove(accountNumber);
                System.out.println("The account has been deleted");
            }
        }
    }

    public void deposit() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the account number");
        int accountNumber = scanner.nextInt();
        for (Account account : accounts) {
            if (account.getAccNum() == accountNumber) {
                System.out.println("Please enter the amount to deposit");
                Scanner scanner1 = new Scanner(System.in);
                int balance = (int) account.getBalance();
                int amount = scanner1.nextInt();
                int accountbalance = (int) account.getBalance();
                account.setBalance(account.getBalance() + amount);
                System.out.println("The current balance is " + account.getBalance());
            } else {
                System.out.println("The account number you entered is invalid");
            }
        }
    }


    public void withdraw() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the account number");
        int accountNumber = scanner.nextInt();
        for (Account account : accounts) {
            if (account.getAccNum() == accountNumber) {
                System.out.println("Please enter the amount to withdraw");
                Scanner scanner1 = new Scanner(System.in);
                int balance = (int) account.getBalance();
                int amount = scanner1.nextInt();
                if (amount > balance) {
                    System.out.println("Please the amount within the balance range");
                } else {
                    int accountbalance = (int) account.getBalance();
                    account.setBalance(amount - account.getBalance());
                    System.out.println("The current balance is " + account.getBalance());
                }
            }
        }
    }
}




