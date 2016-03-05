package Devendra;

/**
 * Created by devendra on 2/24/2016.
 */
public class ReversingString {
    public static void main(String[] args) {

        String dev = "devendra";
        int d=dev.length()-1;
        while(d>=0){
            System.out.println(dev.charAt(d)+" ");
            d--;
        }
    }

}
