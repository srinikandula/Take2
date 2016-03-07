package Amar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Amar on 3/5/2016.
 */
public class ATM {
    public static void main(String[] args) {
        List<AccountForPOJO> accounts = new ArrayList<>();
        List<AccountForPOJO> acc = new ArrayList<>();
        List<AccountForPOJO> orders = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            AccountForPOJO account = new AccountForPOJO();

            account.setId(new Double(Math.random() * 10).longValue());
            account.setBalance(new Double(Math.random() * 10).longValue());


            accounts.add(account);
            acc.add(account);
            orders.add(account);
        }
        for (AccountForPOJO account : accounts) {
            System.out.println("ATM" + "  " + account.getId() + "  " + " $ " +account.getBalance());
        }

        Collections.sort(accounts);

        System.out.println("\nAfter sort by Balance");
        for (AccountForPOJO account : accounts) {
            System.out.println("ATM" + "  " + account.getId() +"  " + " $ " +  account.getBalance());
        }
        //using Comparator
        Collections.sort(orders, new AccountForPOJO());
        System.out.println("\nAfter sort by ID ");
        for(AccountForPOJO order:orders){
            System.out.println("ATM" + "  " +order.getId() +"  " + " $ " +  order.getBalance());
        }
    }
}
