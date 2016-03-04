
    package keerthi;

    import java.io.File;
    import java.util.ArrayList;
    import java.util.Scanner;

    public class ATMPojoCollections {

        ArrayList<Account> arrayList = new ArrayList<Account>();

        public static void main(String[] args) {

            ATMPojoCollections atm = new ATMPojoCollections();
            Scanner sc = new Scanner(System.in);

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
            Account account = new Account();
            System.out.println("please enter your details");
            System.out.println(" Name ");
            account.setName(sc.next());
            System.out.println("Account type " );
            account.setAccType(sc.next());
            System.out.println("account number " );
            account.setAccNum(sc.nextLong());
            System.out.println("initial balance " );
            account.setAmount(sc.nextInt());
            arrayList.add(account);
            System.out.println("Account is created successfully");
        }

            public void findBalance(){
                Scanner sc = new Scanner(System.in);

                System.out.println("Enter your account number");
                long accNumber = sc.nextLong();
                for (Account account: arrayList){
                /*for(int i=0;i<arrayList.size();i++){
                   Account account =  arrayList.get(i);*/
                if(account.getAccNum() == accNumber){
                    System.out.println("Available balance in your account is " +account.getAmount());
                }else{
                    System.out.println("account does not exists");
                    }
                }

            }


        public void toDeposit(){
            Scanner sc = new Scanner(System.in);
            System.out.println("enter your account number");
            long accNumber = sc.nextLong();
            for(int i=0;i<arrayList.size();i++){
                Account account = arrayList.get(i);
                if(account.getAccNum() == accNumber){
                    System.out.println("enter the amount you want to deposit");
                    Scanner scanner = new Scanner(System.in);
                    int depositAmount = sc.nextInt();
                    int balance =  account.getAmount();
                    balance = balance + depositAmount;
                    account.setAmount(balance);
                    System.out.println("your balance after deposit is " +account.getAmount());
                }
                else{
                    System.out.println("invalid account number");
                }
            }
            //int depositAmount = sc.nextInt();
        }

        public void toWithdraw(){
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter you account number");
           long accNumber = sc.nextLong();
            for (int i=0;i<arrayList.size();i++){
                Account account = arrayList.get(i);
                if(account.getAccNum() == accNumber){
                    System.out.println("Enter the amount to withdraw");
                    Scanner scanner = new Scanner(System.in);
                    int balance = account.getAmount();
                    int withdrawAmount = scanner.nextInt();
                    if(withdrawAmount > balance){
                        System.out.println("insufficient finds available");
                    }
                    else{
                        balance = balance - withdrawAmount;
                        account.setAmount(balance);
                        System.out.println("available balance after withdraw is " +account.getAmount());

                    }
                }
            }
        }

        public void deleteAccount(){
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter your account number");
            long accNumber = sc.nextLong();
            for(int i=0; i<arrayList.size(); i++){
               Account account = arrayList.get(i);
                if(account.getAccNum() == accNumber){
                    arrayList.remove(account);
                    System.out.println("Account is deleted successfully");
                }
            }
        }

        public void createFolder(){
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter your folder name");
            String folderName = sc.nextLine();
            File file = new File("keerthi.txt");
            file.mkdir();
            file.isDirectory();



        }


    }




