package sri.abstrct;

/**
 * Created by SREEDHAR on 2/22/2016.
 */
public class Employee extends Person {
    private int empId;

    public Employee(String name, String gender, int id) {
        super(name, gender);
        this.empId=id;
    }

    @Override
    public void work() {
        if(empId == 0){
            System.out.println("Not working");
        }else{
            System.out.println("Working as employee!!");
        }
    }

    public static void main(String args[]){
       Person student = new Employee("sri","male",0);
        Person employee = new Employee("raj","Male",12);
        student.work();
        employee.work();
       System.out.println(employee.toString());
    }

}
