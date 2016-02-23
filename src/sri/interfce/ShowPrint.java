package sri.interfce;

/**
 * Created by SREEDHAR on 2/22/2016.
 */
public class ShowPrint implements Printable,Showable {
    public void show(){
        System.out.println("I am in show method");
    }
    public void print(){
        System.out.println("I am in print method");
    }
}
