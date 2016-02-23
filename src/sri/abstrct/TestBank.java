package sri.abstrct;

/**
 * Created by SREEDHAR on 2/22/2016.
 */
public class TestBank {
    public static void main(String args[]) {
        Bank bank = new Chase();
        Bank bank1=new Ubs();
        int chaseRate = bank.getIntrestRate();
        int ubsRate = bank1.getIntrestRate();
        System.out.println("IntrestRate of ChaseBank: "+chaseRate+"%");
        System.out.println("IntrestRate of UbsBank: "+ubsRate+"%");

    }
}
