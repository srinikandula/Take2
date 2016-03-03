package Amar;

import javax.imageio.ImageIO;
import javax.swing.text.AttributeSet;
import javax.swing.text.html.*;
import javax.swing.text.html.parser.ParserDelegator;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.*;

/**
 * Created by Amar on 3/2/2016.
 */
public class AmarDownloadImageURL {
    public static void main(String args[]) throws Exception {
        // Connect to URL and get the Input Stream
        String webUrl = "http://www.hdwallpapers.in/";
        URL url = new URL(webUrl);
        URLConnection connection = url.openConnection();
        InputStream is = connection.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        //Read HTML content from Input Stream by making use of HTMLEditorKit class
        HTMLEditorKit htmlKit = new HTMLEditorKit();
        HTMLDocument htmlDoc = (HTMLDocument) htmlKit.createDefaultDocument();
        HTMLEditorKit.Parser parser = new ParserDelegator();
        HTMLEditorKit.ParserCallback callback = htmlDoc.getReader(0);
        parser.parse(br, callback, true);
        //Iterate the HTML document for IMG tags and download all images
        for (HTMLDocument.Iterator iterator = htmlDoc.getIterator(HTML.Tag.IMG); iterator.isValid(); iterator.next()) {
            AttributeSet attributes = iterator.getAttributes();
            String imgSrc = (String) attributes.getAttribute(HTML.Attribute.SRC);

            if (imgSrc != null && (imgSrc.endsWith(".jpg"))) {
                try {
                    downloadImage(webUrl, imgSrc);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    private static void downloadImage(String url, String imgSrc) throws IOException {
        BufferedImage image = null;
        try {
            //Setting condition for Absolute image path from website URL

            if (!(imgSrc.startsWith("http"))) {
                url = url + imgSrc;
            } else {
                url = imgSrc;
            }
            imgSrc = imgSrc.substring(imgSrc.lastIndexOf("/") + 1);
            String imageFormat = null;
            imageFormat = imgSrc.substring(imgSrc.lastIndexOf(".") + 1);
            String imgPath = null;
            imgPath = "C:\\Users\\BMW\\Documents\\GitHub\\Take2\\src\\Amar\\images\\" + imgSrc + "";
            URL imageUrl = new URL(url);
            image = ImageIO.read(imageUrl);
            if (image != null) {
                File file = new File(imgPath);
                ImageIO.write(image, imageFormat, file);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
