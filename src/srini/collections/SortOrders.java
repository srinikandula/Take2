package srini.collections;

import srini.streams.Account;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by skandula on 3/5/16.
 */
public class SortOrders {
    public static void main(String[] args) {
        List<Order> orders = new ArrayList<>();
        for(int i=0;i<10;i++){
            Order order = new Order();
            order.setOrderId(new Double(Math.random() * 100).intValue());
            order.setQuantity(new Double(Math.random() * 100).intValue());
            orders.add(order);
        }
        for(Order order:orders){
            System.out.println(order.getOrderId());
        }
        System.out.println("After ordering");
        //Collections.sort(orders);
        Collections.sort(orders, new OrderComparator());
        for(Order order:orders){
            System.out.println(order.getOrderId());
        }
    }
}
