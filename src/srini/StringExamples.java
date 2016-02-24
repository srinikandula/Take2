package srini;

/**
 * Created by skandula on 2/23/16.
 */
public class StringExamples {

    public static void main(String[] args) {
        String str = "Hello World";
        System.out.println(str.charAt(2));

        System.out.println(str.compareTo("How Are you")); //0/1/-1
        System.out.println(str.compareTo("hello world")); //0/1/-1
        System.out.println(str.compareTo("Hello World")); //0/1/-1
        System.out.println(str.compareToIgnoreCase("hello world")); //0/1/-1
        String subString = str.substring(2);
        System.out.println(subString);
        System.out.println(str.substring(2,4));
    }
}
