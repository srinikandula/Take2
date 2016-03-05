package Devendra;

/**
 * Created by devendra on 2/26/2016.
 */
public class OutBoundEx {
    public static void main(String[] args) {
        try {
            int [] d = {1,2,3,4,5,6};
            d[6]=99;
            System.out.println(d[6]);
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("this is array index out of bound Exception :" + e.getMessage());
            //e.printStackTrace();
        }finally {
            System.out.println("Thank you");
        }

    }
}
