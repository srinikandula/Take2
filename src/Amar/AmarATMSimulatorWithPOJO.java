package Amar;

import java.io.*;
import java.util.Scanner;
/**
 * Created by Amar on 3/2/2016.
 */
public class AmarATMSimulatorWithPOJO {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        AmarATMSimulatorWithPOJO api = new AmarATMSimulatorWithPOJO();
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
        Scanner scanner = new Scanner(System.in);
        try {
            AccountForPOJO account = new AccountForPOJO();
            System.out.println("Please enter the account number");
            account.setAccNum(scanner.nextInt());
            System.out.println("Please enter the first name");
            account.setFirstName(scanner.next());
            System.out.println("Please enter the last name");
            account.setLastName(scanner.next());
            System.out.println("Please enter the account balance");
            account.setBalance(scanner.nextInt());
            System.out.println("Please enter SSN");
            account.setSsn(scanner.nextInt());
            //check if the account exists already
            String fileName = "account_"+account.getAccNum();
            System.out.println("Checking for file");
            File accountFile = new File(fileName);
            if(accountFile.exists()){
                System.err.println("Account already exists with the number" + account.getAccNum());
            }else {
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(accountFile));
                objectOutputStream.writeObject(account);
                System.out.println("Account is created successfully");
                objectOutputStream.close();
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
        //look up the account file
        File accountFile = new File("account_"+accountNumber);
        if(!accountFile.exists()){
            System.err.println("Account not found for number "+ accountNumber);
        }else {
            try {
                //read data from account file
                ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(accountFile));
                AccountForPOJO account = (AccountForPOJO) objectInputStream.readObject();
                System.out.println("Account balance is "+ account.getBalance());
                System.out.println("SSN found on account is  "+ account.getSsn());
                objectInputStream.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    public void deleteAccount(){
        //read account number
        System.out.println("deleteAccount called");
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
                ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(accountFile));
                AccountForPOJO account = (AccountForPOJO) objectInputStream.readObject();
                double balance = account.getBalance();
                objectInputStream.close();
                balance += depositAmount;
                account.setBalance(balance);
                System.out.println("Account balance after Deposit is: "+ account.getBalance());
                // write data into existing file
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(accountFile));
                objectOutputStream.writeObject(account);
                System.out.println("Account is updated successfully");
                objectOutputStream.close();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
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
                ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(accountFile));
                AccountForPOJO account = (AccountForPOJO) objectInputStream.readObject();
                double balance = account.getBalance();
                objectInputStream.close();
                if(withdrawAmount > balance ){
                    System.err.println("Withdrawal amount is bigger than the current amount.\nChoose the option again.");
                    return;
                }else{
                    balance -= withdrawAmount;
                    account.setBalance(balance);
                    // write data into existing file
                    ObjectOutputStream objectOutputStream =
                            new ObjectOutputStream(new FileOutputStream(accountFile));
                    objectOutputStream.writeObject(account);
                    objectOutputStream.close();
                    System.out.println("Account is updated successfully");
                    System.out.println("Account balance after Withdrawal is: "+ account.getBalance());
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }catch (FileNotFoundException e) {
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
        String folderName = s.next();
        File folder = new File("C:\\Users\\BMW\\Documents\\GitHub\\Take2\\src\\Amar\\"+ folderName);
        folder.mkdir();
        System.out.println("Folder created successfully");
        //boolean created = folder.mkdir();
        //folder.mkdirs();
        //boolean created = folder.mkdirs();
        //System.out.println("Is Folder created successfully? " + created);
        folder.isDirectory();

    }
}
