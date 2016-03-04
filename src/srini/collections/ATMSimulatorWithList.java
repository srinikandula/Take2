package srini.collections;

import srini.streams.Account;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by skandula on 2/29/16.
 */
public class ATMSimulatorWithList {
    private ArrayList<Account> accounts = new ArrayList();

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        ATMSimulatorWithList api = new ATMSimulatorWithList();
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
        int accountNumber = scanner.nextInt();
        System.out.println("Please enter the account name");
        String name = scanner.nextLine();
        System.out.println("Please enter the account balance");
        int accountBalance = scanner.nextInt();
        Account acc = new Account();
        acc.setAccNum(accountNumber);
        acc.setFirstName(name);
        acc.setBalance(accountBalance);
        accounts.add(acc);
    }
    public void findAccountBalance(){
        //read account number from console
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the account number");
        final int accountNumber = scanner.nextInt();


        // prior JDK7
        for(int i=0; i<accounts.size();i++){
            Account account = accounts.get(i);
            if(account.getAccNum() == accountNumber){
                System.out.println(account.getBalance());
            }
        }
        //JDK 7
        for(Account account:accounts) {
            if(account.getAccNum() == accountNumber){
                System.out.println(account.getBalance());
            }
        }

        //JDK 8
        accounts.stream().filter(a -> a.getAccNum() == accountNumber).forEach(acc -> {
            System.out.println(acc.getBalance());
        });
        /*
        //JDK 8
        List<Account> filteredAccounts = accounts.stream().filter(a -> a.getBalance() > 1000).collect(Collectors.toList());

        for(Account account:accounts) {
            if(account.getBalance() > 1000){
                filteredAccounts.add(account);
            }
        }
        */

    }
    public void deleteAccount(){
        //read account number
        System.out.println("deleteAccount called");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the account number");
        int accountNumber = scanner.nextInt();
        /*
        //non-iterator
        int removeIndex = 0;
        for(int i=0; i<accounts.size();i++){
            Account account = accounts.get(i);
            if(account.getAccNum() == accountNumber){
                removeIndex = i;
                break;
            }
        }
        accounts.remove(removeIndex);
        */

        //iterator
        Iterator<Account> iterator = accounts.iterator();
        while(iterator.hasNext()){
            Account account = iterator.next();
            if(account.getAccNum() == accountNumber){
                iterator.remove();
                break;
            }
        }


    }
}
