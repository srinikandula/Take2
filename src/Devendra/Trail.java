package com.stringexamples;

/**
 * Created by devendra on 2/24/2016.
 */
public class Trail {
    public static void main(String[] args) {
        String dev = "How are you doing";
        for (String d : dev.split(" ",4)){
            System.out.println(d);
        }
    }
}
