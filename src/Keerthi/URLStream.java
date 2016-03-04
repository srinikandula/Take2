    package Keerthi;


    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.net.MalformedURLException;
    import java.net.URL;

    /**
     * Created by CrazyNaveen on 3/2/16.
     */
    public class URLStream {
        public static void main(String[] args) {

            URL urlStream = null;
            try {
                urlStream = new URL("http://angular.github.io/protractor/#/getting-started");
                try {
                    BufferedReader in = new BufferedReader(new InputStreamReader(urlStream.openStream()));
                    String inputLine;
                    while ((inputLine = in.readLine()) != null) {
                        if (inputLine.contains("AngularJS")) {
                            System.out.println(inputLine);
                        }
                    }
                    in.close();


                } catch (IOException e) {
                    e.printStackTrace();
                }


            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
    }

