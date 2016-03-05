package Devendra;

import java.io.*;
import java.util.Scanner;

/**
 * Created by devendra on 2/29/2016.
 */

public class AtmMachine {
    //public balance = 0;
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        AtmMachine api = new AtmMachine();
        int option = 0;
        do {
            System.out.println("Please make your selection");
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
                    String fodlerName = s.nextLine();
                    File folder = new File(fodlerName);
                    folder.mkdir();
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

        try {
            System.out.println("Please enter the account number");
            int accountNumber = scanner.nextInt();
            System.out.println("Please enter the account name");
            String name = scanner.next();
            System.out.println("Please enter the account balance");
            int accountBalance = scanner.nextInt();

            //accountnumber--accountname--balance
            String accountRecord = String.format("%d--%s--%d", accountNumber, name, accountBalance);

            //check if the account exists already
            String fileName = "account_" + accountNumber;
            System.out.println("Checking for file");
            File accountFile = new File(fileName);

            if (accountFile.exists()) {
                System.err.println("Account already exists with the number" + accountNumber);
            } else {
                PrintWriter outputStream = new PrintWriter(new FileWriter(accountFile));
                outputStream.print(accountRecord);
                System.out.println("Account is created successfully");
                outputStream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void findAccountBalance() {
        //read account number from console
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the account number");
        int accountNumber = scanner.nextInt();
        //look up the account file
        File accountFile = new File("account_" + accountNumber);
        if (!accountFile.exists()) {
            System.err.println("Account not found for number " + accountNumber);
        } else {
            try {
                //read data from account file
                Scanner accountReader = new Scanner(new FileInputStream(accountFile)).useDelimiter("--");
                String accNum = accountReader.next();
                String name = accountReader.next();
               String balance = accountReader.next();
                System.out.println("Account balance is " + balance);
                accountReader.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

    }

    public void deleteAccount() {
        //read account number
        System.out.println("deleteAccount called");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the account number");
        int accountNumber = scanner.nextInt();
        //look up the account file
        File accountFile = new File("account_" + accountNumber);
        if (!accountFile.exists()) {
            System.err.println("Account not found for number " + accountNumber);
        } else {
            accountFile.delete();
            System.out.println("Account has been deleted");
        }
    }

    public void deposit() {
        //read account number
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the account number");
        int accountNumber = scanner.nextInt();
        //look up the account file
        File accountFile = new File("account_" + accountNumber);
        if (!accountFile.exists()) {
            System.err.println("Account not found for number " + accountNumber);
        } else {

            //read data from account file
            Scanner accountReader;
            try {
                accountReader = new Scanner(new FileInputStream(accountFile)).useDelimiter("--");
                String accNum = accountReader.next();
                String name = accountReader.next();
                int balance = accountReader.nextInt();
                Scanner scanner1 = new Scanner(System.in);
                System.out.println("please enter the amount you would like to deposit");
                int amount1 = scanner1.nextInt();
                balance = balance + amount1;
                System.out.println("The Current balance is " + balance);
                PrintWriter outputStream = new PrintWriter(new FileWriter(accountFile));
                outputStream.printf("%d--%s--%d", accountNumber, name, balance);
                System.out.println("Account is updated successfully");
                outputStream.close();
                System.out.println("Account balance after Deposit is: "+ balance);
                accountReader.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

    }
    public void withdraw(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the account number");
        int accountNumber = scanner.nextInt();
        //look up the account file
        File accountFile = new File("account_" + accountNumber);
        if (!accountFile.exists()) {
            System.err.println("Account not found for number " + accountNumber);
        } else {

            //read data from account file
            Scanner accountReader;
            try {
                accountReader = new Scanner(new FileInputStream(accountFile)).useDelimiter("--");
                String accNum = accountReader.next();
                String name = accountReader.next();
                int balance = accountReader.nextInt();
                Scanner scanner1 = new Scanner(System.in);
                System.out.println("please enter the amount you would like to withdraw");
                int amount1 = scanner1.nextInt();
                if(amount1 > balance){
                    System.err.println("Please enter the amount within the balance range");
                    return;
                }else {
                    balance = balance - amount1;
                    System.out.println("The Current balance is " + balance);
                    PrintWriter outputStream = new PrintWriter(new FileWriter(accountFile));
                    outputStream.printf("%d--%s--%d", accountNumber, name, balance);
                    System.out.println("Balance updated successfully");
                    outputStream.close();
                    System.out.println("Account balance after Deposit is: " + balance);
                    accountReader.close();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();


            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
    }
}