package Devendra;
/**
 * Created by devendra on 2/24/2016.
 */
public class StringLowerToUpper {
    public static void main(String[] args) {
        String dev ="devendra";
        String d1 = new String(dev);
        System.out.println(d1.toUpperCase());
        int d2 = dev.length();
        System.out.println(d2);
        String s3 = ".gude";
        String d4 = dev.concat(s3);
        System.out.println(d4);
        System.out.println(d4.toUpperCase());

    }
}
