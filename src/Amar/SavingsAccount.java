/**
 * Created by Amar on 2/22/2016.
 */

public class SavingsAccount extends AmarAccountMethods
{
   public SavingsAccount(long amount)
   {
      super("Amar Savings A/c", amount);
   }
   
   public void withdraw(long amount)
   {
      setAmount(getAmount() - amount);
   }

}