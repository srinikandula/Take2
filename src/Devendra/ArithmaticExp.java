package Devendra;

/**
 * Created by devendra on 2/26/2016.
 */
public class ArithmaticExp {
    public static void main(String[] args){
       try {
           int g = 1 / 0;
           System.out.println(g);
       }
       catch(ArithmeticException e){
           System.out.println("Division by 0  " +e.getMessage());
          // e.printStackTrace();
       }finally {
           System.out.println("Thank you");
       }
    }
}
