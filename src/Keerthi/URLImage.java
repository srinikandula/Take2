package Keerthi;


import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by CrazyNaveen on 3/2/16.
 */
public class URLImage {

    public static void main(String[] args) {
        URL img = null;
        try {
            img = new URL("http://www.funonline.in/wp-content/uploads/2011/12/Mr.-Bean-Cartoon-Photo-e1325063243535.jpg");
            InputStream in = new BufferedInputStream(img.openStream());
            OutputStream out = new BufferedOutputStream(new FileOutputStream("Mr.Bean.jpg"));

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
