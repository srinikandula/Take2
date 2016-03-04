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
<<<<<<< HEAD
                BufferedReader in = new BufferedReader(new InputStreamReader(urlStream.openStream()));

=======
                try {
                    BufferedReader in = new BufferedReader(new InputStreamReader(urlStream.openStream()));
>>>>>>> 0e82abb7c1afed99d29844da9d528bd89f33d81d
                    String inputLine;
                    while ((inputLine = in.readLine()) != null) {
                        if (inputLine.contains("AngularJS")) {
                            System.out.println(inputLine);
                        }
                    }
                    in.close();

<<<<<<< HEAD
=======

                } catch (IOException e) {
                    e.printStackTrace();
                }
>>>>>>> 0e82abb7c1afed99d29844da9d528bd89f33d81d


            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
    }

