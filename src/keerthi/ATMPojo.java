    package keerthi;

    import java.io.*;
    import java.util.Scanner;

    /**
    * Created by CrazyNaveen on 3/2/16.
    */
    public class ATMPojo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ATMPojo atm = new ATMPojo();
        int option = 0;
        do{
            System.out.println("please make your selection");
            System.out.println("1.Create Account");
            System.out.println("2.Account balance");
            System.out.println("3.Deposit");
            System.out.println("4.Withdraw");
            System.out.println("5.Create Folder");
            System.out.println("6.Delete Account");
            System.out.println("7.Exit");
            option = sc.nextInt();
            switch (option){
                case 1:
                    atm.createAccount();
                    break;
                case 2:
                    atm.findBalance();
                    break;
                case 3:
                    atm.toDeposit();
                    break;
                case 4:
                    atm.toWithdraw();
                    break;
                case 5:
                    atm.createFolder();
                    break;
                case 6:
                    atm.deleteAccount();
                    break;
                case 7:
                    System.out.println("Thanks for using our ATM");
                    System.exit(1);
                default:
                        System.err.println("Invalid option is selected");

            }

        }while (option !=7) ;

    }

    public void createAccount(){
        Scanner sc = new Scanner(System.in);
        Account acc = new Account();
        System.out.println("please enter your details");
        System.out.println("first name ");
        acc.setFirstName(sc.next());
        System.out.println("last name " );
        acc.setLastName(sc.next());
        System.out.println("Account type " );
        acc.setAccType(sc.next());
        System.out.println("account number " );
        acc.setAccNum(sc.nextLong());
        System.out.println("initial balance " );
        acc.setAmount(sc.nextInt());

        String fileName = "Account_"+acc.getAccNum();
        System.out.println("checking for file");
        File accountFile = new File(fileName);

        if(accountFile.exists()){
            System.err.println("Account already exists with the number " +acc.getAccNum());

        }
        else{
            try {
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(accountFile));
                objectOutputStream.writeObject(acc);
                objectOutputStream.close();
                System.out.println("Account is created successfully");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public void findBalance(){
        Scanner sc= new Scanner(System.in);
        Account acc = new Account();
        System.out.println("Enter your account number ");
        long accNUmber = sc.nextLong();
        File accountFile = new File("account_"+accNUmber);
        if(!accountFile.exists()){
            System.err.println("Account not found for number "+ acc.getAccNum());
        }else {

            try {
                ObjectInputStream objectInputStream1 = new ObjectInputStream(new FileInputStream(accountFile));
               Account account = (Account) objectInputStream1.readObject();
                objectInputStream1.close();
                System.out.println("Account balance is "+account.getAmount());
            } catch (IOException e) {
                e.printStackTrace();
            } catch(ClassNotFoundException e){
                e.printStackTrace();
                }
            }

            }


    public void toDeposit(){
        Scanner sc= new Scanner(System.in);
        Account acc = new Account();
        System.out.println("Enter your account number");
        long accNUmber = sc.nextLong();
        File accountFile = new File("account_"+accNUmber);
        if(!accountFile.exists()){
            System.err.println("Account not found for number "+ acc.getAccNum());
        }else {
            ObjectInputStream objectInputStream1 = null;
            try {
                objectInputStream1 = new ObjectInputStream(new FileInputStream(accountFile));
                Account account = (Account) objectInputStream1.readObject();
                objectInputStream1.close();
                int initialAmount =  account.getAmount();
                System.out.println("Enter the amount you want to deposit");
                Scanner sc1= new Scanner(System.in);
                int depositAmount = sc1.nextInt();
                initialAmount = initialAmount + depositAmount;
                account.setAmount(initialAmount);
                //account.setAmount(initialAmount);
                System.out.println("your total balance after deposit is " +account.getAmount());
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(accountFile));
                System.out.println("Amount is deposited successfully..");
                objectOutputStream.writeObject(account);
                objectOutputStream.close();



            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }


        }

    }

    public void toWithdraw(){
        Scanner sc= new Scanner(System.in);
        Account acc = new Account();
        System.out.println("Enter your account number");
        long accNUmber = sc.nextLong();
        File accountFile = new File("account_"+accNUmber);
        if(!accountFile.exists()){
            System.err.println("Account not found for number "+ acc.getAccNum());
        }else {
            ObjectInputStream objectInputStream1 = null;
            try {
                objectInputStream1 = new ObjectInputStream(new FileInputStream(accountFile));
                Account account = (Account) objectInputStream1.readObject();
                objectInputStream1.close();
                int initialAmount =  account.getAmount();
                System.out.println("Enter the amount you want to withdraw");
                Scanner sc1= new Scanner(System.in);
                int withdrawAmount = sc1.nextInt();
                initialAmount = initialAmount - withdrawAmount;
                account.setAmount(initialAmount);
                //account.setAmount(initialAmount);
                System.out.println("your total balance after withdraw is " +account.getAmount());
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(accountFile));
                objectOutputStream.writeObject(account);
                objectOutputStream.close();



            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }


        }



    }
    public void createFolder(){
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter folder name ");
        String folderName = s.nextLine();
        File folder = new File("/Users/CrazyNaveen/AbstractAndInterface/src/keerthi/" + folderName );
        folder.mkdir();
        folder.isDirectory();

    }

    public void deleteAccount(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the account number");
        int accountNumber = scanner.nextInt();

        File accountFile = new File("account_"+accountNumber);
        if(!accountFile.exists()){
            System.err.println("Account not found for number "+ accountNumber);
        }else {

            try {
                ObjectInputStream objectInputStream1 = new ObjectInputStream(new FileInputStream(accountFile));
                accountFile.delete();
                objectInputStream1.close();
                System.out.println("Account has been deleted");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }



    }

    }
