package Keerthi.Sort.ComparatorEx;

/**
 * Created by CrazyNaveen on 3/6/16.
 */
public class Manager {
    private int id;
    private String name;
    private int salary;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }


    public boolean equals(Object o){
        if(o == null){
            return false;
        }
        else if(this == o){
            return  true;

        }
        if( o instanceof Manager){
            Manager employee = (Manager) o;
            if(employee.getName() == this.getName()){
                return  true;
            }
            else{
                return  false;
            }
        }
        else{
            return  false;
        }
    }
}
