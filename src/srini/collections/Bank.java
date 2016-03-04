package srini.collections;

import srini.streams.Account;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by skandula on 3/2/16.
 */
public class Bank {

    public static void main(String[] args) {
         int[] accounts = new int[10];
         Account[] accs = new Account[10000];

        ArrayList arrayList = new ArrayList(100);
        LinkedList linkedList = new LinkedList();

        long start = System.currentTimeMillis();


        for(int i=0; i<linkedList.size(); i++){
            Account account = (Account)linkedList.get(i);
            if(account.getAccNum() == 100){
                System.out.println(account.getBalance());
            }
        }

        
        /*

        long end = System.currentTimeMillis();
        System.out.println("Adding to linkedlist took " + (end-start) +"ms");


        start = System.currentTimeMillis();
        for(int i=0;i< 100000;i++){
            arrayList.add("account "+(i+1));
            arrayList.add(new Account());
        }
         end = System.currentTimeMillis();

        System.out.println("Adding to arraylist took " + (end-start) +"ms");



        start = System.currentTimeMillis();
       Object obj = linkedList.get(90000);
        end = System.currentTimeMillis();

        System.out.println("Accessing from linkedlist took " + (end-start) +"ms");


        start = System.currentTimeMillis();
         obj = arrayList.get(90000);
        end = System.currentTimeMillis();

        System.out.println("Accessing from arrayList took " + (end-start) +"ms");

*/


    }


}
