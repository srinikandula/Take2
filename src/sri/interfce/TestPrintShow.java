package sri.interfce;

/**
 * Created by SREEDHAR on 2/22/2016.
 */
public class TestPrintShow {
     public static void main(String args[]){
        Printable p=new ShowPrint();
         Showable p1=new ShowPrint();
         p.print();
         p1.show();
    }
}
