/**
 * Created by skandula on 2/21/16.
 */
public class MathOperations {

    public boolean isPrime(int n){
        boolean b = true;
        for(int i=2;i<n/2;i++){
            if(n%i==0){
                b = false;
                break;
            }
        }
        return b;
    }

    public void modifyValue(int i) {
        i = 100;
    }
    public void modifyValue(StringBuilder name) {
        name.append("bar");
    }

    public void modifyValue(int[] numbers) {
        numbers[0] = 300;
     }
}
