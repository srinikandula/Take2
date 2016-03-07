package srini.collections;

import srini.streams.Account;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by skandula on 3/6/16.
 */
public class HashcodeExample {
    public static void main(String[] args) {
        Set<Account> accounts = new HashSet<>();
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
