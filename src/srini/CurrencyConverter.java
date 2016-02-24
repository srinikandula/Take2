package srini;


import java.text.DecimalFormat;

/**
 * Created by skandula on 2/23/16.
 */
public class CurrencyConverter {

    public static void main(String[] args) {
        int i = 104;  // $104.00
        double d = 104.346d;
        double d1 =  123456.789d;
        DecimalFormat myFormatter = new DecimalFormat("###,###.##");
        System.out.println(myFormatter.format(i));

        System.out.println(myFormatter.format(d));
        System.out.println(myFormatter.format(d1));
        System.out.println(Math.ceil(d));

        System.out.println(Math.floor(d));
        for(i=0; i< 10;i++){
            double randomDouble = Math.floor(Math.random()*100);
            Double doubleObj = new Double(randomDouble);
            int randomInt = doubleObj.intValue();
            System.out.println(randomInt);

            //Math.ceil(0.354 * 100)
        }

    }
}
