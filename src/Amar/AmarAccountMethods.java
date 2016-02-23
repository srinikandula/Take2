/**
 * Created by Amar on 2/22/2016.
 */

public class AmarAccountMethods {

   private String name;
   private long amount;

   public AmarAccountMethods(String name, long amount) {
      this.name = name;
      setAmount(amount);
   }
   
   public void setAmount(long amount)
   {
      this.amount = amount;
   }
   
   public void deposit(long amount)
   {
      this.amount = this.amount+ amount;
   }

   public String getName()
   {
      return name;
   }

   public long getAmount()
   {
      return amount;
   }
}