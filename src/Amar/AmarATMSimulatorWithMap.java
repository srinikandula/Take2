package Amar;

import java.io.File;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Amar on 3/4/2016.
 */
public class AmarATMSimulatorWithMap {
    private Map<Long, AmarAccountForCollection> actHash = new HashMap<>();

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        AmarATMSimulatorWithMap api = new AmarATMSimulatorWithMap();
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
        //read account number
        //read name
        //read balance
        try {
            Scanner scanner = new Scanner(System.in);

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
            //System.out.println("Check"+acc.getAccNum());

            long accNum = account.getAccNum();
            if (actHash.containsKey(accNum)) {
                System.err.println("Account is not created");
            } else {
                actHash.put(accountNumber, account);
                System.out.println("Successfully created with account number: " + account.getAccNum());
            }
        }catch (InputMismatchException e){
            e.printStackTrace();
        }catch (NullPointerException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public void findAccountBalance(){
        //read account number from console
       try {
           Scanner scanner = new Scanner(System.in);

           System.out.println("Please enter the account number");
           final long accountNumber = scanner.nextLong();
           AmarAccountForCollection account = actHash.get(accountNumber);
           if (account.getAccNum() == accountNumber) {
               System.out.println("Account balance is: " + account.getBalance());
           } else {
               System.err.println("Account not found");
           }
       }catch (NullPointerException e){
           e.printStackTrace();
       }catch (Exception e){
           e.printStackTrace();
       }
    }
    public void deleteAccount(){
        //read account number
        try {
            System.out.println("deleteAccount called");

            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter the account number");
            long accountNumber = scanner.nextInt();
            AmarAccountForCollection account = actHash.get(accountNumber);
            if (account.getAccNum() == accountNumber) {
                actHash.remove(accountNumber);
                System.out.println("Account is successfully removed");
            } else {
                System.err.println("Account not found");
            }
        }catch (InputMismatchException e){
            e.printStackTrace();
        }catch (NullPointerException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void makeDeposit(){
        //read account number
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter the account number");
            long accountNumber = scanner.nextInt();
            AmarAccountForCollection account = actHash.get(accountNumber);

            if (account.getAccNum() == accountNumber) {
                Scanner sc = new Scanner(System.in);
                System.out.println("Please enter the amount to deposit");
                double depositAmount = sc.nextInt();
                double balance = account.getBalance();
                balance += depositAmount;
                account.setBalance(account.getBalance() + depositAmount);
                actHash.put(accountNumber, account);
                System.out.println("Successfully deposited, account balance after deposit:" + account.getBalance());
            }else {
                System.err.println("Account does not exixts");
            }
        }catch (InputMismatchException e){
            e.printStackTrace();
        }catch (NullPointerException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void makeWithdrawal(){
        //read account number
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter the account number");
            long accountNumber = scanner.nextInt();
            AmarAccountForCollection account = actHash.get(accountNumber);
            System.out.println("Please enter the withdrawal amount");
            long withdrawAmount = scanner.nextInt();
            if (withdrawAmount > account.getBalance()) {
                System.err.println("Withdrawal amount is bigger than the current amount.\nChoose the option again.");
                return;
            } else {
                account.setBalance(account.getBalance() - withdrawAmount);
                actHash.put(accountNumber, account);
                System.out.println("Account is updated successfully");
                System.out.println("Account balance after Withdrawal is: "+ account.getBalance());
            }
        }catch (InputMismatchException e){
            e.printStackTrace();
        }catch (NullPointerException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void displayAccounts(){
        try {

            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter the account number");
            long accountNumber = scanner.nextInt();
            AmarAccountForCollection account = actHash.get(accountNumber);
            int i = 0;
            for (Map.Entry<Long, AmarAccountForCollection> temp : actHash.entrySet()) {

                System.out.println("Account details : " + i + " key = " + temp.getKey()+", First Name=" + account.getFirstName() + ", Balance=" + account.getBalance() + ", value=" + temp.getValue());

                i = i + 1;

            }
            //System.out.println(actHash.get(100));
        }catch (InputMismatchException e){
            e.printStackTrace();
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
