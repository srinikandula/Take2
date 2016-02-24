package srini;

/**
 * Created by skandula on 2/23/16.
 */
public class ConstructorExample {

    public static void main(String[] args) {
        Employee emp = new Employee();
        Employee empWithId= new Employee(23);

        System.out.println(emp.getId());
        System.out.println(empWithId.getId());


    }
}
