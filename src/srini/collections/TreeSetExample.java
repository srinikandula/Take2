package srini.collections;

import srini.streams.Account;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by skandula on 3/6/16.
 */
public class TreeSetExample {
    public static void main(String[] args) {
        Set<Account> accounts = new TreeSet<>();
        accounts.add(new Account());
        System.out.println("Account has been added\n");

        Set<Order> hashOrders = new HashSet<>();
        hashOrders.add(new Order());
        System.out.println("Account has been added to HashSet\n");

        Set<Order> orders = new TreeSet<>();
        orders.add(new Order());
    }
}
