package Keerthi.Sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by CrazyNaveen on 3/5/16.
 */
public class SortEmployee {

    public static void main(String[] args) {

        ArrayList<Employee> arrayList = new ArrayList();

       // Scanner sc = new Scanner(System.in);
        /*String employeeName = sc.next();
        emp.setName(employeeName);

        int employeeSalary = sc.nextInt();
        emp.setSalary(employeeSalary);
*/
       // arrayList.add(new Employee("keerthi", 7000));
       // arrayList.add(new Employee("kavya" , 9000));
        Employee emp = new Employee();
        emp.setName("keerthi");
        emp.setSalary(9000);

        Employee emp1 = new Employee();
        emp1.setName("kavya");
        emp1.setSalary(5000);

        Employee emp2 = new Employee();
        emp2.setName("keerthi");
        emp2.setSalary(2000);

        Employee emp3 = new Employee();
        emp3.setName("kavya");
        emp3.setSalary(7000);

        arrayList.add(emp);
        arrayList.add(emp1);
        arrayList.add(emp2);
        arrayList.add(emp3);

        System.out.println("before sort");
        for(int i=0;i<arrayList.size();i++) {
            System.out.println(arrayList.get(i).getName() + " " + arrayList.get(i).getSalary());

        }

        Collections.sort(arrayList);

        System.out.println("after sort");

        for(int i=0;i<arrayList.size();i++) {
            System.out.println(arrayList.get(i).getName() + " " + arrayList.get(i).getSalary());
        }

        /*System.out.println(arrayList.contains(emp));
        System.out.println(emp.equals(emp1));
        System.out.println(emp.equals(emp2));
        System.out.println(emp.compareTo(emp1));
        System.out.println(emp.compareTo(emp2));
        System.out.println(emp == emp2 );*/


        }

    }
