package Amar;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Amar on 3/2/2016.
 */
public class AmarATMSimulatorForCollection {
    //ArrayList<AmarAccountForCollection> actArr = new ArrayList<AmarAccountForCollection>();
    ArrayList<AmarAccountForCollection> actArr;
    public AmarATMSimulatorForCollection(){
        this.actArr = new ArrayList<AmarAccountForCollection>();
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        AmarATMSimulatorForCollection api = new AmarATMSimulatorForCollection();

        int option = 0;
        do{
            System.out.println("Please make your selection");
            System.out.println("1.Create Account");
            System.out.println("2.Account balance");
            System.out.println("3.Delete Account");
            System.out.println("4.Deposit");
            System.out.println("5.Withdraw");
            System.out.println("6.Create folder");
            System.out.println("7.Display Account Details");
            System.out.println("8.Exit");
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
                    api.displayAccounts();
                    break;
                case 8:
                    System.out.println("Thank you for using our ATM simulator");
                    System.exit(1);
                default:
                    System.err.println("invalid option selected");
            }
        }while(option !=8 );
    }
    public void createAccount(){
        Scanner scanner = new Scanner(System.in);
        try {
            AmarAccountForCollection account = new AmarAccountForCollection();

            System.out.println("Please enter the account number");
            long accountNumber = scanner.nextLong();
            account.setAccNum(accountNumber);
            System.out.println("Please enter the first name");
            account.setFirstName(scanner.next());
            System.out.println("Please enter the last name");
            account.setLastName(scanner.next());
            System.out.println("Please enter the account balance");
            account.setBalance(scanner.nextInt());
            System.out.println("Please enter SSN");
            account.setSsn(scanner.nextInt());
            //check if the account exists already
            AmarAccountForCollection actAlready = null;
            for ( AmarAccountForCollection temp : actArr){
                if (temp.getAccNum() == accountNumber ) {
                    //System.out.println("A" + temp.getAccNum());
                    actAlready = temp ;
                    break;
                }
            }
            if(actAlready != null){
                System.err.println("Account already exists with account number: " + actAlready.getAccNum());
            } else {
                actArr.add(account);
                System.out.println("Account is successfully created.");
            }
        } catch (InputMismatchException e) {
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void findAccountBalance(){
        //read account number from console
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter the account number");
            int accountNumber = scanner.nextInt();
            //look up the account file
            AmarAccountForCollection actAlready = null;
            for (AmarAccountForCollection temp : actArr) {
                if (temp.getAccNum() == accountNumber) {
                    //System.out.println("A" + temp.getAccNum());
                    actAlready = temp;
                    break;
                }
            }
            if (actAlready != null) {
                System.out.println("Account Balance: " + actAlready.getBalance());
            } else {
                System.err.println("Account not found for number " + accountNumber);
            }
        }catch (InputMismatchException e) {
            e.printStackTrace();
        }
    }
    public void deleteAccount(){
        //read account number
        try {
            System.out.println("deleteAccount called");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter the account number: ");
            int accountNumber = scanner.nextInt();

            AmarAccountForCollection actAlready = null;
            for (AmarAccountForCollection temp : actArr) {
                if (temp.getAccNum() == accountNumber) {
                    System.out.println("Deleting the account number: " + temp.getAccNum());
                    actAlready = temp;
                    break;
                }
            }
            if (actAlready != null) {
                actArr.remove(actAlready);
                System.out.println("Successfully deleted account number: " + actAlready.getAccNum());
            } else {
                System.out.println("The account not there.");
            }
        }catch (InputMismatchException e) {
            e.printStackTrace();
        }
    }
    public void makeDeposit() {
        //read account number from console
        try{
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter the account number");
            int accountNumber = scanner.nextInt();
            //look up the account file
            AmarAccountForCollection actAlready = null;
            for (AmarAccountForCollection temp : actArr) {
                if (temp.getAccNum() == accountNumber) {
                    //System.out.println("A" + temp.getAccNum());
                    actAlready = temp;
                    break;
                }
            }
            if (actAlready != null) {
                try {
                    Scanner sc = new Scanner(System.in);
                    System.out.println("Please enter the amount to be deposited");
                    double depositAmount = sc.nextDouble();
                    double balance = actAlready.getBalance();
                    balance += depositAmount;
                    actAlready.setBalance(balance);
                    System.out.println("Account balance after deposit:" + actAlready.getBalance());
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            } else {
                System.err.println("Account not found for number " + accountNumber);
            }
        }catch(InputMismatchException e) {
            e.printStackTrace();
        }
    }

    public void makeWithdrawal(){
        //read account number from console
        try {

            Scanner scan = new Scanner(System.in);
            System.out.println("Please enter the account number");
            int accountNumber = scan.nextInt();
            AmarAccountForCollection actAlready = null;
            for ( AmarAccountForCollection temp : actArr){
                if (temp.getAccNum() == accountNumber ) {
                    actAlready = temp ;
                    break;
                }
            }
            if(actAlready != null){
                Scanner sc = new Scanner(System.in);
                System.out.println("Please enter the amount to be Withdrawal");
                double withdrawAmount = sc.nextDouble();
                double balance = actAlready.getBalance();
                if (withdrawAmount > balance) {
                    System.err.println("Withdrawal amount is bigger than the current amount.\nChoose the option again.");
                    return;
                }else{
                    balance -= withdrawAmount;
                    actAlready.setBalance(balance);
                    System.out.println("Account is updated successfully");
                    System.out.println("Account balance after Withdrawal is: "+ actAlready.getBalance());
                }
            } else {
                System.err.println("Account not found for number " + accountNumber);
            }
        }catch (InputMismatchException e) {
            e.printStackTrace();
        }
    }
    public void displayAccounts(){
        try {
            int i = 0;
            for (AmarAccountForCollection temp : actArr) {
                System.out.println("Account details : " + i + ":" + temp.getAccNum() + ":" + temp.getFirstName()+ ":"+ temp.getLastName() + ":" + "$"+temp.getBalance());
                i = i + 1;
            }
            System.out.println(actArr.get(1));
        }catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }
    }
    public void createFolder(){

        Scanner s = new Scanner(System.in);
        System.out.println("Please enter folder name ");
        String folderName = s.next();
        //File folder = new File("C:\\Users\\BMW\\Documents\\GitHub\\Take2\\src\\Amar\\"+ folderName);
        //folder.mkdir();
        //System.out.println("Folder created successfully");
        //boolean created = folder.mkdir();
        //folder.mkdirs();
        //boolean created = folder.mkdirs();
        //System.out.println("Is Folder created successfully? " + created);
        //folder.isDirectory();

    }
}
