package srini.streams;

import java.io.*;
import java.util.Scanner;

/**
 * Created by skandula on 2/29/16.
 */
public class ATMSimulatorWithPOJO {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        ATMSimulatorWithPOJO api = new ATMSimulatorWithPOJO();
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

        try {
            Account account = new Account();
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
                ObjectOutputStream objectOutputStream =
                        new ObjectOutputStream(new FileOutputStream(accountFile));
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
                ObjectInputStream objectInputStream =
                        new ObjectInputStream(new FileInputStream(accountFile));
                Account account = (Account) objectInputStream.readObject();

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
}
