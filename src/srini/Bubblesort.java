package srini;

/**
 * Created by skandula on 3/4/16.
 */
public class Bubblesort {
    public static void main(String[] args) {
        int[] numArray = {5,2, 45, 67,33, 47, 45};
        int temp;
        for (int i = 0; i < numArray.length; i++) {
            for (int j = 1; j < (numArray.length - i); j++) {
                if (numArray[j - 1] > numArray[j]) {
                    temp = numArray[j - 1];
                    numArray[j - 1] = numArray[j];
                    numArray[j] = temp;
                }
            }
        }
        for(int i:numArray){
            System.out.println(i);
        }
    }
}


/* {5,2, 45, 67,33, 47};  i = 0, j =4, numArray[j - 1] =5, numArray[j] = 2, temp
i=0
5    2     45   67  33   47
[0], [1], [2], [3], [4], [5]
2    5    45   33   67   47
2    5    45   33   47   67


temp = 5

*/