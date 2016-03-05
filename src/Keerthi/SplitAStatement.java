package Keerthi;


public class SplitAStatement {

    public static void main(String[] args) {

        String input = "Process finished with exit code";
        String[] newArray = input.split("\\s+");//(" "),("\\W+")
        //int length =  input.length();
        for (int i = 0; i < newArray.length; i++) {
            System.out.println(newArray[i]);
        }
    }

}
