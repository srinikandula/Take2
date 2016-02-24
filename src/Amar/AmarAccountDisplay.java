package Amar;

/**
 * Displaying the parent-child relationship using inheritance. Created by Amar on 2/22/2016.
 */
public class AmarAccountDisplay
{
   public static void main(String[] args)
   {
      SavingsAccount AmarSavings = new SavingsAccount(50000);
      System.out.println("Account Name: " + AmarSavings.getName());
      System.out.println("The account balance : " + AmarSavings.getAmount());
      AmarSavings.deposit(15000); // Depositing 15000 into savings account
      System.out.println("The account balance after deposit: " + AmarSavings.getAmount());
      AmarSavings.withdraw(10000); // Withdrawal of amount 10000 from savings account
      System.out.println("The account balance after withdrawal: " + AmarSavings.getAmount());


      CheckingAccount AmarChecking = new CheckingAccount(75000);
      System.out.println("Account Name: " + AmarChecking.getName());
      System.out.println("The account balance : " + AmarChecking.getAmount());
      AmarChecking.deposit(25000); // Depositing 25000 into savings account
      System.out.println("The account balance after deposit: " + AmarChecking.getAmount());
      AmarChecking.withdraw(15000); // Withdrawal of amount 3000 from checking account
      System.out.println("The account balance after withdrawal: " + AmarChecking.getAmount());
   }
}