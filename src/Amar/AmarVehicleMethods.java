/**
 * Created by Amar on 2/22/2016.
 */

public class AmarVehicleMethods
{
   private String make;
   private String model;
   private int year;

   public AmarVehicleMethods(String make, String model, int year)
   {
      this.make = make;
      this.model = model;
      this.year = year;
   }

   public String getMake()
   {
      return make;
   }

   public String getModel()
   {
      return model;
   }

   public int getYear()
   {
      return year;
   }
   
   // Here we can prefix the method with "final" to avoid the override 
   //during complilation as in print method "final void print()"
   
   public void print()
   {
      System.out.println("Make: " + make + ", Model: " + model + ", Year: " + year);
     
   }
}