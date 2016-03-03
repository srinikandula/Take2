package FileIO;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by devendra on 3/2/2016.
 */
public class DownloadImage {
    public static void main(String[] args) {
        URL de = null;
        try {
            de = new URL("http://www.fromearthtotheuniverse.org/webimages/Desktops/andromeda_1024x768.jpg");
            InputStream in = new BufferedInputStream(de.openStream());
            OutputStream out = new BufferedOutputStream(new FileOutputStream("andromeda_1024x768.jpg"));

            for (int i; (i = in.read()) != -1; ) {
                out.write(i);
            }
            in.close();
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
