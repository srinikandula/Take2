package Keerthi;

/**
 * Created by CrazyNaveen on 2/23/16.
 */
public class MethodOverLoading extends Employee{

    public void methodOne(){
        System.out.println("method which does not return anything ");

    }
    public void methodOne(int number){
        System.out.println("method which does not return anything but takes a number as argument");

    }
    public int methodOne(String name){
        int  n=0;
        System.out.println("method which returns a n integer value and takes string a input");
        return n;
    }
    public String methoOne(String name, int number){
        System.out.println("method which returns string and takes string and int as input");
        return null;
    }
    public String methoOne(int number,String name){
        System.out.println("method which returns string and takes int and string as input");
        return null;
    }
    /*public int methodOne(int number){
       int  n=0;
        return n;
    } same method names and same arguments with different return type is not allowed
*/
    public String employeeAddress(String firstName, String lastName) {
        String city = "New York";
        String error = "enter existing id";
        if((firstName.equals("kavya")) && (lastName.equals("pathapally"))) {
            System.out.println("this is sub class method");
            return city;
        }
        return error ;
    }

}
