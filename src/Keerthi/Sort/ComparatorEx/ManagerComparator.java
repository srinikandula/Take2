package Keerthi.Sort.ComparatorEx;

import java.util.Comparator;

/**
 * Created by CrazyNaveen on 3/6/16.
 */
public class ManagerComparator implements Comparator<Manager>{


        @Override
        public int compare(Manager emp1, Manager emp2) {

            if(emp1.getSalary() == (emp2.getSalary())){
                return  emp1.getName().compareTo(emp2.getName());
            }
        /*String empFirst = emp1.getName().toUpperCase();
        String empSecond = emp2.getName().toUpperCase();
        if (empFirst.equals(empSecond)) {
            return empFirst.compareTo(empSecond);
        }
        */
            else if(emp1.getSalary() > emp2.getSalary()){
                return  1;
            }
            else {
                return -1;
            }
        }
    }
