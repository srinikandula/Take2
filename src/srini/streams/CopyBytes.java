package srini.streams;

/**
 * Created by skandula on 2/26/16.
 */
import java.io.*;

public class CopyBytes {
    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        FileInputStream in = new FileInputStream("CopyBytesInput.txt");
        FileOutputStream out = new FileOutputStream("CopyBytesOutput.txt", true);;
        try {
            int c = in.read();
            while (c != -1) {
                out.write(c);
                c = in.read();
            }
            System.out.println("File has been copied");
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("Reading with input streams took " + (end-start));

        start = System.currentTimeMillis();

        BufferedReader inputStream = null;
        PrintWriter outputStream = null;

        try {
            inputStream = new BufferedReader(new FileReader("CopyBytesInput.txt"));
            outputStream = new PrintWriter(new FileWriter("characteroutput.txt"));

            String l;
            while ((l = inputStream.readLine()) != null) {
                outputStream.println(l);
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }
        end = System.currentTimeMillis();
        System.out.println("Reading with buffered streams took " + (end-start));


    }
}