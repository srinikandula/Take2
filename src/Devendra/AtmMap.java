package StreamsExamples;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by devendra on 3/4/2016.
 */
public class AtmMap {
    private Map<Long, Account> accounts = new HashMap<Long, Account>();

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        AtmMap api = new AtmMap();
        int option = 0;
        do {
            System.out.println("Please select from below..");
            System.out.println("1.Create Account");
            System.out.println("2.Account Balance");
            System.out.println("3.Delete Account");
            System.out.println("4.Deposit");
            System.out.println("5.Withdraw ");
            System.out.println("6.Create Folder");
            System.out.println("7.Exit");
            option = s.nextInt();
            switch (option){
                case 1:
                    api.createAccount();
                    break;
                case 2:
                    api.AccountBalance();
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
                    System.out.println("Please enter the folder name");
                    String folderName = s.next();
                    File folder = new File(folderName);
                    boolean created = folder.mkdirs();
                    System.out.println("Folder Created" + created);
                    folder.isDirectory();
                case 7:
                    System.out.println("Thank you for using AtmMap");
                    System.exit(1);
                default:
                    System.err.println("Please Select valid Option");
            }
        } while (option != 7);
    }

    public void createAccount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the account number");
        long accountNumber = scanner.nextLong();
        System.out.println("Please enter the first  name");
        String firstName = scanner.next();
        System.out.println("Please enter the last name");
        String lastName = scanner.next();
        System.out.println("Please enter the account balance");
        int accountBalance = scanner.nextInt();
        Account acc = new Account();
        acc.setAccNum(accountNumber);
        acc.setFirstName(firstName);
        acc.setLastName(lastName);
        acc.setBalance(accountBalance);
        if (accounts.containsKey(accountNumber)) {
            System.out.println("Please try again with different account number");
        } else {
            accounts.put(accountNumber, acc);
            System.out.println("Account Created");
        }
    }

    public void AccountBalance() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the account number");
        long accountNumber1 = scanner.nextLong();
        Account account = accounts.get(accountNumber1);
        if (accountNumber1 == account.getAccNum()) {
            System.out.println("The account balance is " + account.getBalance());
        } else {
            System.err.println("Please enter valid account number");
        }
    }

    public void deleteAccount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the account number for deposit");
        long accountNumber = scanner.nextLong();
        Account account = accounts.get(accountNumber);
        if (account.getAccNum() == accountNumber) {
            accounts.remove(account);
        } else {
            System.out.println("Please enter valid account number");
        }
    }

    public void deposit() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the account number for deposit");
        long accountNumber = scanner.nextLong();
        Account account = accounts.get(accountNumber);
            if (account.getAccNum() == accountNumber) {
                System.out.println("Please enter the amount to be deposited");
                Scanner scanner1 = new Scanner(System.in);
                double depositedAmount = scanner1.nextDouble();
                double balance1 = account.getBalance();
                balance1 += depositedAmount;
                account.setBalance(balance1);
                //account.setBalance((long) (account.getBalance() + amount));
                System.out.println("Your total balance after deposit is " + account.getBalance());
            } else {
                System.out.println("Please enter valid account number");
            }

        }


    public void withdraw() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the account number for withdraw");
        long accountNumber = scanner.nextLong();
        Account account = accounts.get(accountNumber);
        if (account.getAccNum() == accountNumber) {
            System.out.println("Please enter the amount to be withdrawn");
            Scanner scanner1 = new Scanner(System.in);
            double withdrawAmount = scanner1.nextDouble();
            double balance = account.getBalance();

            if (withdrawAmount > balance) {
                System.err.println("Please enter the amount within balance range");
            } else {
                balance =balance - withdrawAmount;
                account.setBalance(balance);
                System.out.println("Your transaction is successful");
                System.out.println("Your available balance after withdraw is " + account.getBalance());
            }
        }
    }


    }


