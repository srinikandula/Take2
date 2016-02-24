package srini;

/**
 * Created by skandula on 2/23/16.
 */
public class Employee {
    private int id;
    private String name;

    public Employee(){
        id = 101;
        name = "Foo";
    }
    public Employee(int i){
        id = i;
    }

    public void setId(int i){
        id = i;
    }
    public void setName(String n){
        name = n;
    }
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
}
