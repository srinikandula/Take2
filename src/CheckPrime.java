import javax.xml.bind.SchemaOutputResolver;

/**
 * Created by skandula on 2/21/16.
 */
public class CheckPrime {
    public static void main(String[] args) {
       for(int n=1; n< 100; n++) {
           isPrime(n);// method invocation
       }
        System.out.println();
       add(1,4);
       add(2.5, 6.3);
    }

    public void myFirstMethod(){
        int i =0;
        double d = 1.0;

        System.out.println("Hello world!");
    }
    //accessmodifier  returnType  methodName(parameters...)

    public static boolean isPrime(int number){ // method definition
        System.out.println("checking for prime with value "+ number);
        return true;

    }

    public static void add(int a, int b){
        System.out.println("Executing add method with int type parameters");
        isPrime(a);

    }
    public static void add(int a, int b, boolean f){
        System.out.println("Executing add method with int type parameters");
        isPrime(a);

    }

    public static void add(double a, double b){
        System.out.println("Executing add method with double type parameters");
    }
}
