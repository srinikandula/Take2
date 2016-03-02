package com.ExceptionEample;

/**
 * Created by devendra on 2/26/2016.
 */
public class NullPointerEx {
    public static void main(String[] args) {
        try {
            String d = null;
            System.out.println(d.length());
        }catch (ArithmeticException e){
            System.out.println("this is arithmetic exception " +e.getMessage());
        }
        catch (Exception e) {
            System.out.println(e.getMessage()+":This cannot be defined " );
        }finally {
            System.out.println("Thank You");
        }
    }
}
