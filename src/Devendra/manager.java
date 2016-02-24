package payroll;

/**
 * Created by devendra on 2/23/2016.
 */
    public  class manager extends employee {

    public  int benifits;

        public manager (int id, String name,int salary, int tax, int benifits)
        {
            super(id,name,salary,tax);
            this.benifits = benifits;

        }

    public int getBenifits(int i) {
        return benifits;
    }

    public void setBenifits(int benifits) {
        this.benifits = benifits;
    }
   /* public void print(){
            System.out.println("the manager has special benifits like" + benifits);
        }*/
    }



