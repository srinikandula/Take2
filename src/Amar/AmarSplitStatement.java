package Amar;

/**
 * Created by Amar on 2/24/2016.
 */
public class AmarSplitStatement {

    public static void main(String args[]){

        String original = "word processor-typewriter, computer; but others, pen or pencil.";
        String []originalArray=original.split("\\W+");

        for(int i=0; i<originalArray.length; i++) {

            System.out.print(("'" + originalArray[i] + ("'") + ", " ));

        }
    }

}
