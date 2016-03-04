        package keerthi;

        import java.io.File;
        import java.util.*;

        /**
         * Created by CrazyNaveen on 3/4/16.
         */
        public class ATMUsingMap {

            Map<Long, Account> accounts = new HashMap<Long, Account>();

            public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);
                ATMUsingMap atm = new ATMUsingMap();
                int option =0;
                do
                {
                    System.out.println("Please make your selection ");
                    System.out.println("1.Create Account");
                    System.out.println("2.Account balance");
                    System.out.println("3.Deposit");
                    System.out.println("4.Withdraw");
                    System.out.println("5.Delete Account");
                    System.out.println("6.Exit");
                    option = scanner.nextInt();
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
                            atm.deleteAccount();
                            break;
                        case 6:
                            System.out.println("Thanks for using our ATM");
                            System.exit(1);
                            default:
                                System.err.println("Invalid option is selected");
                    }
                }
                while (option != 6);
            }

            public void createAccount(){
                Scanner scanner = new Scanner(System.in);
                Account account = new Account();
                System.out.println("Enter your Name");
                account.setName(scanner.next());
                System.out.println("Enter your Account number");
                long accountNumber = scanner.nextLong();
                account.setAccNum(accountNumber);
                System.out.println("Enter your Account type");
                account.setAccType(scanner.next());
                System.out.println("Enter your initial amount");
                account.setAmount(scanner.nextInt());
                accounts.put(accountNumber,account);//account number and account class object as key and value
                System.out.println("Account is created successfully");
            }

            public void findBalance(){
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter your account number");
                long accNumber = scanner.nextLong();
                Account account = accounts.get(accNumber);//accessing account using account number as a key
                    if(account.getAccNum() == accNumber){
                        System.out.println("Balance in your account is " +account.getAmount());
                    }
                    else{
                        System.out.println("Invalid account number");
                    }
                }


            public void toDeposit(){
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter your account number");
                long accNumber = scanner.nextLong();
                Account account = accounts.get(accNumber);
                    if(account.getAccNum() == accNumber){
                        System.out.println("Enter the amount you want to deposit");
                        Scanner sc = new Scanner(System.in);
                        int depositAmount = sc.nextInt();
                       int balance = account.getAmount();
                        balance = balance + depositAmount;
                        account.setAmount(balance);
                        System.out.println("Your transaction is successful");
                        System.out.println("Your total balance after deposit is " +account.getAmount());
                    }
                else{
                        System.out.println("Error in transaction..");
                    }
                }

            public void toWithdraw(){
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter your account number");
                long accountNumber = scanner.nextLong();
                Account account = accounts.get(accountNumber);
                if(account.getAccNum() == accountNumber){
                    System.out.println("Enter the amount to withdraw");
                    Scanner sc = new Scanner(System.in);
                    int withdrawAmount = sc.nextInt();
                    int balance = account.getAmount();
                    if(withdrawAmount > balance ){
                        System.out.println("Insufficient funds... Check your balance..");
                    }
                    else{
                        balance = balance - withdrawAmount;
                        account.setAmount(balance);
                        System.out.println("Your transaction is successful");
                        System.out.println("Your available balance after withdraw is " +account.getAmount());
                    }
                }
                else{
                    System.out.println("Invalid account number");
                }

            }


            public  void deleteAccount(){
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter the account number yoou want to delete");
                long accNumber = scanner.nextLong();
                accounts.remove(accNumber);
                System.out.println("Your account is deleted successfully");
            }

        }
