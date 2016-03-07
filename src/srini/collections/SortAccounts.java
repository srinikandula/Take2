package srini.collections;

import srini.streams.Account;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by skandula on 3/4/16.
 */
public class SortAccounts {
    public static void main(String[] args) {
        List<Account> accounts = new ArrayList();
        for(int i=0; i<10;i++){
            Account account = new Account();
            account.setAccNum(new Double(Math.random()*1000).longValue());
            account.setFirstName("FName"+i);
            accounts.add(account);
        }
        for(Account account:accounts){
            System.out.println(account.getAccNum() +"  "+ account.getFirstName());
        }
        Collections.sort(accounts);

        System.out.println("\nAfter sorting");
        for(Account account:accounts){
            System.out.println(account.getAccNum() +"  "+ account.getFirstName());
        }
        /*
        for (int i = 0; i < accounts.size(); i++) {

            for (int j = 1; j < (accounts.size() - i); j++) {
                if (accounts.get(j - 1).getAccNum() > accounts.get(j).getAccNum()) {
                    tempAccount = accounts.remove(j-1);
                    accounts.add() = numArray[j];
                    numArray[j] = temp;
                }
            }
        }
        */
    }
}
