/**
 * Created by skandula on 2/22/16.
 */
public class StateCollege extends College{

    private String stateId;
    public String getStateId(){
        grantsId = "st123";
        return stateId;
    }
    public void setStateId(String stateId){
        stateId = stateId;
    }

    public void admitStudent(String id, String specialization){ //method overridding
        if(specialization == "CS"){
            System.err.println("StateCollege: Sorry this specialization is not available");
            return; //break;
        }
        System.out.println("StateCollege: Admitting student in to college with specialization");
    }

    @Override
    public boolean isStudentAvailable(String firstName, String lastName) {
        return false;
    }

}
