package Amar;
import java.util.Random;
/**
 * Created by Amar on 2/24/2016.
 */
public class AmarRandomNumbers {

    public static void main (String[] args)
    {
        Random generator = new Random();
        int[] randomNumbers = new int[10];
        System.out.println ("Ten Randomly Generated Numbers between 1 and 100:");
        for (int i = 0; i< randomNumbers.length; i++)
        {
            randomNumbers[i] = generator.nextInt(98) + 2;
            System.out.print (randomNumbers[i]+ ", ");
        }
        int minValue = randomNumbers[0];
        for(int i= 0; i < randomNumbers.length; i++){
            if(randomNumbers[i] < minValue){
                minValue = randomNumbers[i];
            }
        }
        int maxValue = randomNumbers[0];
        for(int i= 0; i < randomNumbers.length; i++){
            if(randomNumbers[i] > maxValue){
                maxValue = randomNumbers[i];
            }
        }
        System.out.println ("\nMinimum number among random numbers is:" + minValue);
        System.out.println ("Maximum number among random numbers is:" + maxValue);




    }

}
