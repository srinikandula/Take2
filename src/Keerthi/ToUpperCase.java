package keerthi;

/**
 * Created by CrazyNaveen on 2/24/16.
 */
public class ToUpperCase {

    public void convertToUpperCase(){
        String s1 = "hello world";
        String s2 = "";
        for(int i=0; i<=s1.length()-1;i++){
            char c = s1.charAt(i);
            System.out.print(c);

            if(c >= 32 && c < 122 ){
                c = (char)(c - 32);
                s2 = s2 +c;
            }
        }
        System.out.println(" ");
        System.out.println(s2);
    }
    public static void main(String[] args) {
        String s1= "hello world";
<<<<<<< HEAD
        //String s2 = s1.toUpperCase();
        //System.out.println(s2);
=======
        String s2 = s1.toUpperCase();
        System.out.println(s2);
>>>>>>> e764153dbc6b22df9ea4c3955adc62b8292a2e38
        ToUpperCase t = new ToUpperCase();
        t.convertToUpperCase();
    }
}
