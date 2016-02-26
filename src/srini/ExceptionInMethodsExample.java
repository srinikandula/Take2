package srini;

/**
 * Created by skandula on 2/26/16.
 */
public class ExceptionInMethodsExample {
    public static void main(String[] args) {
        try {
            ExceptionInMethodsExample example = new ExceptionInMethodsExample();
            example.method1();
            example.login("foo", "ereer");
        }catch (MyException e) {
            System.err.println("this is an application exception");
        }catch (NumberFormatException e) {
            System.err.println("build user friendly message for  NumberFormatException");
        }catch (RuntimeException e) {
            System.err.println("Your authentication information is incorrect. Please try again.");
        }
    }

    public void method1(){
        System.out.println("Start: method1()");
        method2();
        System.out.println("End: method1()");
    }
    public void method2(){
        System.out.println("Start: method2()");
        method3();
        System.out.println("End: method2()");
    }
    public void method3(){
        System.out.println("Start: method3()");
        method4();
        System.out.println("End: method3()");
    }
    public void method4(){

            System.out.println("Start: method4()");
            method5();
            System.out.println("End: method4()");

        System.out.println("Completing method4");
    }
    public void method5(){
        System.out.println("Start: method5()");
        Integer.parseInt("123");
        System.out.println("End: method5()");
    }
    public void login(String username, String password) {
        try {
            Class.forName("abc");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        if(username.equals("foo") && password.equals("bar")) {
            System.out.println("login success");
        }else {
            throw new MyException("login failed");
        }
    }
}
