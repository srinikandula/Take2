package Amar;

import javax.swing.text.AttributeSet;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.parser.ParserDelegator;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Amar on 3/2/2016.
 */
public class AmarSearchStringURL {
    public static void main(String[] args) {
        URL oracle = null;
        try {
            oracle = new URL("http://angular.github.io/protractor/#/getting-started");
            BufferedReader in = new BufferedReader(new InputStreamReader(oracle.openStream()));

            String inputLine;
            if ((inputLine = in.readLine()) != null && (inputLine.startsWith("To"))){
                //inputLine.contains("A");
                try {
                    System.out.println(inputLine);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            System.out.println(inputLine);
            in.close();


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
