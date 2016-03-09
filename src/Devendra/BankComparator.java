package Devendra;

import java.util.Comparator;

/**
 * Created by devendra on 3/5/2016.
 */
    public class BankComparator implements Comparator<Bank> {


    @Override
    public int compare(Bank b1, Bank b2) {
        if (b1.getId() == b2.getId()) {
            if (b1.getAccount() == b2.getAccount()) {
                return 0;
            } else if (b1.getAccount() > b2.getAccount()) {
                return 1;
            } else {
                return -1;
            }
        } else if (b1.getId() > b2.getId()) {
            return 1;
        } else {
            return -1;
        }
    }
}







