package Devendra;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by devendra on 3/5/2016.
 */
public class SortBank {
    public static void main(String[] args) {
        List<Bank> bank = new ArrayList<>();
        List<Bank> bk = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Bank banks = new Bank();
            banks.setid(new Double(Math.random() * 100).intValue());
            banks.setaccount(new Double(Math.random()*6500000).intValue());
            bank.add(banks);
            bk.add(banks);
        }

        for (Bank banks : bank) {
            System.out.println("The bank id's are->" + banks.getId()+"-accounts numbers are-->"+banks.getAccount());

        }
        System.out.println("After Sorting");
        Collections.sort(bank, new BankComparator());
        for (Bank banks : bank) {
            System.out.println("The bank id's are -->"+banks.getId()+"accounts numbers are-->"+banks.getAccount());

        }
        System.out.println("After sorting with account numbers");
        Collections.sort(bk,new BankComparator());
        for(Bank banks: bk ) {
            System.out.println(banks.getAccount()+" "+banks.getId());
        }
    }
}
