package Devendra;

import com.sun.org.apache.xpath.internal.SourceTree;

import javax.xml.bind.SchemaOutputResolver;
import java.io.*;
import java.util.Scanner;
import java.util.concurrent.SynchronousQueue;

/**
 * Created by devendra on 3/2/2016.
 */
public class AtmPojo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AtmPojo api = new AtmPojo();
        int option = 0;
        do {
            System.out.println("Please select from the option.....");
            System.out.println("1.Create Account");
            System.out.println("2.Account balance");
            System.out.println("3.Delete Account");
            System.out.println("4.Deposit");
            System.out.println("5.Withdraw");
            System.out.println("6.Create folder");
            System.out.println("7.Exit");
            option = sc.nextInt();
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
                    api.Deposit();
                    break;
                case 5:
                    api.Withdraw();
                    break;
                case 6:
                    System.out.println("Please enter folder name ");
                    String folderName = sc.next();
                    File folder = new File(folderName);
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
        Scanner sc = new Scanner(System.in);
        Account acc = new Account();
        System.out.println("Please enter the account number");
        acc.setAccNum(sc.nextLong());
        System.out.println("Please enter the First name");
        acc.setFirstName(sc.next());
        System.out.println("Please enter the Last name");
        acc.setLastName(sc.next());
        System.out.println("Please enter your account balance");
        acc.setBalance(sc.nextDouble());
        System.out.println("Please enter your SSN number");
        acc.setSsn(sc.nextLong());
        System.out.println("Please enter your account type");
        acc.setAccountType(sc.next());

        String fileName = "account" + acc.getAccNum();
        System.out.println("Checking for the file.........");
        File accountFile = new File(fileName);
        if (accountFile.exists()) {
            System.out.println("Sorry !!!! Account already exits with this number." + acc.getAccNum());
        }
        else {
            try {
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(accountFile));
                objectOutputStream.writeObject(acc);
                objectOutputStream.close();
                System.out.println("Account is Created Successfully");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void findAccountBalance() {
        Scanner sc = new Scanner((System.in));
        Account acc = new Account();
        System.out.println("Please enter your account number");
        long accNum2 = sc.nextLong();
        File accountFile = new File("account" + accNum2);
        if (!accountFile.exists()) {
            System.err.println("The account number you entered is not valid..." +acc.getAccNum());
        }
        else {
            try {
                ObjectInputStream objectInputStream1 = new ObjectInputStream(new FileInputStream(accountFile));
                Account account = (Account) objectInputStream1.readObject();
                objectInputStream1.close();
                System.out.println("The account balance is " + account.getBalance());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        }

    }

    public void deleteAccount() {
        Scanner sc = new Scanner(System.in);
        Account account = new Account();
        System.out.println("Please enter the account number to be deleted....");
        long accNum = sc.nextLong();
        File accountFile = new File("account" + accNum);
        if (!accountFile.exists()) {
            System.err.println("The account number you entered is not valid..." + account.getAccNum());
        } else {
            accountFile.delete();
            System.out.println("Requested account has been deleted.");
        }
    }

    public void Deposit() {
        Scanner sc = new Scanner(System.in);
         Account account = new Account();
        System.out.println("Please enter the account number");
        long accNumb = sc.nextLong();
        File accountFile = new File("account" + accNumb);
        if (!accountFile.exists()) {
            System.out.println("You number you entered is not valid.");
        } else {
            ObjectInputStream objectInputStream1 = null;

            try {
                objectInputStream1 = new ObjectInputStream(new FileInputStream(accountFile));
                Account account1 = (Account) objectInputStream1.readObject();
                objectInputStream1.close();
                double balance = account.getBalance();
                System.out.println("Please enter the amount you would like to deposit..");
                Scanner dg = new Scanner(System.in);
                int deposit = dg.nextInt();
                balance = balance + deposit;
                account.setBalance(balance);
                System.out.println("Your total balance after the deposit is" + account.getBalance());
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(accountFile));
                objectOutputStream.writeObject(account);
                objectOutputStream.close();

            } catch (FileNotFoundException e) {
                e.printStackTrace();

            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        }





                public void Withdraw(){
                    Scanner scanner = new Scanner(System.in);
                    //account Account = new account();
                    System.out.println("Please enter the account number");
                    long accNum = scanner.nextLong();
                    File accountFile = new File ("account"+accNum);
                    if(!accountFile.exists()){
                        System.out.println("You number you entered is not valid.");
                    }else{
                        ObjectInputStream objectInputStream1 = null;
                        try {
                            objectInputStream1 = new ObjectInputStream(new FileInputStream(accountFile));
                            Account account = (Account) objectInputStream1.readObject();
                            double balance = account.getBalance();
                            System.out.println("Please enter the amount you would like to deposit..");
                            Scanner dg = new Scanner(System.in);
                            int withdraw =dg.nextInt();
                            if(withdraw > balance){
                                System.err.println("Please enter the amount within the balance range..");
                            }else
                                balance = withdraw-balance;
                            account.setBalance(balance);
                            System.out.println("Your total balance after the deposit is"+balance);
                            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(accountFile));
                            objectOutputStream.writeObject(account);
                            objectOutputStream.close();
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                }

                }
