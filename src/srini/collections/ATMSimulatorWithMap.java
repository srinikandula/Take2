package srini.collections;

import srini.streams.Account;

import java.io.File;
import java.util.*;

/**
 * Created by skandula on 2/29/16.
 */
public class ATMSimulatorWithMap {
    private Map<Long, Account> accounts = new HashMap<Long, Account>();

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        ATMSimulatorWithMap api = new ATMSimulatorWithMap();
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
                    System.out.println("Please enter folder name ");
                    String fodlerName = s.next();
                    File folder = new File(fodlerName);
                    boolean created = folder.mkdirs();
                    System.out.println("folder created? "+ created);
                    folder.isDirectory();

                case 5:
                    System.out.println("Thank you for using our ATM simulator");
                    System.exit(1);
                default:
                    System.err.println("invalid option selected");
            }
        }while(option !=4 );

    }

    public void createAccount(){
        //read account number
        //read name
        //read balance
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the account number");
        long accountNumber = scanner.nextLong();
        System.out.println("Please enter the account name");
        String name = scanner.nextLine();
        System.out.println("Please enter the account balance");
        int accountBalance = scanner.nextInt();
        Account acc = new Account();
        acc.setAccNum(accountNumber);
        acc.setFirstName(name);
        acc.setBalance(accountBalance);
        accounts.put(accountNumber, acc);

    }
    public void findAccountBalance(){
        //read account number from console
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the account number");
        final long accountNumber = scanner.nextLong();
        Account account = accounts.get(accountNumber);
        System.out.println(account.getBalance());
    }
    public void deleteAccount(){
        //read account number
        System.out.println("deleteAccount called");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the account number");
        long accountNumber = scanner.nextInt();
        accounts.remove(accountNumber);
    }
    public void withdraw(){
        //read account number
        System.out.println("deleteAccount called");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the account number");
        long accountNumber = scanner.nextInt();
        Account account = accounts.get(accountNumber);
        System.out.println("Please enter the amount to withdraw");
        long amount = scanner.nextInt();
        if(amount > account.getBalance()){
            System.err.println("Insufficient funds");
            return;
        }
        account.setBalance(account.getBalance()-amount);
        accounts.put(accountNumber, account);
    }
}
