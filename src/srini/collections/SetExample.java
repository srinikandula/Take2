package srini.collections;

import srini.streams.Account;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by skandula on 3/5/16.
 */
public class SetExample {
    public static void main(String[] args) {
        Set<Account> accounts = new HashSet<>();
        for(int i=0;i<10;i++){
            Account account = new Account();
            account.setAccNum(new Long(i));
            account.setFirstName("Fname" + i);
            accounts.add(account);
        }
        System.out.println("Size of accounts set= "+accounts.size());
        Account account = new Account();
        //account.equals();
        account.setAccNum(new Long(0));
        account.setSsn(23424);
        account.setFirstName("foo");
        System.out.println(accounts.iterator().next().equals(account));
        System.out.println("Set contains " + accounts.contains(account));


        accounts.add(account);
        System.out.println("After adding a new account size of accounts set= " + accounts.size());

    }
}
