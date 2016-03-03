package srini.streams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by skandula on 3/1/16.
 */
public class URLStreamExample {
    public static void main(String[] args) {
        URL oracle = null;
        try {
            oracle = new URL("http://angular.github.io/protractor/#/getting-started");
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(oracle.openStream()));

            String inputLine;
            while ((inputLine = in.readLine()) != null)
                inputLine.contains("MR.Bean");
                System.out.println(inputLine);
            in.close();


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
