package payroll;

/**
 * Created by devendra on 2/23/2016.
 */
public class employee {
    private int id;
    private String name;
    private int salary;
    private int tax;

    public employee (int id, String name, int salary, int tax)
    {   super();
        this.id =id;
        this.name = name;
        this.salary = salary;
        this.tax = tax;
    }

    public int getId() {

        return id;
    }
    public  int getId(int i) {
        return i;
    }
    public  int getId(String d) {
        return 100;
    }
    public  int getId(String g, int i) {
        return 100;
    }
    public  int getId( int i,String g) {
        return 100;
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

    public int getSalary()
    {
        return salary;
    }

    public void setSalary(int salary)
    {
        this.salary = salary;
    }

    public int getTax()
    {
        return tax;
    }

    public void setTax(int tax) {

        this.tax = tax;
    }

    public void print()
    {
      System.out.println("id:" + id + "Name:" + name + "salary" +salary+ "Tax" +tax);
  }
}
