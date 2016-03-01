package Amar;

import java.io.*;
import java.util.Scanner;
import java.nio.file.*;
/**
 * Created by Amar on 3/1/2016.
 */
public class AmarATMSimulator {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        AmarATMSimulator api = new AmarATMSimulator();
        int option = 0;
        do{
            System.out.println("Please make your selection");
            System.out.println("1.Create Account");
            System.out.println("2.Account balance");
            System.out.println("3.Delete Account");
            System.out.println("4.Deposit");
            System.out.println("5.Withdraw");
            System.out.println("6.Create folder");
            System.out.println("7.Exit");
            option = s.nextInt();
            switch (option){
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
                    api.makeDeposit();
                    break;
                case 5:
                    api.makeWithdrawal();
                    break;
                case 6:
                    api.createFolder();
                    break;
                case 7:
                    System.out.println("Thank you for using our ATM simulator");
                    System.exit(1);
                default:
                    System.err.println("invalid option selected");
            }
        }while(option !=7 );

    }
    public void createAccount(){
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
            String fileName = "account_"+accountNumber;
            //System.out.println("Checking for file");
            File accountFile = new File(fileName);
            if(accountFile.exists()){
                System.err.println("Account already exists with the number" + accountNumber);
            }else {
                PrintWriter outputStream = new PrintWriter(new FileWriter(accountFile));
                outputStream.print(accountRecord);
                System.out.println("Account is created successfully");
                outputStream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void findAccountBalance(){
        //read account number from console
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the account number");
        int accountNumber = scanner.nextInt();

        File accountFile = new File("account_"+accountNumber);

        //look up the account file
        if (accountFile.exists()) {
            try {
                //read data from account file
                Scanner accountReader = new Scanner(new FileInputStream(accountFile)).useDelimiter("--");
                String accNum = accountReader.next();
                String name = accountReader.next();
                String balance = accountReader.next();
                System.out.println("Account balance is "+ balance);
                accountReader.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            System.err.println("Account not found for number "+ accountNumber);
        }
    }
    public void deleteAccount(){
        //read account number
        //System.out.println("deleteAccount called");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the account number");
        int accountNumber = scanner.nextInt();
        //look up the account file
        File accountFile = new File("account_"+accountNumber);
        if(!accountFile.exists()){
            System.err.println("Account not found for number "+ accountNumber);
        }else {
            accountFile.delete();
            System.out.println("Account has been deleted");
        }
    }
    public void makeDeposit(){
        //read account number from console
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the account number");
        int accountNumber = scanner.nextInt();
        //look up the account file
        File accountFile = new File("account_"+accountNumber);
        if(!accountFile.exists()){
            System.err.println("Account not found for number "+ accountNumber);
        }else {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println("Please enter the amount to be deposited");
                int depositAmount = sc.nextInt();
                //read data from account file
                Scanner accountReader = new Scanner(new FileInputStream(accountFile)).useDelimiter("--");
                String accNum = accountReader.next();
                String accName = accountReader.next();
                int balance = Integer.parseInt(accountReader.next());
                balance += depositAmount;
                // write data into existing file
                PrintWriter outputStream = new PrintWriter(new FileWriter(accountFile));
                outputStream.printf("%d--%s--%d", accountNumber, accName, balance);
                System.out.println("Account is updated successfully");
                outputStream.close();
                System.out.println("Account balance after Deposit is: "+ balance);
                accountReader.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
    }
    public void makeWithdrawal(){
        //read account number from console
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter the account number");
        int accountNumber = scan.nextInt();
        File accountFile = new File("account_"+accountNumber);
        if(!accountFile.exists()){
            System.err.println("Account not found for number "+ accountNumber);
        }else {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println("Please enter the amount to be withdrawn");
                int withdrawAmount = sc.nextInt();
                //read data from account file
                Scanner accountReader = new Scanner(new FileInputStream(accountFile)).useDelimiter("--");
                String accNum = accountReader.next();
                String accName = accountReader.next();
                int balance = Integer.parseInt(accountReader.next());
                if(withdrawAmount > balance ){
                    System.err.println("Withdrawal amount is bigger than the current amount.\nChoose the option again.");
                    return;
                }else{
                    balance -= withdrawAmount;
                    // write data into existing file
                    PrintWriter outputStream = new PrintWriter(new FileWriter(accountFile));
                    outputStream.printf("%d--%s--%d", accountNumber, accName, balance);
                    System.out.println("Account is updated successfully");
                    outputStream.close();
                    System.out.println("Account balance after Withdrawal is: "+ balance);
                    accountReader.close();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

    }
    public void createFolder(){

        Scanner s = new Scanner(System.in);
        System.out.println("Please enter folder name ");
        String fodlerName = s.next();
        File folder = new File(fodlerName);
        folder.mkdir();
        System.out.println("Folder is created successfully");
        folder.isDirectory();
    }

}
