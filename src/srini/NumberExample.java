package srini;

import javax.xml.bind.SchemaOutputResolver;

/**
 * Created by skandula on 2/23/16.
 */
public class NumberExample {
    public static void main(String[] args) {
        String number = "124";

        int i = Integer.parseInt(number);
        System.out.println(i);

        i = Integer.parseInt("12334");
        double d = Double.parseDouble("123345345.00");
        System.out.println(d);
        Integer num = 454;  //auto boxing
        System.out.println(num.byteValue());

    }
}
