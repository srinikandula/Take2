package keerthi;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Employee emp = new Employee();
        emp.employeeDetails(2);
        System.out.println(emp.employeeDetails(2));
        System.out.println(emp.employeeAddress("keerthi","pathapally")) ;
        MethodOverLoading mol = new MethodOverLoading();
        System.out.println(emp.isEmployeeAvailable());

        mol.methodOne();
        mol.methodOne("keerthi");
        mol.methodOne(1);
        mol.methoOne(1,"keerthi");
        mol.methoOne("keerthi",1);
        mol.employeeAddress("kavya" , "pathapally");

    }
}
