package srini;

/**
 * Created by skandula on 2/26/16.
 */
public class ExceptionExample {
    public static void main(String[] args) {
        try {
            //open a database connection
            int[] array = new int[5];
            array[4] = 45;

            String str = "232";
            int i = Integer.parseInt(str);
            //close the connetion

            String newString = null;
            System.out.println(newString.substring(2));
            System.out.println("This is end of try block");

        }catch (ArrayIndexOutOfBoundsException e) {  // executed only when exception occurs
            System.err.println("catch for ArrayIndexOutOfBoundsException " + e.getMessage());
        }catch (NumberFormatException e) {  // executed only when exception occurs
            System.err.println("catch for NumberFormatException " + e.getMessage());
        }catch (StringIndexOutOfBoundsException e) {  // executed only when exception occurs
            System.err.println("Exception for super class");
            e.printStackTrace();
        }finally {// executed always
            System.out.println("This is finally block");
        }
        System.out.println("This is after catch block");
    }
}
