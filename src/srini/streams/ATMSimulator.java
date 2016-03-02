package srini.streams;

import java.io.*;
import java.util.Scanner;

/**
 * Created by skandula on 2/29/16.
 */
public class ATMSimulator {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        ATMSimulator api = new ATMSimulator();
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
                    String fodlerName = s.nextLine();
                    File folder = new File(fodlerName);
                    folder.mkdir();
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
            System.out.println("Please enter the account number");
            int accountNumber = scanner.nextInt();
            System.out.println("Please enter the account name");
            String name = scanner.nextLine();
            System.out.println("Please enter the account balance");
            int accountBalance = scanner.nextInt();

            //accountnumber--accountname--balance
            String accountRecord = String.format("%d--%s--%d", accountNumber,name, accountBalance);

            //check if the account exists already
            String fileName = "account_"+accountNumber;
            System.out.println("Checking for file");
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
        //look up the account file
        File accountFile = new File("account_"+accountNumber);
        if(!accountFile.exists()){
            System.err.println("Account not found for number "+ accountNumber);
        }else {
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
