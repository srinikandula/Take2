package srini.collections;

import srini.streams.Account;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by skandula on 3/5/16.
 */
public class SetIntegerExample {
    public static void main(String[] args) {
        Set<Integer> numbers = new HashSet<>();
        for(int i=0;i<10;i++){
            numbers.add(new Integer(i));
        }
        System.out.println("Size of accounts set= " + numbers.size());
        numbers.add(new Integer(6));
        numbers.add(new Integer(6));
        numbers.add(new Integer(6));
        numbers.add(new Integer(6));
        System.out.println("After adding a new account size of accounts set= " + numbers.size());

    }
}
