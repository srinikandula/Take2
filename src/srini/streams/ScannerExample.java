package srini.streams;

import java.util.Scanner;

/**
 * Created by skandula on 2/29/16.
 */
public class ScannerExample {
    public static void main(String[] args) {
        String input = "1 fish 2 fish red fish blue fish";
        Scanner s = new Scanner(input).useDelimiter("\\s*fish\\s*");
        System.out.println(s.next());
        System.out.println(s.next());
        System.out.println(s.nextInt());
        System.out.println(s.next());
        System.out.println(s.next());
        s.close();
    }
}
