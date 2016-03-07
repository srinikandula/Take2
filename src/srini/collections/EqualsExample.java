package srini.collections;

import srini.streams.Account;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by skandula on 3/6/16.
 */
public class EqualsExample {
    public static void main(String[] args) {

        Integer[] array = {2,5,6,7,8,4};

        //traditional
        List<Integer> numbers = new ArrayList<>();
        for(int i:array){
            numbers.add(i);
        }

        List<Integer> numbersList = Arrays.asList(array);

        List<Account> accounts = new ArrayList<>();
        for(int i=0; i<10;i++){
            Account account = new Account();
            account.setAccNum((long)i);
            account.setFirstName("FName"+i);
            accounts.add(account);
        }
        for(Account account:accounts){
            System.out.println(account.getAccNum() +"  "+ account.getFirstName());
        }
        System.out.println(" Account with id 6 found? " + accounts.contains(new Account(6)));
        System.out.println(" Account with id 6 found? " + accounts.contains(new Account(16)));

    }
}
