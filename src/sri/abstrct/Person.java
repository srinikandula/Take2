package sri.abstrct;

/**
 * Created by SREEDHAR on 2/22/2016.
 */
public abstract class Person {

        private String name;
        private String gender;

        public Person(String name, String gender){
            this.name=name;
            this.gender=gender;
        }

        public abstract void work();

        @Override
        public String toString(){
            return "Name="+this.name+" Gender="+this.gender;
        }

}


