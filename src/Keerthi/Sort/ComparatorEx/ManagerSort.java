package Keerthi.Sort.ComparatorEx;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by CrazyNaveen on 3/6/16.
 */
public class ManagerSort {
    public static void main(String[] args) {

        ArrayList<Manager> arrayList = new ArrayList();

        Manager employee1 = new Manager();
        employee1.setName("keerthi");
        employee1.setSalary(9000);

        Manager employee2 = new Manager();
        employee2.setName("kavya");
        employee2.setSalary(8000);

        Manager employee3 = new Manager();
        employee3.setName("KEERTHI");
        employee3.setSalary(8000);

        Manager employee4 = new Manager();
        employee4.setName("kavya");
        employee4.setSalary(9000);

        arrayList.add(employee1);
        arrayList.add(employee2);
        arrayList.add(employee3);
        arrayList.add(employee4);

        System.out.println(" without sort by employee name");
        for(int i=0;i<4;i++){
            Manager emp  = arrayList.get(i);
            String nameEmp = emp.getName();
            int sal = emp.getSalary();
            System.out.println(nameEmp+ " " + sal);
        }

        Collections.sort(arrayList, new ManagerComparator());

        System.out.println("with sort by employee name");
        for(int i=0;i<arrayList.size();i++){
           Manager emp  = arrayList.get(i);
            String nameEmp = emp.getName();
           int sal = emp.getSalary();
            System.out.println(nameEmp+ " " + sal);
        }

    }
}
