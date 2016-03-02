package com.stringexamples;

/**
 * Created by devendra on 2/26/2016.
 */
        public class RandomNumbersExample {
    public static void main(String[] args) {
        int dev[] = new int[10];
        int min = dev[0];
        int max = dev[0];

        for(int i=0; i <10 ; i++) {

            int s = (int) (Math.random() * 100);
            System.out.println(s);

            dev[i] = s;



            if (min == 0){
                min =s;
            }
            if (dev[i] > max) {
                max = dev[i];
            }
            if (dev[i] < min) {
                min = dev[i];
            }

        }
        System.out.println("The maximum number is " + max);
        System.out.println("The minimum number is " + min);

    }
}
