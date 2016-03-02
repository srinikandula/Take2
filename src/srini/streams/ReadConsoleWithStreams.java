package srini.streams;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;

/**
 * Created by skandula on 2/29/16.
 */
public class ReadConsoleWithStreams {
    public static void main(String[] args) {
        DataInputStream inputStream = new DataInputStream(System.in);
        try {
            String line = inputStream.readLine();
            System.out.println("You entered "+ line);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
