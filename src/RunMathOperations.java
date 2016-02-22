/**
 * Created by skandula on 2/21/16.
 */
public class RunMathOperations {
    public static void main(String[] args) {
        MathOperations math = new MathOperations();

        for(int i=2;i<=100;i++) {
            //System.out.println(i + " is prime "+ math.isPrime(i));
        }




        int i = 30;
        math.modifyValue(i); //pass by value
        System.out.println("Value of int after modification " + i);

        int[] numbers = new int[10];
        numbers[0] = 200;
        math.modifyValue(numbers); //pass by reference
        System.out.println("Value of numbers[0] after modification " + numbers[0]);

        StringBuilder name = new StringBuilder("Foo ");
        math.modifyValue(name); //pass by reference
        System.out.println("Value of String after modification " + name);

    }
}
