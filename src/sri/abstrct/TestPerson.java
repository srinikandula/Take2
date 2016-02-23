package sri.abstrct;

/**
 * Created by SREEDHAR on 2/22/2016.
 */
public class TestPerson {
    public  static  void  main(String rgs[]){
        Person p=new Employee("sri","male",0);
        Person p1=new Employee("ram","male",33);
        p.work();
        System.out.print(p.toString());
        System.out.print(p1.toString());
    }
}
