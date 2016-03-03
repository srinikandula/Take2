package FileIO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by devendra on 3/2/2016.
 */
public class URLStreams {
    public static void main(String[] args) {
        URL de = null;
        try {
            de = new URL("https://www.duolingo.com/guidelines");
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(de.openStream()));
                    String inputLine;
                while  ((inputLine = in.readLine()) != null){
                  if (inputLine.contains("German")){
                System.out.println(inputLine);}}
                in.close();
            } catch (MalformedURLException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

    }
}
