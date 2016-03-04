package Amar;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by Amar on 3/3/2016.
 */
public class AmarBank {
            public static void main(String[] args) {
            int[] accounts = new int[10];
            AmarAccountForCollection[] accs = new AmarAccountForCollection[10000];

            ArrayList arrayList = new ArrayList(100);
            LinkedList linkedList = new LinkedList();

            long start = System.currentTimeMillis();


            for(int i=0; i<linkedList.size(); i++){
                AmarAccountForCollection account = (AmarAccountForCollection)linkedList.get(i);
                if(account.getAccNum() == 100){
                    System.out.println(account.getBalance());
                }
            }
                for(int i=0;i< 10;i++){
                    arrayList.add("account "+(i+1));
                    arrayList.add(new AmarAccountForCollection());
                    System.out.println(arrayList.get(i));
                }

        /*

        long end = System.currentTimeMillis();
        System.out.println("Adding to linkedlist took " + (end-start) +"ms");


        start = System.currentTimeMillis();

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

