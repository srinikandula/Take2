package Amar;

/**
 * Created by Amar on 2/24/2016.
 */
public class AmarCheckString {

    public static void main(String args[]){

        String original= "How are You Doing";
        String newString1 = "";

        for (int i = 0; i < original.length(); i++) {
            if (Character.isLowerCase(original.charAt(i))) {
                newString1 = newString1 + Character.toUpperCase(original.charAt(i));
            }else newString1 = newString1 + original.charAt(i);
        }

        String newString2 = original.toUpperCase( );

        System.out.println("The original string is: " +original);
        System.out.println("Using Check if for lowercase: " +newString1);
        System.out.println("Using direct method toUpperCase: " +newString2);
    }

}
