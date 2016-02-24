package Amar;
/**
 * Created by Amar on 2/22/2016.
 */

public class SUV extends AmarVehicleMethods
{
   private double weight;

   public SUV(String make, String model, int year, double weight)
   {
      super(make, model, year);
      this.weight = weight;
   }

   public double getWeight()
   {
      return weight;
   }
   
     
   //It over rides the print method in immediate parent class
   public void print()
   {
      super.print();
      System.out.println("Vehicle Weight in tons: " + weight);
   }
   
   /*
   //It overloads the print method in immediate parent class
   
   //@Override- to check that this print method does not overide
   public void print(String Amar)
   {
      System.out.print("Owner: " + Amar);
      super.print();
   }
   */
}