package srini.collections;

import srini.streams.Account;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by skandula on 3/5/16.
 */
public class SetExample {
    public static void main(String[] args) {
<<<<<<< HEAD
        Set<Account> accounts = new HashSet();
=======
        Set<Account> accounts = new HashSet<>();

>>>>>>> b0ec09d77b4885d3937cdd646abd87041ac6b03a
        for(int i=0;i<10;i++){
            Account account = new Account();
            account.setAccNum(new Long(i));
            account.setFirstName("Fname" + i);
            accounts.add(account);
        }
        for(Account account:accounts){
            System.out.println(account.getAccNum()+"  "+ account.getSsn());
        }
        System.out.println("Size of accounts set= "+accounts.size());
        Account account = new Account();
        //account.equals();
        account.setAccNum(new Long(6));
        account.setSsn(23424);
        account.setFirstName("foo");
       // System.out.println(accounts.iterator().next().equals(account));
       // System.out.println("Set contains " + accounts.contains(account));


        System.out.println("Result of addding a duplicate "+ accounts.add(account));
        if(accounts.contains(account)){
            accounts.remove(account);
            accounts.add(account);
        }
        System.out.println("After adding a new account size of accounts set= " + accounts.size());
        for(Account acc:accounts){
            System.out.println(acc.getAccNum()+"  "+ acc.getSsn());
        }

    }
}
