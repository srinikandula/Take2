/**
 * Created by skandula on 2/21/16.
 */
public abstract class College implements School,Interface {
    private int[] depts;
    private String[] employees;
    private String name;
    private String address;
    private String city;
    protected String grantsId;

    public void setCity(String input){
        city = input;
    }

    public String getCity(){  //non-abstract or concrete methods
        return city;
    }
    public void admitStudent(String id){  //method overloading
        System.out.println("College: Admitting student in to college");
    }
    public void admitStudent(String id, String specialization){ // method overloading
        System.out.println("Admitting student in to college with specialization");
    }

    public static String getType(){
        return "College";
    }

}

