package Amar;
/**
 * Created by Amar on 2/22/2016.
 */

public class CheckingAccount extends AmarAccountMethods
{
   public CheckingAccount(long amount)
   {
      super("Amar checking A/c", amount);
   }

   public void withdraw(long amount)
   {
      setAmount(getAmount() - amount);
   }
}