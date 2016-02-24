package Amar;

/**
 * Created by Amar on 2/24/2016.
 */
public class AmarReverseString {
    public static void main(String args[]){
        String original = "amarender", reverse = "";
        System.out.println("Original string entered is : " + original);
        int length = original.length();
        for (int i = length - 1; i >= 0 ; i-- ){
            reverse = reverse + original.charAt(i);
        }
        System.out.println("Reverse of entered string is: "+reverse);
    }

}
