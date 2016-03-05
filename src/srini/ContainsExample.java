package srini;

import srini.streams.Account;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by skandula on 3/5/16.
 */
public class ContainsExample {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        List<Account> accounts = new ArrayList<>();
        for(int i=0;i<10;i++){
            list.add(i);
            Account account = new Account();
            account.setAccNum(new Long(i));
            account.setFirstName("Fname" + i);
            accounts.add(account);

        }

        Account account = new Account();
        //account.equals();
        account.setAccNum(new Long(6));
        account.setSsn(23424);
        account.setFirstName("foo");

        Account account1 = new Account();
        //account.equals();
        account1.setAccNum(new Long(6));

        Integer i1 = new Integer(6);
        Integer i2 = new Integer(6);

        System.out.println("i1.equals(i2) " + i1.equals(i2));
        System.out.println("i1 == i2 " + (i1 == i2));

        System.out.println("Contains 6?-" + list.contains(6));
        System.out.println("Contains 16?-"+list.contains(16));
        System.out.println("account.equals(account) "+ account.equals(account));

        System.out.println("Contains account with id 6?-"+accounts.contains(account));
        System.out.println("account == account1 - "+(account==account1));
        System.out.println("account == account - "+(account==account));

    }
}
