public class Main {

    public static void main(String[] args) {
        int i5 = 10; //declaring a variable
        int x = 5;
        int y = 3;
        int z = x + y;
        x = x *y;
        y = x/y;
        z = x%y;  //15%5
        /*System.out.println("Hello World! The value in the variable is:" +i5);
        System.out.println("Result of multiplication is " +x);
        System.out.println("Result of division is " +y);
        System.out.println("Result of modulo is " +z);


        x = 0;

        if(x > y){

            //true block
          System.out.println("x is greter than y");
        } else {
            // false block
            System.out.println("x is not greter than y");
        }
        //loop structures
        //for(intialization; condition;increment/decrement)
        int j = 100;
        for(int i=1;i<=10;i++,j--){
            System.out.println(i +"    "+j);
        }
        //while(boolean expression){}
        int i = 0;
        while(i<=10){
            System.out.println("Value from while "+ i);
            i++;
        }
        */

        //do {
        // block
        //
        // }while(boolean)
        int a = 15465; //56451
        //reverse an integer value
        //15465%10 (divisible == 1546, reminder 5)

        //iteration1: lastdigit 5
        System.out.println("input "+ a);

        int reminder = a%10;
        int divisible = a/10;
        int result = reminder;
        System.out.println(" iteration1 - reminder = "+ reminder +"  divisible "+ divisible +" result "+ result);
        //iteration2: lastdigit 6
        a = divisible;
        reminder = a%10;
        divisible = a/10;
        result = (result * 10) + reminder;
        System.out.println(" iteration2 - reminder = "+ reminder +"  divisible "+ divisible +" result "+ result);

        //iteration3: lastdigit 4
        a = divisible;
        reminder = a%10;
        divisible = a/10;
        result = (result * 10) + reminder;
        System.out.println(" iteration3 - reminder = "+ reminder +"  divisible "+ divisible +" result "+ result);
        //iteration4: lastdigit 5
        a = divisible;
        reminder = a%10;
        divisible = a/10;
        result = (result * 10) + reminder;
        System.out.println(" iteration4 - reminder = "+ reminder +"  divisible "+ divisible +" result "+ result);

        //iteration5: lastdigit 1
        a = divisible;
        reminder = a%10;
        divisible = a/10;
        result = (result * 10) + reminder;
        System.out.println(" iteration5 - reminder = "+ reminder +"  divisible "+ divisible +" result "+ result);
        a = 15465;
        result = 0;
        while(a > 0){
            reminder = a%10;
            a = a/10;
            result = (result * 10) + reminder;
            //1%10 reminder =1, divisible = 0
        }
        System.out.println(" output from while loop is "+ result);

        /*
           Exercises
           1) Find if a number is prime
           2) Print even numbers from 1 -100
           3) Print prime numbers from 1 to 100
           4) Print first 10 fibonacci number
           5) Print squares of first 10 numbers
           6) Program to convert decimal to binary
           7) Program to convert hexadecimal to decimal



         */


    }
}
