package payroll;

/**
 * Created by devendra on 2/23/2016.
 */
public class MySalary {
    public static void main(String[] args) {
        employee best = new employee(66,"gude",5500,500);
        manager dev = new manager(99,"DEVENDRA",6600,200,2000);
        System.out.println("the id of the employee is"+dev.getId());
        System.out.println("the name of the employee is"+dev.getName());
        System.out.println("the salary of the employee is"+dev.getSalary());
        System.out.println("the tax of the employee is"+dev.getTax());
        System.out.println("the benifits of the employee is"+dev.getBenifits(2000));
       best.print();
        dev.print();
    }
}
