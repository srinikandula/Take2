/**
 * Created by skandula on 2/22/16.
 */
public class UniversityCollege extends College {

    private String nationalId;

    public String getNationalId(){
        return nationalId;
    }
    public void setNationalId(String nationalId){
        nationalId = nationalId;
    }

    @Override
    public boolean isStudentAvailable(String firstName, String lastName) {
        return false;
    }
}
