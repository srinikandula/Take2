package Keerthi;

/**
 * Created by CrazyNaveen on 2/23/16.
 */
public class Employee extends AbstractEx implements InterfaceEx{
    private int id;
    private String firstName;
    private String lastName;
    private int salary;
    //private String address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    /*public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }*/



    public boolean isEmployeeAvailable() {
        System.out.println("hello");
        return false;
    }



    public String employeeAddress(String firstName, String lastName) {
        String city = "New Jersey";
        if((firstName.equals("keerthi")) && (lastName.equals("pathapally"))) {

            //System.out.println("city is " + city);
            return city;
        }
        return  "no value";

    }


    public boolean insertEmployee() {
        return false;
    }


    public String employeeDetails(int id) {
        if(id == 1){
            System.out.println("details of first employee");
            return "details";
        }else
        System.out.println("employee id does not exist, create new one");
        return "error";
    }
}
