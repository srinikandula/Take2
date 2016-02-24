package Amar;
/**
 * Using "print()" method to display over riding and over loading  Created by Amar on 2/22/2016.
 */
public class AmarVehicleDisplay {

   public static void main(String[] args){
   
      SUV AmarSuv = new SUV("Audi", "Q5", 2012, 0.75);
      System.out.println("Make = " + AmarSuv.getMake());
      System.out.println("Model = " + AmarSuv.getModel());
      System.out.println("Year = " + AmarSuv.getYear());
      System.out.println("Weight in tons = " + AmarSuv.getWeight());
      AmarSuv.print();
   }
}